package org.kruchon.accidentAnalyzer.component.impl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.kruchon.accidentAnalyzer.component.AccidentsClusterer;
import org.kruchon.accidentAnalyzer.component.AccidentsHolder;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.domain.ClusterReport;
import org.kruchon.accidentAnalyzer.domain.impl.ClusterReportImpl;
import org.kruchon.accidentAnalyzer.service.AccidentService;
import org.kruchon.accidentAnalyzer.utils.AccidentAdapterForClustering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccidentUpdater {

    @Resource(name="accidentService")
    private AccidentService accidentService;

    @Resource(name="fileOperations")
    private FileOperations fileOperations;
    private final static String resourcesPath = System.getProperty("user.dir").replace("bin","resources/");

    @Autowired
    private ClusterReport clusterReport;

    @Autowired
    private AccidentsHolder accidentsHolder;

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

    private List<Accident> mapJsonArrayToObjects(JSONArray accidentsData) throws IOException {
        @SuppressWarnings("unchecked")
        List<Accident> result = new ArrayList<Accident>();
        for(Object accident : accidentsData) {
            result.add(accidentService.createFromJsonObject((JSONObject) accident));
        }
        return result;
    }

    private void mapAndSave(JSONArray accidentsData) throws IOException {
        List<Accident> accidents = mapJsonArrayToObjects(accidentsData);
        //accidentService.saveAll(accidents);
        accidentsHolder.setAccidents(accidents);
        AccidentsClusterer accidentsClusterer = new AccidentClustererImpl();
        List<AccidentCluster> clusters = accidentsClusterer.calculate(accidents);
        clusterReport.setClusters(clusters);
    }

    @Scheduled(fixedDelay = 86400000)
    public void updateAccidents() throws IOException, ParseException {
        //fileOperations.downloadUsingNIO("https://xn--80abhddbmm5bieahtk5n.xn--p1ai/opendata-storage/2015-crash.json.zip",resourcesPath+"first.zip");
        //fileOperations.unpack(resourcesPath+"first.zip",resourcesPath);

        JSONArray accidentsData = readAccidentsData();
//TODO develop OSMdataFiller
        //TODO (characteristics for accidents such as speed mode of road, road type, slope of the road..)
        //OSMAccidentsDataFiller.fill(accidentsData);

        //TODO implement full deletion in table Accidents
        //clearAccidentsTable();
        mapAndSave(accidentsData);


    }
}
