package org.kruchon.accidentAnalyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {

    @RequestMapping(value = "clusterMap", method = RequestMethod.GET)
    public String sendClusterMapPage(){
        return "clusterMap";
    }

    @RequestMapping(value = "summariesList", method = RequestMethod.GET)
    public String sendSummariesListPage(){
        return "summariesList";
    }

}
