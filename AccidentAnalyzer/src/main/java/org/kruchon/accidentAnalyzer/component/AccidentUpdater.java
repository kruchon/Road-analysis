package org.kruchon.accidentAnalyzer.component;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.service.AccidentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

@Component
public class AccidentUpdater {

    @Resource(name="accidentService")
    private AccidentService accidentService;

    @Resource(name="fileOperations")
    private FileOperations fileOperations;
    private final static String resourcesPath = System.getProperty("user.dir").replace("bin","resources/");

    @PostConstruct
    public void createResourcesFolder(){
        //TODO Bad solution, it's better to map resources folder
        File resourcesFolder = new File(resourcesPath);
        if (!resourcesFolder.exists()) {
            resourcesFolder.mkdir();
        }
    }

    private JSONArray readAccidentsData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(resourcesPath + "2015-crash.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray accidentsData = (JSONArray) jsonObject.get("items");
        return accidentsData;
    }

    private LinkedList<Accident> mapJsonArrayToObjects(JSONArray accidentsData) throws IOException {
        @SuppressWarnings("unchecked")
        LinkedList<Accident> result = new LinkedList<Accident>();
        for(Object accident : accidentsData) {
            result.add(accidentService.createFromJsonObject((JSONObject) accident));
        }
        return result;
    }

    private void mapAndSave(JSONArray accidentsData) throws IOException {
        LinkedList<Accident> accidents = mapJsonArrayToObjects(accidentsData);
        accidentService.saveAll(accidents);
    }

    @Scheduled(fixedDelay = 86400000)
    public void updateAccidents() throws IOException, ParseException {
        fileOperations.downloadUsingNIO("https://xn--80abhddbmm5bieahtk5n.xn--p1ai/opendata-storage/2015-crash.json.zip",resourcesPath+"first.zip");
        fileOperations.unpack(resourcesPath+"first.zip",resourcesPath);

        JSONArray accidentsData = readAccidentsData();
//TODO develop OSMdataFiller
        //TODO (characteristics for accidents such as speed mode of road, road type, slope of the road..)
        //OSMAccidentsDataFiller.fill(accidentsData);

        //TODO develop accidents data router
        mapAndSave(accidentsData);
    }
}
