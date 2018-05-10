package org.kruchon.accidentAnalyzer.component.impl;

import org.kruchon.accidentAnalyzer.component.ClustersCache;

import javax.annotation.PostConstruct;

public class ClustersCacheImpl implements ClustersCache {
    @PostConstruct
    private void initCache(){
        //TODO загрузить из базы
    }


}
