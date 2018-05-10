package org.kruchon.accidentAnalyzer.component;

import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class SummariesExecutor {
    @Autowired
    SummariesCache summariesCache;

    @Autowired
    SummaryService summaryService;

    @Transactional
    public void executeAndSaveAllSummaries(){
        Collection<Summary> summaries = summariesCache.getAllSummaries();
        for(Summary summary : summaries) {
            summaryService.executeAndSaveSummary(summary);
        }
    }
}
