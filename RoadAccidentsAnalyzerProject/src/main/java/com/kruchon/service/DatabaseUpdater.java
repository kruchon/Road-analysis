package com.kruchon.service;

import com.kruchon.utils.FileOperationUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DatabaseUpdater {

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

        @Override
        public void run() {

            try {
                //TODO make operations with accidents data without reading/writing to file
                FileOperationUtils.downloadUsingNIO("https://xn--80abhddbmm5bieahtk5n.xn--p1ai/opendata-storage/2015-crash.json.zip",resourcesPath+"first.zip");
                FileOperationUtils.unpack(resourcesPath+"first.zip",resourcesPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
