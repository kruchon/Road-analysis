package org.kruchon.accidentAnalyzer.domain.impl;

import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.domain.ClusterReport;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClusterReportImpl implements ClusterReport {

    List<AccidentCluster> clusters = new ArrayList<AccidentCluster>();

    public List<AccidentCluster> getClusters() {
        return clusters;
    }

    public List<AccidentCluster> getClustersWithMinSize(int minSize) {
        List<AccidentCluster> filteredClusters = new LinkedList<AccidentCluster>();
        for(AccidentCluster cluster : clusters){
            int clusterSize = cluster.getAccidents().size();
            if(clusterSize >= minSize){
                filteredClusters.add(cluster);
            }
        }
        return filteredClusters;
    }

    public List<AccidentCluster> getClustersWithMaxAccidentTypePercent(float maxAccidentTypePercent, int minSize) {
        List<AccidentCluster> filteredClusters = new LinkedList<AccidentCluster>();
        for(AccidentCluster cluster : clusters){
            int clusterSize = cluster.getAccidents().size();
            if(clusterSize >= minSize){
                Map<String,Integer> accidentTypesCountMap = new HashMap<String,Integer>();
                for(Accident accident : cluster.getAccidents()){
                    String accidentType = accident.getEmTypeName();
                    Integer typeCount = accidentTypesCountMap.get(accidentType);
                    typeCount = typeCount == null ? 1 : typeCount+1;
                    accidentTypesCountMap.put(accidentType,typeCount);
                }
                int maxCount = 0;
                for(Integer accidentTypeCount : accidentTypesCountMap.values()){
                    if(accidentTypeCount > maxCount){
                        maxCount = accidentTypeCount;
                    }
                }
                float maxPercent = (float)maxCount/clusterSize;
                if(maxPercent > maxAccidentTypePercent) {
                    filteredClusters.add(cluster);
                }
            }
        }
        return filteredClusters;
    }

    public void setClusters(List<AccidentCluster> clusters) {
        this.clusters = clusters;
    }
}
