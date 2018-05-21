package org.kruchon.accidentAnalyzer.utils;

import org.kruchon.accidentAnalyzer.domain.Accident;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccidentAdapterForMapping {
    private Accident accident = new Accident();

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public AccidentAdapterForMapping() {
        super();
    }

    public Accident toAccident() {
        return accident;
    }

    void setEm_type_name(String emTypeName) {
        accident.setEmTypeName(emTypeName);
    }

    void setEm_moment_date(String emMomentDateString) throws ParseException {
        Date emMomentDate = dateFormat.parse(emMomentDateString);
        accident.setEmMomentDate(emMomentDate);
    }

    void setEm_moment_time(String emMomentTimeString) throws ParseException {
        Date emMomentTime = timeFormat.parse(emMomentTimeString);
        accident.setEmMomentTime(emMomentTime);
    }

    void setSubject(String subject) {
        accident.setSubject(subject);
    }

    void setLongitude(BigDecimal longitude) {
        accident.setLongitude(longitude);
    }

    void setLatitude(BigDecimal latitude) {
        accident.setLatitude(latitude);
    }

    void setOkato_code(String okatoCode) {
        accident.setOkatoCode(okatoCode);
    }

    void setPlace_path(String placePath) {
        accident.setPlacePath(placePath);
    }

    void setRoad_significance_name(String roadSignificanceName) {
        accident.setRoadSignificanceName(roadSignificanceName);
    }

    void setRoad_name(String roadName) {
        accident.setRoadName(roadName);
    }

    void setRoad_loc(Integer roadLoc) {
        accident.setRoadLoc(roadLoc);
    }

    void setRegion_name(String regionName) {
        accident.setRegionName(regionName);
    }

    void setLight_type_name(String lightTypeName) {
        accident.setLightTypeName(lightTypeName);
    }

    void setTr_area_state_name(String areaStateName) {
        accident.setTrAreaStateName(areaStateName);
    }

    void setTransp_amount(Integer transpAmount) {
        accident.setTranspAmount(transpAmount);
    }

    void setSuffer_amount(Integer sufferAmount) {
        accident.setSufferAmount(sufferAmount);
    }

    void setLoss_amount(Integer lossAmount) {
        accident.setLossAmount(lossAmount);
    }

    void setSuffer_child_amount(Integer sufferChildAmount) {
        accident.setSufferChildAmount(sufferChildAmount);
    }

    void setLoss_child_amount(Integer lossChildAmount) {
        accident.setLossChildAmount(lossChildAmount);
    }

    void setMt_rate_name(String mtRateName) {
        accident.setMtRateName(mtRateName);
    }

}

