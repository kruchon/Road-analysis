package com.kruchon.service.impl;

import com.kruchon.utils.FileOperationUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AccidentsDataUpdater {

    private final static ScheduledExecutorService updateDatabaseService = Executors.newScheduledThreadPool(1);
    private final static String resourcesPath = System.getProperty("user.dir").replace("bin","resources/");

    public static void init(int hourDelay){
        //TODO Bad solution, it's better to map resources folder
        File resourcesFolder = new File(resourcesPath);
        if (!resourcesFolder.exists()) {
            resourcesFolder.mkdir();
        }
        Runnable databaseUpdaterThread = new DatabaseUpdaterThread();
        updateDatabaseService.scheduleAtFixedRate(databaseUpdaterThread,0,hourDelay, TimeUnit.HOURS);
    }

    private static class DatabaseUpdaterThread implements Runnable {

        private static JSONArray readAccidentsData() throws IOException, ParseException {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(resourcesPath + "2015-crash.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray accidentsData = (JSONArray) jsonObject.get("items");
            return accidentsData;
        }

        @Override
        public void run() {

            try {
                //TODO make operations with accidents data without reading/writing to file
                FileOperationUtils.downloadUsingNIO("https://xn--80abhddbmm5bieahtk5n.xn--p1ai/opendata-storage/2015-crash.json.zip",resourcesPath+"first.zip");
                FileOperationUtils.unpack(resourcesPath+"first.zip",resourcesPath);
                JSONArray accidentsData = readAccidentsData();

                //TODO develop OSMdataFiller
                //TODO (characteristics for accidents such as speed mode of road, road type, slope of the road..)
                //OSMAccidentsDataFiller.fill(accidentsData);

                //TODO develop accidents data router
                //AccidentsDataWriter.write(accidentsData);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
