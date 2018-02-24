package org.kruchon.accidentAnalyzer.controller;

import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.domain.ClusterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ClusterReport clusterReport;

    @RequestMapping(value = "clusterMap", method = RequestMethod.GET)
    public String sendClusterPage(){
        clusterReport.getClustersWithMaxAccidentTypePercent(0.5f,5);
        return "clusterMap";
    }

    @RequestMapping(
            value = "getClusters",
            params = {"minSize","minPercent"},
            method = RequestMethod.GET)
    @ResponseBody
    public List<AccidentCluster> getClusters(
            @RequestParam("minSize") int minSize,
            @RequestParam("minPercent") float minPercent){
        List<AccidentCluster> clusters = clusterReport.getClustersWithMaxAccidentTypePercent(minPercent,minSize);
        return clusters;
    }

}