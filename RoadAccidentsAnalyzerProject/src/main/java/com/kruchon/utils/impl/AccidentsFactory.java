package com.kruchon.utils.impl;

import com.kruchon.entity.Accident;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.IOException;

public class AccidentsFactory {

    public static Accident createFromJsonObject(JSONObject jsonObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AccidentAdapterForMapping result = mapper.readValue(jsonObject.toJSONString(),AccidentAdapterForMapping.class);
        return result.toAccident();
    }
}
