package org.kruchon.accidentAnalyzer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="ACCIDENTS")
public class Accident implements Serializable {

    private static final long serialVersionUID = -5527566248002296043L;

    @Id
    @GeneratedValue
    private Long id;
    private String emTypeName;
    private Date emMomentDate;
    private Date emMomentTime;
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
    private String trAreaStateName;
    private Integer transpAmount;
    private Integer sufferAmount;
    private Integer lossAmount;
    private Integer sufferChildAmount;
    private Integer lossChildAmount;
    private String mtRateName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmTypeName() {
        return emTypeName;
    }

    public void setEmTypeName(String emTypeName) {
        this.emTypeName = emTypeName;
    }

    public Date getEmMomentDate() {
        return emMomentDate;
    }

    public void setEmMomentDate(Date emMomentDate) {
        this.emMomentDate = emMomentDate;
    }

    public Date getEmMomentTime() {
        return emMomentTime;
    }

    public void setEmMomentTime(Date emMomentTime) {
        this.emMomentTime = emMomentTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

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

    public String getOkatoCode() {
        return okatoCode;
    }

    public void setOkatoCode(String okatoCode) {
        this.okatoCode = okatoCode;
    }

    public String getPlacePath() {
        return placePath;
    }

    public void setPlacePath(String placePath) {
        this.placePath = placePath;
    }

    public String getRoadSignificanceName() {
        return roadSignificanceName;
    }

    public void setRoadSignificanceName(String roadSignificanceName) {
        this.roadSignificanceName = roadSignificanceName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadName() {
        return roadName;
    }

    public Integer getRoadLoc() {
        return roadLoc;
    }

    public void setRoadLoc(Integer roadLoc) {
        this.roadLoc = roadLoc;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getLightTypeName() {
        return lightTypeName;
    }

    public void setLightTypeName(String lightTypeName) {
        this.lightTypeName = lightTypeName;
    }

    public String getTrAreaStateName() {
        return trAreaStateName;
    }

    public void setTrAreaStateName(String trAreaStateName) {
        this.trAreaStateName = trAreaStateName;
    }

    public Integer getTranspAmount() {
        return transpAmount;
    }

    public void setTranspAmount(Integer transpAmount) {
        this.transpAmount = transpAmount;
    }

    public Integer getSufferAmount() {
        return sufferAmount;
    }

    public void setSufferAmount(Integer sufferAmount) {
        this.sufferAmount = sufferAmount;
    }

    public Integer getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(Integer lossAmount) {
        this.lossAmount = lossAmount;
    }

    public Integer getSufferChildAmount() {
        return sufferChildAmount;
    }

    public void setSufferChildAmount(Integer sufferChildAmount) {
        this.sufferChildAmount = sufferChildAmount;
    }

    public Integer getLossChildAmount() {
        return lossChildAmount;
    }

    public void setLossChildAmount(Integer lossChildAmount) {
        this.lossChildAmount = lossChildAmount;
    }

    public String getMtRateName() {
        return mtRateName;
    }

    public void setMtRateName(String mtRateName) {
        this.mtRateName = mtRateName;
    }

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
                ", areaStateName='" + trAreaStateName + '\'' +
                ", transpAmount=" + transpAmount +
                ", sufferAmount=" + sufferAmount +
                ", lossAmount=" + lossAmount +
                ", sufferChildAmount=" + sufferChildAmount +
                ", lossChildAmount=" + lossChildAmount +
                ", mtRateName='" + mtRateName + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accident accident = (Accident) o;

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
        if (trAreaStateName != null ? !trAreaStateName.equals(accident.trAreaStateName) : accident.trAreaStateName != null)
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
        result = 31 * result + (trAreaStateName != null ? trAreaStateName.hashCode() : 0);
        result = 31 * result + (transpAmount != null ? transpAmount.hashCode() : 0);
        result = 31 * result + (sufferAmount != null ? sufferAmount.hashCode() : 0);
        result = 31 * result + (lossAmount != null ? lossAmount.hashCode() : 0);
        result = 31 * result + (sufferChildAmount != null ? sufferChildAmount.hashCode() : 0);
        result = 31 * result + (lossChildAmount != null ? lossChildAmount.hashCode() : 0);
        result = 31 * result + (mtRateName != null ? mtRateName.hashCode() : 0);
        return result;
    }
}
