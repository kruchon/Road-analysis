package org.kruchon.accidentAnalyzer.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kruchon.accidentAnalyzer.domain.SummaryResultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SummaryResultValueService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(SummaryResultValue summaryResultValue){
        Session session = sessionFactory.getCurrentSession();
        session.save(summaryResultValue);
    }

    @Transactional
    public void saveAll(List<SummaryResultValue> summaryResultValues){
        Session session = sessionFactory.getCurrentSession();
        for(int i = 0; i<summaryResultValues.size(); i++){
            SummaryResultValue summaryResultValue = summaryResultValues.get(i);
            session.save(summaryResultValue);
            if(i % 20 == 0){
                session.flush();
                session.clear();
            }
        }
    }

    public void save(SummaryResultValue summaryResultValue,Session session){
        session.save(summaryResultValue);
    }

    public void saveAll(List<SummaryResultValue> summaryResultValues, Session session) {
        for(int i = 0; i<summaryResultValues.size(); i++){
            SummaryResultValue summaryResultValue = summaryResultValues.get(i);
            save(summaryResultValue,session);
            if(i % 20 == 0){
                session.flush();
                session.clear();
            }
        }
    }

    public void deleteBySummaryId(Long id, Session session) {
        Query deleteQuery = session.createQuery("delete from org.kruchon.accidentAnalyzer.domain.SummaryResultValue " +
                "where summary_id = :id");
        deleteQuery.setLong("id",id);
        deleteQuery.executeUpdate();
    }

    @Transactional
    public List<SummaryResultValue> getBySummaryId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query selectQuery = session.createQuery("from org.kruchon.accidentAnalyzer.domain.SummaryResultValue " +
                "where summary_id = :id");
        selectQuery.setLong("id",id);
        return selectQuery.list();
    }
}
