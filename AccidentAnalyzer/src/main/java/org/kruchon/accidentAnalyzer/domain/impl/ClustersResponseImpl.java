package org.kruchon.accidentAnalyzer.domain.impl;

import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.domain.ClustersResponse;

import java.util.List;

public class ClustersResponseImpl implements ClustersResponse {
    private List<AccidentCluster> clusters;

    public void setClusters(List<AccidentCluster> clusters) {
        this.clusters = clusters;
    }

    public List<AccidentCluster> getClusters() {
        return clusters;
    }
}
