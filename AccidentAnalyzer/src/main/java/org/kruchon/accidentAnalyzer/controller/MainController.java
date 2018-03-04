package org.kruchon.accidentAnalyzer.controller;

import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.domain.ClusterReport;
import org.kruchon.accidentAnalyzer.domain.GetClustersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ClusterReport clusterReport;

    @RequestMapping(value = "clusterMap", method = RequestMethod.GET)
    public ModelAndView sendClusterPage(){
         return new ModelAndView("clusterMap","getClustersRequest",new GetClustersRequest());
    }

    @RequestMapping(value = "/getClusters", method = RequestMethod.POST)
    public String getClusters(@ModelAttribute("getClustersRequest")GetClustersRequest getClustersRequest,
                            BindingResult result, ModelMap model) {
        Integer minSize = getClustersRequest.getMinSize();
        Float minPercent = getClustersRequest.getMinPercent();
        List<AccidentCluster> clusters = clusterReport.getClustersWithMaxAccidentTypePercent(minPercent, minSize);
        model.addAttribute("clusters",clusters.toString());
        return "clusterMap";
    }

}