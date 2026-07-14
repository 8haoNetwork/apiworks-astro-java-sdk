package com.apiworks.astro.model.requests.sign;

import com.apiworks.astro.model.common.LangConstants;
import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 我的星座查询（出生点 + 语言）。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignQry {

    /** 语言：zh-Hans | zh-Hant | en，默认 zh-Hans。 */
    @JsonProperty("lang")
    private String lang = LangConstants.DEFAULT_LANG;

    @JsonProperty("birth_dt")
    private String birthDt;

    @JsonProperty("tz")
    private int tz;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("dst_auto")
    private boolean dstAuto = true;

    public SignQry() {
    }

    public SignQry(TimeAndLocation point) {
        if (point != null) {
            this.birthDt = point.getBirthDt();
            this.tz = point.getTz();
            this.longitude = point.getLongitude();
            this.latitude = point.getLatitude();
            this.dstAuto = point.isDstAuto();
        }
        this.lang = LangConstants.DEFAULT_LANG;
    }

    public SignQry(TimeAndLocation point, String lang) {
        this(point);
        this.lang = lang != null ? lang : LangConstants.DEFAULT_LANG;
    }

    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }
    public String getBirthDt() { return birthDt; }
    public void setBirthDt(String birthDt) { this.birthDt = birthDt; }
    public int getTz() { return tz; }
    public void setTz(int tz) { this.tz = tz; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public boolean isDstAuto() { return dstAuto; }
    public void setDstAuto(boolean dstAuto) { this.dstAuto = dstAuto; }
}
