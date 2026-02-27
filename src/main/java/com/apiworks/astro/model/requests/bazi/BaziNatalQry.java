package com.apiworks.astro.model.requests.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 八字命盘请求。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaziNatalQry {

    /** 出生时间。 */
    @JsonProperty("birth_dt")
    private String birthDt;

    /** 时区。 */
    @JsonProperty("tz")
    private int tz = 8;

    /** 性别：male | female。 */
    @JsonProperty("gender")
    private String gender;

    /** 经度（默认 116.39）。 */
    @JsonProperty("longitude")
    private Double longitude;

    /** 纬度（默认 39.91）。 */
    @JsonProperty("latitude")
    private Double latitude;

    /** 是否使用真太阳时。 */
    @JsonProperty("is_solar_time")
    private boolean isSolarTime;

    /** 是否按“晚子时”处理。 */
    @JsonProperty("is_late_zi")
    private boolean isLateZi;

    public BaziNatalQry() {
        this.tz = 8;
        this.longitude = 116.39;
        this.latitude = 39.91;
        this.isSolarTime = false;
        this.isLateZi = false;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public int getTz() {
        return tz;
    }

    public void setTz(int tz) {
        this.tz = tz;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public boolean isSolarTime() {
        return isSolarTime;
    }

    public void setSolarTime(boolean solarTime) {
        isSolarTime = solarTime;
    }

    public boolean isLateZi() {
        return isLateZi;
    }

    public void setLateZi(boolean lateZi) {
        isLateZi = lateZi;
    }
}

