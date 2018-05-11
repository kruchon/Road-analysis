package org.kruchon.accidentAnalyzer.domain;

import java.util.List;

public class SummaryWithResult {

    private Summary summary;
    private List<SummaryResultValue> summaryResultValues;

    public List<SummaryResultValue> getSummaryResultValues() {
        return summaryResultValues;
    }

    public void setSummaryResultValues(List<SummaryResultValue> summaryResultValues) {
        this.summaryResultValues = summaryResultValues;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
