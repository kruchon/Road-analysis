package org.kruchon.accidentAnalyzer.domain;

import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.DoublePoint;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccidentCluster {
    private Double longitude;
    private Double latitude;
    private List<Accident> accidents;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }


    @Override
    public String toString() {
        return "AccidentCluster{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", accidents=" + accidents +
                '}';
    }
}
