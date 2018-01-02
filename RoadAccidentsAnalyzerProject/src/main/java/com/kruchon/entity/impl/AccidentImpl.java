package com.kruchon.entity.impl;

import com.kruchon.entity.Accident;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

public class AccidentImpl implements Accident{

    private BigInteger id;
    private String emTypeName;
    private Date emMomentDate;
    private Time emMomentTime;
    private String subject;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String okatoCode;
    private String placePath;
    private String roadSignificanceName;
    private String roadName;
    private Integer roadLoc;
    private String regionName;
    private String lightTypeName;
    private String areaStateName;
    private Integer transpAmount;
    private Integer sufferAmount;
    private Integer lossAmount;
    private Integer sufferChildAmount;
    private Integer lossChildAmount;
    private String mtRateName;

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public String getEmTypeName() {
        return emTypeName;
    }

    @Override
    public void setEmTypeName(String emTypeName) {
        this.emTypeName = emTypeName;
    }

    @Override
    public Date getEmMomentDate() {
        return emMomentDate;
    }

    @Override
    public void setEmMomentDate(Date emMomentDate) {
        this.emMomentDate = emMomentDate;
    }

    @Override
    public Time getEmMomentTime() {
        return emMomentTime;
    }

    @Override
    public void setEmMomentTime(Time emMomentTime) {
        this.emMomentTime = emMomentTime;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public BigDecimal getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public BigDecimal getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public String getOkatoCode() {
        return okatoCode;
    }

    @Override
    public void setOkatoCode(String okatoCode) {
        this.okatoCode = okatoCode;
    }

    @Override
    public String getPlacePath() {
        return placePath;
    }

    @Override
    public void setPlacePath(String placePath) {
        this.placePath = placePath;
    }

    @Override
    public String getRoadSignificanceName() {
        return roadSignificanceName;
    }

    @Override
    public void setRoadSignificanceName(String roadSignificanceName) {
        this.roadSignificanceName = roadSignificanceName;
    }

    @Override
    public String getRoadName() {
        return roadName;
    }

    @Override
    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    @Override
    public Integer getRoadLoc() {
        return roadLoc;
    }

    @Override
    public void setRoadLoc(Integer roadLoc) {
        this.roadLoc = roadLoc;
    }

    @Override
    public String getRegionName() {
        return regionName;
    }

    @Override
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String getLightTypeName() {
        return lightTypeName;
    }

    @Override
    public void setLightTypeName(String lightTypeName) {
        this.lightTypeName = lightTypeName;
    }

    @Override
    public String getAreaStateName() {
        return areaStateName;
    }

    @Override
    public void setAreaStateName(String areaStateName) {
        this.areaStateName = areaStateName;
    }

    @Override
    public Integer getTranspAmount() {
        return transpAmount;
    }

    @Override
    public void setTranspAmount(Integer transpAmount) {
        this.transpAmount = transpAmount;
    }

    @Override
    public Integer getSufferAmount() {
        return sufferAmount;
    }

    @Override
    public void setSufferAmount(Integer sufferAmount) {
        this.sufferAmount = sufferAmount;
    }

    @Override
    public Integer getLossAmount() {
        return lossAmount;
    }

    @Override
    public void setLossAmount(Integer lossAmount) {
        this.lossAmount = lossAmount;
    }

    @Override
    public Integer getSufferChildAmount() {
        return sufferChildAmount;
    }

    @Override
    public void setSufferChildAmount(Integer sufferChildAmount) {
        this.sufferChildAmount = sufferChildAmount;
    }

    @Override
    public Integer getLossChildAmount() {
        return lossChildAmount;
    }

    @Override
    public void setLossChildAmount(Integer lossChildAmount) {
        this.lossChildAmount = lossChildAmount;
    }

    @Override
    public String getMtRateName() {
        return mtRateName;
    }

    @Override
    public void setMtRateName(String mtRateName) {
        this.mtRateName = mtRateName;
    }

}
