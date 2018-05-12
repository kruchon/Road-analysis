package org.kruchon.accidentAnalyzer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kruchon.accidentAnalyzer.component.SummariesCache;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class SummariesController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SummariesCache summariesCache;

    @RequestMapping(value = "getSummaries", method = RequestMethod.GET)
    public ResponseEntity<String> getSummaries() throws JsonProcessingException {
        Collection<Summary> summaries = summariesCache.getAllSummaries();
        String summariesResponse = mapper.writeValueAsString(summaries);
        return new ResponseEntity<String>(summariesResponse, HttpStatus.OK);
    }
}
