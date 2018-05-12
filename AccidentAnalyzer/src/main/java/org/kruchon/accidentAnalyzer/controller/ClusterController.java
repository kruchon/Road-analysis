package org.kruchon.accidentAnalyzer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kruchon.accidentAnalyzer.component.AccidentsHolder;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.domain.ClusterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClusterController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ClusterReport clusterReport;

    @Autowired
    private AccidentsHolder accidentsHolder;

    @RequestMapping(value = "getClusters", method = RequestMethod.POST)
    public ResponseEntity<String> getClusters(@RequestParam("minSize") Integer minSize, @RequestParam("minPercent") Float minPercent) throws JsonProcessingException {
        List<AccidentCluster> clusters = clusterReport.getClustersWithMaxAccidentTypePercent(minPercent, minSize);
        String clustersResponse = mapper.writeValueAsString(clusters);
        return new ResponseEntity<String>(clustersResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "getAccidents", method = RequestMethod.POST)
    public ResponseEntity<String> getAccidents() throws JsonProcessingException {
        List<Accident> accidents = accidentsHolder.getAccidents();
        String accidentsResponse = mapper.writeValueAsString(accidents);
        return new ResponseEntity<String>(accidentsResponse, HttpStatus.OK);
    }
}