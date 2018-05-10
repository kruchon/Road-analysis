package org.kruchon.accidentAnalyzer.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.SummaryResultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SummaryResultValueService {
    @Autowired
    SessionFactory sessionFactory;

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
}
