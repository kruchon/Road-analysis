package org.kruchon.accidentAnalyzer.component;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.domain.SummaryResultValue;
import org.kruchon.accidentAnalyzer.service.SummaryResultValueService;
import org.kruchon.accidentAnalyzer.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SummariesExecutor {
    @Autowired
    SummariesCache summariesCache;

    @Autowired
    SummaryService summaryService;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    SummaryResultValueService summaryResultValueService;

    @Transactional
    public void executeAndSaveAllSummaries(){
        Session session = sessionFactory.getCurrentSession();
        Collection<Summary> summaries = summariesCache.getAllSummaries();
        for(Summary summary : summaries) {
            executeAndSaveSummary(summary,session);
        }
    }

    private List<SummaryResultValue> convertResultToSummaryResultValues(List<HashMap<String,String>> result, Summary summary){
        List<SummaryResultValue> summaryResultValues = new ArrayList<SummaryResultValue>();
        for(int resultLineNumber = 0; resultLineNumber < result.size(); resultLineNumber++){
            HashMap<String,String> resultLine = result.get(resultLineNumber);
            for(Map.Entry<String,String> columnValue : resultLine.entrySet()) {
                SummaryResultValue summaryResultValue = new SummaryResultValue();
                summaryResultValue.setResultLine(resultLineNumber);
                summaryResultValue.setColumnName(columnValue.getKey());
                summaryResultValue.setValue(columnValue.getValue());
                summaryResultValue.setSummary(summary);
                summaryResultValues.add(summaryResultValue);
            }
        }
        return summaryResultValues;
    }

    public List<SummaryResultValue> executeAndSaveSummary(Summary summary,Session session){
        String queryStr = summary.getQuery();
        Query query = session.createSQLQuery(queryStr);
        List<HashMap<String,String>> result = query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
        List<SummaryResultValue> summaryResultValues = convertResultToSummaryResultValues(result,summary);
        summary.setSummaryResultValues(summaryResultValues);
        summaryResultValueService.deleteBySummaryId(summary.getId(),session);
        summaryResultValueService.saveAll(summaryResultValues,session);
        summaryService.save(summary,session);
        return summaryResultValues;
    }
}
