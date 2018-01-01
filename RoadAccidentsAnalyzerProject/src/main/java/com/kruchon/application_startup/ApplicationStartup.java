package com.kruchon.application_startup;

import com.kruchon.service.AccidentsDataUpdater;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationStartup {

    @PostConstruct
    public void init() {
        AccidentsDataUpdater.init(24);
    }
}