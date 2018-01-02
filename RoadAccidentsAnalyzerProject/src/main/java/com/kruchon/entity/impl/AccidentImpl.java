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

    @Override
    public String toString() {
        return "AccidentImpl{" +
                "id=" + id +
                ", emTypeName='" + emTypeName + '\'' +
                ", emMomentDate=" + emMomentDate +
                ", emMomentTime=" + emMomentTime +
                ", subject='" + subject + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", okatoCode='" + okatoCode + '\'' +
                ", placePath='" + placePath + '\'' +
                ", roadSignificanceName='" + roadSignificanceName + '\'' +
                ", roadName='" + roadName + '\'' +
                ", roadLoc=" + roadLoc +
                ", regionName='" + regionName + '\'' +
                ", lightTypeName='" + lightTypeName + '\'' +
                ", areaStateName='" + areaStateName + '\'' +
                ", transpAmount=" + transpAmount +
                ", sufferAmount=" + sufferAmount +
                ", lossAmount=" + lossAmount +
                ", sufferChildAmount=" + sufferChildAmount +
                ", lossChildAmount=" + lossChildAmount +
                ", mtRateName='" + mtRateName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccidentImpl accident = (AccidentImpl) o;

        if (!id.equals(accident.id)) return false;
        if (!emTypeName.equals(accident.emTypeName)) return false;
        if (!emMomentDate.equals(accident.emMomentDate)) return false;
        if (!emMomentTime.equals(accident.emMomentTime)) return false;
        if (!subject.equals(accident.subject)) return false;
        if (!longitude.equals(accident.longitude)) return false;
        if (!latitude.equals(accident.latitude)) return false;
        if (okatoCode != null ? !okatoCode.equals(accident.okatoCode) : accident.okatoCode != null) return false;
        if (placePath != null ? !placePath.equals(accident.placePath) : accident.placePath != null) return false;
        if (roadSignificanceName != null ? !roadSignificanceName.equals(accident.roadSignificanceName) : accident.roadSignificanceName != null)
            return false;
        if (roadName != null ? !roadName.equals(accident.roadName) : accident.roadName != null) return false;
        if (roadLoc != null ? !roadLoc.equals(accident.roadLoc) : accident.roadLoc != null) return false;
        if (regionName != null ? !regionName.equals(accident.regionName) : accident.regionName != null) return false;
        if (lightTypeName != null ? !lightTypeName.equals(accident.lightTypeName) : accident.lightTypeName != null)
            return false;
        if (areaStateName != null ? !areaStateName.equals(accident.areaStateName) : accident.areaStateName != null)
            return false;
        if (transpAmount != null ? !transpAmount.equals(accident.transpAmount) : accident.transpAmount != null)
            return false;
        if (sufferAmount != null ? !sufferAmount.equals(accident.sufferAmount) : accident.sufferAmount != null)
            return false;
        if (lossAmount != null ? !lossAmount.equals(accident.lossAmount) : accident.lossAmount != null) return false;
        if (sufferChildAmount != null ? !sufferChildAmount.equals(accident.sufferChildAmount) : accident.sufferChildAmount != null)
            return false;
        if (lossChildAmount != null ? !lossChildAmount.equals(accident.lossChildAmount) : accident.lossChildAmount != null)
            return false;
        return mtRateName != null ? mtRateName.equals(accident.mtRateName) : accident.mtRateName == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + emTypeName.hashCode();
        result = 31 * result + emMomentDate.hashCode();
        result = 31 * result + emMomentTime.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + (okatoCode != null ? okatoCode.hashCode() : 0);
        result = 31 * result + (placePath != null ? placePath.hashCode() : 0);
        result = 31 * result + (roadSignificanceName != null ? roadSignificanceName.hashCode() : 0);
        result = 31 * result + (roadName != null ? roadName.hashCode() : 0);
        result = 31 * result + (roadLoc != null ? roadLoc.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (lightTypeName != null ? lightTypeName.hashCode() : 0);
        result = 31 * result + (areaStateName != null ? areaStateName.hashCode() : 0);
        result = 31 * result + (transpAmount != null ? transpAmount.hashCode() : 0);
        result = 31 * result + (sufferAmount != null ? sufferAmount.hashCode() : 0);
        result = 31 * result + (lossAmount != null ? lossAmount.hashCode() : 0);
        result = 31 * result + (sufferChildAmount != null ? sufferChildAmount.hashCode() : 0);
        result = 31 * result + (lossChildAmount != null ? lossChildAmount.hashCode() : 0);
        result = 31 * result + (mtRateName != null ? mtRateName.hashCode() : 0);
        return result;
    }
}
