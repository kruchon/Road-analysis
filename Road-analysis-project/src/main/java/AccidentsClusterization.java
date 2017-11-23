import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class AccidentsClusterization {
    public static void main (String[] args){
        JSONParser parser = new JSONParser();
        JSONArray accidents = new JSONArray();
        try {
            Object obj = parser.parse(new FileReader(
                    "C:/Users/111/Desktop/AccidentsNumber/src/main/resources/2015-crash.json"));
            accidents = (JSONArray)((JSONObject)obj).get("items");
            obj = parser.parse(new FileReader(
                    "C:/Users/111/Desktop/AccidentsNumber/src/main/resources/2016-crash.json"));
            accidents.add((JSONArray)((JSONObject)obj).get("items"));
            obj = parser.parse(new FileReader(
                    "C:/Users/111/Desktop/AccidentsNumber/src/main/resources/2017-crash.json"));
            accidents.add((JSONArray)((JSONObject)obj).get("items"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        KMeansPlusPlusClusterer<DoublePoint> clusterer = new KMeansPlusPlusClusterer<DoublePoint>(100);
        LinkedList<DoublePoint> accidentsCoords = new LinkedList<>();
        for(Object accident : accidents){
            double latitude = (Double)((JSONObject)accident).get("latitude");
            double longitude = (Double)((JSONObject)accident).get("longitude");
            accidentsCoords.add(new DoublePoint(new double[]{latitude,longitude}));
        }
        List<CentroidCluster<DoublePoint>> clusters = clusterer.cluster(accidentsCoords);

    }
}
