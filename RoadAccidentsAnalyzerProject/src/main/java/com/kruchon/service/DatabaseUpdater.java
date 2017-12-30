package com.kruchon.service;

import com.kruchon.utils.FileOperationUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DatabaseUpdater {

    private static ScheduledExecutorService updateDatabaseService = null;
    private static String resourcesPath = null;

    public static void init(int hourDelay){
        if(updateDatabaseService != null){
            throw new RuntimeException("Repeated initialization");
        }

        //TODO Bad solution, it's better to map resources folder
        resourcesPath = System.getProperty("user.dir").replace("bin","resources/");
        File resourcesFolder = new File(resourcesPath);
        if (!resourcesFolder.exists()) {
            resourcesFolder.mkdir();
        }

        updateDatabaseService = Executors.newScheduledThreadPool(1);
        Runnable databaseUpdaterThread = new DatabaseUpdaterThread();
        updateDatabaseService.scheduleAtFixedRate(databaseUpdaterThread,0,hourDelay, TimeUnit.HOURS);
    }

    private static class DatabaseUpdaterThread implements Runnable {

        @Override
        public void run() {

            try {
                FileOperationUtils.downloadUsingNIO("https://xn--80abhddbmm5bieahtk5n.xn--p1ai/opendata-storage/2015-crash.json.zip",resourcesPath+"first.zip");
                FileOperationUtils.unpack(resourcesPath+"first.zip",resourcesPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
