package org.kruchon.accidentAnalyzer.controller;

import org.kruchon.accidentAnalyzer.service.AccidentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

@Controller
@RequestMapping("/main")
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name="accidentService")
    private AccidentService accidentService;

    //There will be methods for handling requests from user

}