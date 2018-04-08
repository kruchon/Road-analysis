package org.kruchon.accidentAnalyzer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.utils.AccidentAdapterForMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class AccidentService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Accident accident) {
        Session session = sessionFactory.getCurrentSession();
        session.save(accident);
    }

    @Transactional
    public void saveAll(List<Accident> accidents){
        Session session = sessionFactory.getCurrentSession();
        Query alterAccidentsQuery = session.createSQLQuery("alter table accidents convert to character set 'utf8'");
        Query setNamesQuery = session.createSQLQuery("SET NAMES 'utf8'");
        Query setCharacterQuery = session.createSQLQuery("SET CHARACTER SET 'utf8'");
        alterAccidentsQuery.executeUpdate();

        setNamesQuery.executeUpdate();
        setCharacterQuery.executeUpdate();
        for(int i = 0; i<accidents.size(); i++){
            Accident accident = accidents.get(i);
            session.save(accident);
            if(i % 20 == 0){
                session.flush();
                session.clear();
            }
        }
    }

    @Transactional
    public void deleteAll(){
        Session session = sessionFactory.getCurrentSession();
        String stringQuery = "DELETE FROM org.kruchon.accidentAnalyzer.domain.Accident";
        Query query = session.createQuery(stringQuery);
        query.executeUpdate();
    }

    public Accident createFromJsonObject(JSONObject jsonObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AccidentAdapterForMapping result = mapper.readValue(jsonObject.toJSONString(),AccidentAdapterForMapping.class);
        return result.toAccident();
    }

}
