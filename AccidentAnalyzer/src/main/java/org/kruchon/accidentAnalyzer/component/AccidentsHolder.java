package org.kruchon.accidentAnalyzer.component;

import org.kruchon.accidentAnalyzer.domain.Accident;

import java.util.List;

public interface AccidentsHolder {
    void setAccidents(List<Accident> accidents);

    List<Accident> getAccidents();
}
