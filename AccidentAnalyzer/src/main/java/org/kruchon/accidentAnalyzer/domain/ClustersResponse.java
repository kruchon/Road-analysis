package org.kruchon.accidentAnalyzer.domain;

import java.util.List;

public interface ClustersResponse {
    void setClusters(List<AccidentCluster> clusters);
    List<AccidentCluster> getClusters();
}
