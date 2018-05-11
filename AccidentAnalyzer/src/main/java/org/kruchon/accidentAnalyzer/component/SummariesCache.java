package org.kruchon.accidentAnalyzer.component;

import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.domain.SummaryResultValue;
import org.kruchon.accidentAnalyzer.domain.SummaryWithResult;
import org.kruchon.accidentAnalyzer.service.SummaryResultValueService;
import org.kruchon.accidentAnalyzer.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SummariesCache {
    @Autowired
    private SummaryService summaryService;

    @Autowired
    private SummaryResultValueService summaryResultValueService;

    private Map<Long, SummaryWithResult> summariesMap = new ConcurrentHashMap<Long, SummaryWithResult>();

    public void resetCache(){
        Collection<Summary> summaries = summaryService.getAll();
        for(Summary summary : summaries){
            putSummary(summary);
        }
    }

    public void putSummary(Summary summary){
        SummaryWithResult summaryWithResult = new SummaryWithResult();
        Long summaryId = summary.getId();
        List<SummaryResultValue> summaryResultValues = summaryResultValueService.getBySummaryId(summaryId);
        summaryWithResult.setSummaryResultValues(summaryResultValues);
        summaryWithResult.setSummary(summary);
        summariesMap.put(summaryId,summaryWithResult);
    }

    public SummaryWithResult getSummaryWithResult(Long summaryId){
        return summariesMap.get(summaryId);
    }

    @SuppressWarnings("unchecked")
    public List<SummaryWithResult> getAllSummaryWithResults(){
        return (List<SummaryWithResult>) summariesMap.values();
    }

    public Summary getSummary(Long summaryId){
        return getSummaryWithResult(summaryId).getSummary();
    }

    public Collection<Summary> getAllSummaries(){
        Collection<SummaryWithResult> summaryWithResults = summariesMap.values();
        Collection<Summary> summaries = new ArrayList<Summary>();
        for(SummaryWithResult summaryWithResult : summaryWithResults){
            summaries.add(summaryWithResult.getSummary());
        }
        return summaries;
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