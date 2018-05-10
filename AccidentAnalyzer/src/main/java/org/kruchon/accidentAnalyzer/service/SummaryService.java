package org.kruchon.accidentAnalyzer.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.kruchon.accidentAnalyzer.component.SummariesCache;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.domain.SummaryResultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SummaryService {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SummariesCache summariesCache;

    @Autowired
    SummaryResultValueService summaryResultValueService;

    @Transactional
    public void save(Summary summary) {
        Session session = sessionFactory.getCurrentSession();
        session.save(summary);
        summariesCache.putSummary(summary);
    }

    public void saveAll(List<Summary> summaries){
        for(Summary summary : summaries){
            save(summary);
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


    public List<SummaryResultValue> executeAndSaveSummary(Summary summary){
        Session session = sessionFactory.getCurrentSession();
        String queryStr = summary.getQuery();
        Query query = session.createSQLQuery(queryStr);
        List<HashMap<String,String>> result = query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
        List<SummaryResultValue> summaryResultValues = convertResultToSummaryResultValues(result,summary);
        summary.setSummaryResultValues(summaryResultValues);
        summaryResultValueService.saveAll(summaryResultValues);
        save(summary);
        session.close();
        return summaryResultValues;
    }

    @Transactional
    public List<Summary> getAll(){
        Session session = sessionFactory.getCurrentSession();
        String getSummary = "FROM org.kruchon.accidentAnalyzer.domain.Summary";
        Query getSummaryQuery = session.createQuery(getSummary);
        return getSummaryQuery.list();
    }

}
