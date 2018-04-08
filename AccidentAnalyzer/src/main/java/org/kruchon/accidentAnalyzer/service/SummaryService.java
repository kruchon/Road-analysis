package org.kruchon.accidentAnalyzer.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SummaryService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Summary summary) {
        Session session = sessionFactory.getCurrentSession();
        session.save(summary);
    }

    @Transactional
    public void saveAll(List<Summary> summaries){
        for(Summary summary : summaries){
            save(summary);
        }
    }

    @Transactional
    public List executeSummary(Session session, Summary summary){
        Query query = summary.getQuery(session);
        return query.list();
    }

    @Transactional
    public List<Summary> getAll(){
        Session session = sessionFactory.getCurrentSession();
        String getSummary = "FROM org.kruchon.accidentAnalyzer.domain.impl.SummaryImpl";
        Query getSummaryQuery = session.createQuery(getSummary);
        return getSummaryQuery.list();
    }

}
