package org.kruchon.accidentAnalyzer.component;

import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;

@Component
public class SummariesCache {
    @Autowired
    SummaryService summaryService;

    private HashMap<Long, Summary> summariesMap = new HashMap<Long, Summary>();

    @PostConstruct
    private void initCache(){
        Collection<Summary> summaries = summaryService.getAll();
        for(Summary summary : summaries){
            summariesMap.put(summary.getId(),summary);
        }
    }

    public void putSummary(Summary summary){
        summariesMap.put(summary.getId(),summary);
    }

    public Summary getSummary(Long summaryId){
        return summariesMap.get(summaryId);
    }

    public Collection<Summary> getAllSummaries(){
        return summariesMap.values();
    }

    public void putSummaries(Collection<Summary> summaries){
        for(Summary summary : summaries){
            putSummary(summary);
        }
    }

    public void removeSummary(Long summaryId){
        summariesMap.remove(summaryId);
    }
}