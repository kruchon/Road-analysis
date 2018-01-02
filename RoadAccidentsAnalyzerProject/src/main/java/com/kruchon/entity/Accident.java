package com.kruchon.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Date;

public interface Accident {
    BigInteger getId();
    String getEmTypeName();
    Date getEmMomentDate();
    Time getEmMomentTime();
    String getSubject();
    BigDecimal getLongitude();
    BigDecimal getLatitude();
    String getOkatoCode();
    String getPlacePath();
    String getRoadSignificanceName();
    String getRoadName();
    Integer getRoadLoc();
    String getRegionName();
    String getLightTypeName();
    String getAreaStateName();
    Integer getTranspAmount();
    Integer getSufferAmount();
    Integer getLossAmount();
    Integer getSufferChildAmount();
    Integer getLossChildAmount();
    String getMtRateName();

    void setId(BigInteger id);
    void setEmTypeName(String emTypeName);
    void setEmMomentDate(Date emMomentDate);
    void setEmMomentTime(Time emMomentTime);
    void setSubject(String subject);
    void setLongitude(BigDecimal longitude);
    void setLatitude(BigDecimal latitude);
    void setOkatoCode(String okatoCode);
    void setPlacePath(String placePath);
    void setRoadSignificanceName(String roadSignificanceName);
    void setRoadName(String roadName);
    void setRoadLoc(Integer roadLoc);
    void setRegionName(String regionName);
    void setLightTypeName(String lightTypeName);
    void setAreaStateName(String areaStateName);
    void setTranspAmount(Integer transpAmount);
    void setSufferAmount(Integer sufferAmount);
    void setLossAmount(Integer lossAmount);
    void setSufferChildAmount(Integer sufferChildAmount);
    void setLossChildAmount(Integer lossChildAmount);
    void setMtRateName(String mtRateName);
    //TODO get/set RoadPart,getDistrict, delete needless params and distribute some params to another entities
    //TODO String subject -> Subject subject
}
