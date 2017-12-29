package com.kruchon.application_startup;

import com.kruchon.service.DatabaseUpdater;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationStartup {

    @PostConstruct
    public void init() {
        DatabaseUpdater.init(24);
    }
}