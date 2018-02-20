package org.kruchon.accidentAnalyzer.component.impl;

import javafx.util.Pair;
import org.apache.commons.math3.ml.clustering.*;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.kruchon.accidentAnalyzer.component.AccidentsClusterer;
import org.kruchon.accidentAnalyzer.domain.Accident;
import org.kruchon.accidentAnalyzer.domain.AccidentCluster;
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
        Clusterer<DoublePoint> clusterer = new KMeansPlusPlusClusterer<DoublePoint>(numberOfClusters, 1000, new DistanceMeasure() {
            public double compute(double[] firstPoint, double[] secondPoint) {
                double distance = Math.sqrt(Math.pow(firstPoint[0]-secondPoint[0],2)+Math.pow(firstPoint[1]-secondPoint[1],2));
                return distance > 0.003 ? 100 : distance;
            }
        });
        List<DoublePoint> accidentPoints = new ArrayList<DoublePoint>();
        for(Accident accident : accidents){
            accidentPoints.add(new AccidentAdapterForClustering(accident));
        }
        List<? extends Cluster<DoublePoint>> clusters = clusterer.cluster(accidentPoints);
        return (List<Cluster<DoublePoint>>) clusters;
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

    public List<AccidentCluster> calculate(List<Accident> accidents) {

        accidents = filterAccidents(accidents);
        /*List<List<Accident>> accidentZones = devide(accidents);
        accidentZones = filterZones(accidentZones);
        List<Cluster<DoublePoint>> result = new ArrayList<Cluster<DoublePoint>>();
        for(List<Accident> accidentZone : accidentZones){
            List<Cluster<DoublePoint>> clusters = calculateClusters(accidentZone);
            if(clusters != null) {
                result.addAll(clusters);
            }
        }*/
        List<Cluster<DoublePoint>> clusteringResult = calculateClusters(accidents);
        List<AccidentCluster> clusters = new LinkedList<AccidentCluster>();
        for(Cluster<DoublePoint> clusteringResultNode : clusteringResult){
            CentroidCluster centroidCluster = (CentroidCluster) clusteringResultNode;
            AccidentCluster accidentCluster = new AccidentCluster();
            List<Accident> accidentsInCluster = (ArrayList<Accident>) centroidCluster.getPoints();
            accidentCluster.setAccidents(accidentsInCluster);
            double latitude = centroidCluster.getCenter().getPoint()[0];
            accidentCluster.setLatitude(latitude);
            double longitude = centroidCluster.getCenter().getPoint()[1];
            accidentCluster.setLongitude(longitude);
            clusters.add(accidentCluster);
        }
        return clusters;
    }
}
