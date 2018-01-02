package com.kruchon.service.impl;

import com.kruchon.entity.Accident;
import com.kruchon.utils.AccidentsFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class AccidentsDataWriter {
    public static void write(JSONArray accidentsData) {
        LinkedList<Accident> accidents = convertJsonArrayToObjects(accidentsData);

        //TODO write POJOs and DAOs, then call DAO method to add data to the database
    }

    private static LinkedList<Accident> convertJsonArrayToObjects(JSONArray accidentsData){
        //TODO throw an exception upper in the call stack
        @SuppressWarnings("unchecked")
        LinkedList<Accident> result = (LinkedList<Accident>) accidentsData.stream()
                .flatMap(x -> {
                    try {
                        return AccidentsFactory.createFromJsonObject((JSONObject) x);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
        int x = 0;
        return result;
    }
}
