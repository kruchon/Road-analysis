package com.kruchon.service.impl;

import com.kruchon.entity.Accident;
import com.kruchon.utils.impl.AccidentsFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class AccidentsDataWriter {
    public static void write(JSONArray accidentsData) throws IOException {
        LinkedList<Accident> accidents = convertJsonArrayToObjects(accidentsData);

        //TODO write POJOs and DAOs, then call DAO method to add data to the database
    }

    private static LinkedList<Accident> convertJsonArrayToObjects(JSONArray accidentsData) throws IOException {
        @SuppressWarnings("unchecked")
        LinkedList<Accident> result = new LinkedList<Accident>();
        for(Object accident : accidentsData) {
            result.add(AccidentsFactory.createFromJsonObject((JSONObject) accident));
        }
        return result;
    }
}
