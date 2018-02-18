package org.kruchon.accidentAnalyzer.component.impl;

import javafx.util.Pair;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterer;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.kruchon.accidentAnalyzer.component.AccidentsClusterer;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.utils.AccidentAdapterForClustering;
import org.kruchon.accidentAnalyzer.utils.AccidentConst;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.round;

@Component
public class AccidentClustererImpl implements AccidentsClusterer{

    private List<List<Accident>> devideRecursively(List<Accident> accidents,double divisionCoefficient){
        Map<Pair<Integer,Integer>,List<Accident>> zones = new HashMap<Pair<Integer, Integer>, List<Accident>>();
        for(Accident accident : accidents){
            int longitudeZoneNumber = accident.getLongitude()
                    .divide(AccidentConst.ACCIDENT_ZONE_DIAMETER_FOR_CLUSTERING
                            .multiply(BigDecimal.valueOf(divisionCoefficient))).intValue();
            int latitudeZoneNumber = accident.getLatitude()
                    .divide(AccidentConst.ACCIDENT_ZONE_DIAMETER_FOR_CLUSTERING
                            .multiply(BigDecimal.valueOf(divisionCoefficient))).intValue();
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
        List<List<Accident>> divisionResult = new LinkedList (zones.values());
        /*for(List<Accident> accidentZone : divisionResult){
            if(accidentZone.size() > 200){
                List<List<Accident>> newResult = devideRecursively(accidentZone,divisionCoefficient/2);
                divisionResult.remove(accidentZone);
                divisionResult.addAll(newResult);
            }
        }*/
        return divisionResult;
    }

    private List<List<Accident>> devide(List<Accident> accidents){
        List<List<Accident>> divisionResult = devideRecursively(accidents,1);
        return divisionResult;
        //to check result
        //((Collection)((HashMap) zones).values().stream().filter(a->((ArrayList) a).size()>100).collect(Collectors.toList())).size();
        //int bigZonesSize = ((HashMap) zones).values().stream().mapToInt(a -> ((ArrayList) a).size()>100 ? ((ArrayList) a).size() : 0).sum();
    }

    private List<Cluster<DoublePoint>> calculateClusters(List<Accident> accidents){
        int numberOfClusters = round(accidents.size() * AccidentConst.NUMBER_OF_CLUSTERS_TO_TOTAL_SIZE);
        Clusterer<DoublePoint> clusterer = new KMeansPlusPlusClusterer<DoublePoint>(numberOfClusters,100);
        List<DoublePoint> accidentPoints = new ArrayList<DoublePoint>();
        for(Accident accident : accidents){
            accidentPoints.add(new AccidentAdapterForClustering(accident));
        }
        List<? extends Cluster<DoublePoint>> clusters = clusterer.cluster(accidentPoints);
        clusters = filterClusters(clusters);
        return (List<Cluster<DoublePoint>>) clusters;
    }

    private List<? extends Cluster<DoublePoint>> filterClusters(List<? extends Cluster<DoublePoint>> clusters) {
        List<Cluster<DoublePoint>> filteredClusters = new LinkedList<Cluster<DoublePoint>>();
        for(Cluster<DoublePoint> cluster : clusters){
            if(cluster.getPoints().size()>3){
                filteredClusters.add(cluster);
            }
        }
        return filteredClusters;
    }

    private List<Accident> filterAccidents(List<Accident> accidents){
        /*accidents.stream().filter(accident ->
                BigDecimal.ZERO.equals(accident.getLatitude()) ||
                        BigDecimal.ZERO.equals(accident.getLongitude()))
                .collect(Collectors.toList()); will be on version update
        */
        List<Accident> filteredList = new LinkedList<Accident>();
        for(Accident accident : accidents){
            if(!(accident.getLatitude().compareTo(BigDecimal.valueOf(0.0001)) ==-1) &&
                    !(accident.getLongitude().compareTo(BigDecimal.valueOf(0.0001)) ==-1)){
                filteredList.add(accident);
            }
        }
        return filteredList;
    }

    private List<List<Accident>> filterZones(List<List<Accident>> accidentZones){
        List<List<Accident>> filteredList = new LinkedList<List<Accident>>();
        for(List<Accident> accidentZone : accidentZones) {
            if(accidentZone.size()>100) {
                filteredList.add(accidentZone);
            }
        }
        return filteredList;
    }

    public List<Cluster<DoublePoint>> calculate(List<Accident> accidents) {

        accidents = filterAccidents(accidents);
        List<List<Accident>> accidentZones = devide(accidents);
        accidentZones = filterZones(accidentZones);
        List<Cluster<DoublePoint>> result = new ArrayList<Cluster<DoublePoint>>();
        for(List<Accident> accidentZone : accidentZones){
            List<Cluster<DoublePoint>> clusters = calculateClusters(accidentZone);
            if(clusters != null) {
                result.addAll(clusters);
            }
        }
        return result;
    }
}
