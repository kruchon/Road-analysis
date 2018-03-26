package org.kruchon.accidentAnalyzer.controller;

import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.domain.ClusterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ClusterReport clusterReport;

    @RequestMapping(value = "clusterMap", method = RequestMethod.GET)
    public String sendClusterPage(){
         return "clusterMap";
    }

    @RequestMapping(value = "getClusters", method = RequestMethod.POST)
    public ResponseEntity<String> getClusters(@RequestParam("minSize") Integer minSize, @RequestParam("minPercent") Float minPercent) {
        List<AccidentCluster> clusters = clusterReport.getClustersWithMaxAccidentTypePercent(minPercent, minSize);
        return new ResponseEntity<String>(clusters.toString(), HttpStatus.OK);
    }
}