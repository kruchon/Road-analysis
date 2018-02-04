package org.kruchon.accidentAnalyzer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.utils.AccidentAdapterForMapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service("accidentService")
public class AccidentService {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Accident accident) {
        Session session = sessionFactory.getCurrentSession();
        session.save(accident);
    }

    @Transactional
    public void saveAll(List<Accident> accidents){
        Session session = sessionFactory.getCurrentSession();
        for(Accident accident : accidents){
            session.save(accident);
        }
    }

    public Accident createFromJsonObject(JSONObject jsonObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AccidentAdapterForMapping result = mapper.readValue(jsonObject.toJSONString(),AccidentAdapterForMapping.class);
        return result.toAccident();
    }

}