package org.kruchon.accidentAnalyzer.domain;

import java.util.List;

public interface ClusterReport {
    List<AccidentCluster> getClusters();
    List<AccidentCluster> getClustersWithMinSize(int minSize);
    List<AccidentCluster> getClustersWithMaxAccidentTypePercent(float maxAccidentTypePercent, int minSize);

    void setClusters(List<AccidentCluster> clusters);
}
