package org.kruchon.accidentAnalyzer.component.impl;

import javafx.util.Pair;
import org.kruchon.accidentAnalyzer.component.AccidentsClusterer;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
import org.kruchon.accidentAnalyzer.utils.AccidentConst;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AccidentClustererImpl implements AccidentsClusterer{

    private List<List<Accident>> devide(List<Accident> accidents){
        Map<Pair<Integer,Integer>,List<Accident>> zones = new HashMap<Pair<Integer, Integer>, List<Accident>>();
        for(Accident accident : accidents){
            int longitudeZoneNumber = accident.getLongitude().divide(AccidentConst.ACCIDENT_ZONE_DIAMETER_FOR_CLUSTERING).intValue();
            int latitudeZoneNumber = accident.getLatitude().divide(AccidentConst.ACCIDENT_ZONE_DIAMETER_FOR_CLUSTERING).intValue();
            Pair<Integer,Integer> zoneKey = new Pair<Integer, Integer>(longitudeZoneNumber,latitudeZoneNumber);
            List<Accident> accidentsInZone = zones.get(zoneKey);
            if(accidentsInZone == null){
                ArrayList<Accident> newAccidentList = new ArrayList<Accident>();
                newAccidentList.add(accident);
                zones.put(zoneKey, newAccidentList);
            } else {
                accidentsInZone.add(accident);
                zones.put(zoneKey,accidentsInZone);
            }
        }
        //to check result
        //((Collection)((HashMap) zones).values().stream().filter(a->((ArrayList) a).size()>100).collect(Collectors.toList())).size();
        //int bigZonesSize = ((HashMap) zones).values().stream().mapToInt(a -> ((ArrayList) a).size()>100 ? ((ArrayList) a).size() : 0).sum();
        return (List<List<Accident>>) zones.values();
    }

    private List<AccidentCluster> calculateClusters(List<Accident> accidents){
        return null;
    }

    public List<AccidentCluster> calculate(List<Accident> accidents) {
        List<List<Accident>> accidentZones = devide(accidents);
        List<AccidentCluster> result = new ArrayList<AccidentCluster>();
        for(List<Accident> accidentZone : accidentZones){
            List<AccidentCluster> clusters = calculateClusters(accidentZone);
            result.addAll(clusters);
        }
        return result;
    }
}
