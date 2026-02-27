package com.apiworks.astro.model.requests.chart;

import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 单点 + 行运日期（三限 / 次限 / 法达 / 小限 / 日弧）。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpTransitDateQry extends ChartBaseQry {

    /** 出生时间，格式 yyyy-MM-dd HH:mm:ss。 */
    @JsonProperty("birth_dt")
    private String birthDt;

    /** 时区，整数小时偏移。 */
    @JsonProperty("tz")
    private int tz;

    /** 经度（十进制度）。 */
    @JsonProperty("longitude")
    private double longitude;

    /** 纬度（十进制度）。 */
    @JsonProperty("latitude")
    private double latitude;

    /** 是否自动处理夏令时。 */
    @JsonProperty("dst_auto")
    private boolean dstAuto = true;

    /** 行运时间，格式 yyyy-MM-dd HH:mm:ss。 */
    @JsonProperty("transit_dt")
    private String transitDt;

    public SpTransitDateQry() {
        super();
    }

    public SpTransitDateQry(TimeAndLocation tl, String transitDt) {
        this();
        this.birthDt = tl.getBirthDt();
        this.tz = tl.getTz();
        this.longitude = tl.getLongitude();
        this.latitude = tl.getLatitude();
        this.dstAuto = tl.isDstAuto();
        this.transitDt = transitDt;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isDstAuto() {
        return dstAuto;
    }

    public void setDstAuto(boolean dstAuto) {
        this.dstAuto = dstAuto;
    }

    public String getTransitDt() {
        return transitDt;
    }

    public void setTransitDt(String transitDt) {
        this.transitDt = transitDt;
    }
}

