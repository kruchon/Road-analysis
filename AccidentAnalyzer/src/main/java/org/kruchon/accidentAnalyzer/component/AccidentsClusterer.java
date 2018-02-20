package org.kruchon.accidentAnalyzer.component;

import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;

import java.util.List;

public interface AccidentsClusterer {
    List<AccidentCluster> calculate(List<Accident> accidents);
}
