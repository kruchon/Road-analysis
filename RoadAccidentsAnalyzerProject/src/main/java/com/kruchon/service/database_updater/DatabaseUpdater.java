package com.kruchon.service.database_updater;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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
        updateDatabaseService.scheduleAtFixedRate(databaseUpdaterThread,hourDelay,hourDelay, TimeUnit.SECONDS);
    }

    private static class DatabaseUpdaterThread implements Runnable {

        @Override
        public void run() {
            System.out.println("11111111");
        }
    }

}
