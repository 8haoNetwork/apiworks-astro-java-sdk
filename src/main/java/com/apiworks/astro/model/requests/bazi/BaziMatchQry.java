package com.apiworks.astro.model.requests.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 八字合盘请求。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaziMatchQry extends BaziNatalQry {

    /** 对方出生时间。 */
    @JsonProperty("other_birth_dt")
    private String otherBirthDt;

    /** 对方时区。 */
    @JsonProperty("other_tz")
    private int otherTz = 8;

    /** 对方性别：male | female。 */
    @JsonProperty("other_gender")
    private String otherGender;

    /** 对方经度。 */
    @JsonProperty("other_longitude")
    private double otherLongitude = 116.39;

    /** 对方纬度。 */
    @JsonProperty("other_latitude")
    private double otherLatitude = 39.91;

    public String getOtherBirthDt() {
        return otherBirthDt;
    }

    public void setOtherBirthDt(String otherBirthDt) {
        this.otherBirthDt = otherBirthDt;
    }

    public int getOtherTz() {
        return otherTz;
    }

    public void setOtherTz(int otherTz) {
        this.otherTz = otherTz;
    }

    public String getOtherGender() {
        return otherGender;
    }

    public void setOtherGender(String otherGender) {
        this.otherGender = otherGender;
    }

    public double getOtherLongitude() {
        return otherLongitude;
    }

    public void setOtherLongitude(double otherLongitude) {
        this.otherLongitude = otherLongitude;
    }

    public double getOtherLatitude() {
        return otherLatitude;
    }

    public void setOtherLatitude(double otherLatitude) {
        this.otherLatitude = otherLatitude;
    }
}

