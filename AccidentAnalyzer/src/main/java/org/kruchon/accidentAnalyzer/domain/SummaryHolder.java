package org.kruchon.accidentAnalyzer.domain;

import java.util.List;

public interface SummaryHolder {
    List<Summary> getAll();
    void add(Summary summary);
}
