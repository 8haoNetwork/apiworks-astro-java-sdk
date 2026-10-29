package com.apiworks.astro.model.requests.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 七政四余比较盘一方生辰。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengPersonQry {

    @JsonProperty("birth_dt")
    private String birthDt;

    @JsonProperty("tz")
    private int tz = 8;

    /** male | female */
    @JsonProperty("gender")
    private String gender;

    @JsonProperty("longitude")
    private Double longitude = 116.39;

    @JsonProperty("latitude")
    private Double latitude = 39.91;

    @JsonProperty("dst_auto")
    private boolean dstAuto = true;

    @JsonProperty("is_solar_time")
    private boolean solarTime;

    @JsonProperty("is_late_zi")
    private boolean lateZi;

    public QizhengPersonQry() {
    }

    public String getBirthDt() { return birthDt; }
    public void setBirthDt(String birthDt) { this.birthDt = birthDt; }
    public int getTz() { return tz; }
    public void setTz(int tz) { this.tz = tz; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public boolean isDstAuto() { return dstAuto; }
    public void setDstAuto(boolean dstAuto) { this.dstAuto = dstAuto; }
    public boolean isSolarTime() { return solarTime; }
    public void setSolarTime(boolean solarTime) { this.solarTime = solarTime; }
    public boolean isLateZi() { return lateZi; }
    public void setLateZi(boolean lateZi) { this.lateZi = lateZi; }
}
