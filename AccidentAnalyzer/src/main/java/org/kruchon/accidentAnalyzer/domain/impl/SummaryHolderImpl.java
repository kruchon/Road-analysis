package org.kruchon.accidentAnalyzer.domain.impl;

import org.kruchon.accidentAnalyzer.domain.Summary;
import org.kruchon.accidentAnalyzer.domain.SummaryHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SummaryHolderImpl implements SummaryHolder{
    private List<Summary> summaries;

    public void add(Summary summary){
        summaries.add(summary);
    }

    public List<Summary> getAll(){
        return summaries;
    }
}
