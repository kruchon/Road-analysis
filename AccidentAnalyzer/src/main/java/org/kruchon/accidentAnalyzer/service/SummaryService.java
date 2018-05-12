package org.kruchon.accidentAnalyzer.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kruchon.accidentAnalyzer.component.SummariesCache;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SummaryService {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SummariesCache summariesCache;

    @Autowired
    private SummaryResultValueService summaryResultValueService;

    @Transactional
    public void save(Summary summary) {
        Session session = sessionFactory.getCurrentSession();
        session.save(summary);
        summariesCache.putSummary(summary);
    }

    public void save(Summary summary,Session session) {
        session.save(summary);
        summariesCache.putSummary(summary);
    }

    public void update(Summary summary,Session session){
        session.update(summary);
        summariesCache.putSummary(summary);
    }

    @Transactional
    public void saveAll(List<Summary> summaries){
        Session session = sessionFactory.getCurrentSession();
        for(Summary summary : summaries){
            save(summary,session);
        }
    }

    public void saveAll(List<Summary> summaries, Session session){
        for(Summary summary : summaries){
            save(summary,session);
        }
    }

    @Transactional
    public List<Summary> getAll(){
        Session session = sessionFactory.getCurrentSession();
        String getSummary = "FROM org.kruchon.accidentAnalyzer.domain.Summary";
        Query getSummaryQuery = session.createQuery(getSummary);
        return getSummaryQuery.list();
    }

}
