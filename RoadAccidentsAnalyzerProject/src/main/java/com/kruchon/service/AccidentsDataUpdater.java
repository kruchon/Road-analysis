package com.kruchon.service;

import com.kruchon.utils.FileOperationUtils;
import org.json.simple.JSONArray;

import java.io.File;
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

        //TODO develop func to read array of accidents from json file
        JSONArray readAccidentsData(){
            return null;
        }

        @Override
        public void run() {

            try {
                //TODO make operations with accidents data without reading/writing to file
                FileOperationUtils.downloadUsingNIO("https://xn--80abhddbmm5bieahtk5n.xn--p1ai/opendata-storage/2015-crash.json.zip",resourcesPath+"first.zip");
                FileOperationUtils.unpack(resourcesPath+"first.zip",resourcesPath);
                JSONArray accidentsDataJson = readAccidentsData();

                //TODO develop OSMdataFiller
                //TODO (characteristics for accidents such as speed mode of road, road type, slope of the road..)
                //OSMAccidentsDataFiller.fill(accidentsDataJson);

                //TODO develop accidents data router
                //AccidentsDataWriter.write(accidentsDataJson);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
