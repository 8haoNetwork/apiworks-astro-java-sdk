package com.apiworks.astro.model.requests.naks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 星宿出生信息。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaksBirthInfo {

    /** 出生时间。 */
    @JsonProperty("birth_dt")
    private String birthDt;

    /** 时区。 */
    @JsonProperty("tz")
    private int tz = 8;

    /** 经度。 */
    @JsonProperty("longitude")
    private Double longitude;

    /** 纬度。 */
    @JsonProperty("latitude")
    private Double latitude;

    /** 用户 ID，用于在响应中回显。 */
    @JsonProperty("user_id")
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

