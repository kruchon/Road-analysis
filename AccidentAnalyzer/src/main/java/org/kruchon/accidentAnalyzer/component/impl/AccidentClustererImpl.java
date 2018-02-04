package org.kruchon.accidentAnalyzer.component.impl;

import org.kruchon.accidentAnalyzer.component.AccidentsClusterer;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccidentClustererImpl implements AccidentsClusterer{

    private List<List<Accident>> devide(List<Accident> accidents){
        return null;
    }

    private List<AccidentCluster> calculateClusters(List<Accident> accidents){
        return null;
    }

    public List<AccidentCluster> calculate(List<Accident> accidents) {
        List<List<Accident>> accidentGroups = devide(accidents);
        ArrayList<AccidentCluster> result = null;
        for(List<Accident> accidentGroup : accidentGroups){
            List<AccidentCluster> clusters = calculateClusters(accidentGroup);
            result.addAll(clusters);
        }
        return result;
    }
}
