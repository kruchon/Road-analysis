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
                FileOperationUtils.downloadUsingNIO("https://xn--80abhddbmm5bieahtk5n.xn--p1ai/opendata-storage/2015-crash.json.zip","C://Users/111/Desktop/Новая папка (4)/first.zip");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
