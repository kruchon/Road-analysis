package com.kruchon.service;

import com.kruchon.utils.FileOperationUtils;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DatabaseUpdater {

    final static Logger LOG = Logger.getRootLogger();

    private static ScheduledExecutorService updateDatabaseService = null;

    public static void init(int hourDelay){
        if(updateDatabaseService != null){
            throw new RuntimeException("Repeated initialization");
        }

        updateDatabaseService = Executors.newScheduledThreadPool(1);
        Runnable databaseUpdaterThread = new DatabaseUpdaterThread();
        updateDatabaseService.scheduleAtFixedRate(databaseUpdaterThread,0,hourDelay, TimeUnit.HOURS);
    }

    private static class DatabaseUpdaterThread implements Runnable {

        @Override
        public void run() {
            try {
                FileOperationUtils.downloadUsingStream("https://безопасныедороги.рф/opendata-storage/2015-crash.json.zip","./first.zip");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
