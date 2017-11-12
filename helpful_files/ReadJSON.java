import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;


//Counting number of accidents in each region
public class ReadJSON {
    public static void main (String[] args){
        JSONParser parser = new JSONParser();

        try {
            HashMap<String,Integer> accidentNums = new HashMap<String,Integer>();
            Object obj = parser.parse(new FileReader(
                    "./resources/2015-crash.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray accidentList = (JSONArray) jsonObject.get("items");

            for (Object accident : accidentList){
                String accidentRegion = (String)((JSONObject)accident).get("region_name");
                Integer oldAccidentNum = accidentNums.get(accidentRegion);
                Integer newAccidentNum = oldAccidentNum == null ? 0 : oldAccidentNum + 1;
                accidentNums.put(accidentRegion, newAccidentNum);
            }

            obj = parser.parse(new FileReader(
                    "./resources/2016-crash.json"));

            jsonObject = (JSONObject) obj;

            accidentList = (JSONArray) jsonObject.get("items");

            for (Object accident : accidentList){
                String accidentRegion = (String)((JSONObject)accident).get("region_name");
                Integer oldAccidentNum = accidentNums.get(accidentRegion);
                Integer newAccidentNum = oldAccidentNum == null ? 0 : oldAccidentNum + 1;
                accidentNums.put(accidentRegion, newAccidentNum);
            }

            obj = parser.parse(new FileReader(
                    "./resources/2017-crash.json"));

            jsonObject = (JSONObject) obj;

            accidentList = (JSONArray) jsonObject.get("items");

            for (Object accident : accidentList){
                String accidentRegion = (String)((JSONObject)accident).get("region_name");
                Integer oldAccidentNum = accidentNums.get(accidentRegion);
                Integer newAccidentNum = oldAccidentNum == null ? 0 : oldAccidentNum + 1;
                accidentNums.put(accidentRegion, newAccidentNum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
