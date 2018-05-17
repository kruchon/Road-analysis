package org.kruchon.accidentAnalyzer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kruchon.accidentAnalyzer.component.SummariesCache;
import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class SummariesController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SummaryService summaryService;

    @Autowired
    private SummariesCache summariesCache;

    @RequestMapping(value = "getSummaries", method = RequestMethod.GET)
    public ResponseEntity<String> getSummaries() throws JsonProcessingException {
        Collection<Summary> summaries = summariesCache.getAllSummaries();
        String summariesResponse = mapper.writeValueAsString(summaries);
        return new ResponseEntity<String>(summariesResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "updateSummary", method = RequestMethod.POST)
    public void updateSummary(@RequestParam("id")Long id, @RequestParam("name") String name, @RequestParam("query") String query){
        Summary summary = new Summary();
        summary.setId(id);
        summary.setName(name);
        summary.setQuery(query);
        summaryService.saveOrUpdate(summary);
    }
}
