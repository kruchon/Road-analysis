package org.kruchon.accidentAnalyzer.component;

import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.domain.SummaryResultValue;
import org.kruchon.accidentAnalyzer.service.SummaryResultValueService;
import org.kruchon.accidentAnalyzer.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class SummariesExecutor {
    @Autowired
    private SummariesCache summariesCache;

    @Autowired
    private SummaryService summaryService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SummaryResultValueService summaryResultValueService;

    @Transactional
    public void executeAndSaveAllSummaries(){
        summariesCache.resetCache();
        Session session = sessionFactory.getCurrentSession();
        Collection<Summary> summaries = summariesCache.getAllSummaries();
        for(Summary summary : summaries) {
            executeAndSaveSummary(summary,session);
        }
    }

    private List<SummaryResultValue> convertResultToSummaryResultValues(List<HashMap<String,Object>> result, Summary summary){
        List<SummaryResultValue> summaryResultValues = new ArrayList<SummaryResultValue>();
        for(int resultLineNumber = 0; resultLineNumber < result.size(); resultLineNumber++){
            HashMap<String,Object> resultLine = result.get(resultLineNumber);
            for(Map.Entry<String,Object> columnValue : resultLine.entrySet()) {
                SummaryResultValue summaryResultValue = new SummaryResultValue();
                summaryResultValue.setResultLine(resultLineNumber);
                summaryResultValue.setColumnName(columnValue.getKey());
                String value = columnValue.getValue() == null ? "" : columnValue.getValue().toString();
                summaryResultValue.setValue(value);
                summaryResultValue.setSummary(summary);
                summaryResultValues.add(summaryResultValue);
            }
        }
        return summaryResultValues;
    }

    public List<SummaryResultValue> executeAndSaveSummary(Summary summary,Session session) throws JDBCException {
        String queryStr = summary.getQuery();
        Query query = session.createSQLQuery(queryStr);
        List<HashMap<String,Object>> result = query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
        List<SummaryResultValue> summaryResultValues = convertResultToSummaryResultValues(result,summary);
        summaryResultValueService.deleteBySummaryId(summary.getId(),session);
        summaryResultValueService.saveAll(summaryResultValues,session);
        summaryService.update(summary,session);
        summariesCache.putSummary(summary,session);
        return summaryResultValues;
    }
}
