package org.kruchon.accidentAnalyzer.domain;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccidentCluster {
    private BigDecimal longitude;
    private BigDecimal latitude;

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public ArrayList<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(ArrayList<Accident> accidents) {
        this.accidents = accidents;
    }

    ArrayList<Accident> accidents;
}
