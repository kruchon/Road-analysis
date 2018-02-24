package org.kruchon.accidentAnalyzer.controller;

import org.kruchon.accidentAnalyzer.domain.ClusterReport;
import org.kruchon.accidentAnalyzer.service.AccidentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name="accidentService")
    private AccidentService accidentService;

    @Autowired
    private ClusterReport clusterReport;

    @RequestMapping(value = "cluster", method = RequestMethod.GET)
    public String sendClusterPage(Model model){
        clusterReport.getClustersWithMaxAccidentTypePercent(0.5f,5);
        return "cluster";
    }

}