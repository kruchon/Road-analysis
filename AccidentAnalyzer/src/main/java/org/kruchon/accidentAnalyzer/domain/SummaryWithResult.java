package org.kruchon.accidentAnalyzer.domain;

import java.util.HashMap;
import java.util.List;

public class SummaryWithResult {

    private Summary summary;
    private HashMap<String, List<String>> summaryResultTable;


    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public HashMap<String, List<String>> getSummaryResultTable() {
        return summaryResultTable;
    }

    public void setSummaryResultTable(HashMap<String, List<String>> summaryResultTable) {
        this.summaryResultTable = summaryResultTable;
    }
}
