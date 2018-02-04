package org.kruchon.accidentAnalyzer.component;

import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;

import java.util.List;

public interface AccidentsClusterer {
    List<AccidentCluster> calculate(List<Accident> accidents);
}
