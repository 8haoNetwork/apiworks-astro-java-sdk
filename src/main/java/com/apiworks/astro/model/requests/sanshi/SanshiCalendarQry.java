package com.apiworks.astro.model.requests.sanshi;

import com.apiworks.astro.model.common.LangConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 奇门 / 六壬共用的历法查询字段。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SanshiCalendarQry {

    /** 语言：zh-Hans | zh-Hant，默认 zh-Hans。 */
    @JsonProperty("lang")
    private String lang = LangConstants.DEFAULT_LANG;

    /** 查询时间，格式 yyyy-MM-dd HH:mm:ss。 */
    @JsonProperty("qry_dt")
    private String qryDt;

    /** 时区。 */
    @JsonProperty("tz")
    private Integer tz = 8;

    /** 是否自动夏令时（中国）。 */
    @JsonProperty("dst_auto")
    private boolean dstAuto = true;

    /** 经度（真太阳时用，默认 120.0）。 */
    @JsonProperty("longitude")
    private Double longitude = 120.0;

    /** 纬度（真太阳时用）。 */
    @JsonProperty("latitude")
    private Double latitude;

    /** 是否使用真太阳时。 */
    @JsonProperty("is_solar_time")
    private boolean solarTime;

    public SanshiCalendarQry() {
    }

    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }
    public String getQryDt() { return qryDt; }
    public void setQryDt(String qryDt) { this.qryDt = qryDt; }
    public Integer getTz() { return tz; }
    public void setTz(Integer tz) { this.tz = tz; }
    public boolean isDstAuto() { return dstAuto; }
    public void setDstAuto(boolean dstAuto) { this.dstAuto = dstAuto; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public boolean isSolarTime() { return solarTime; }
    public void setSolarTime(boolean solarTime) { this.solarTime = solarTime; }
}
