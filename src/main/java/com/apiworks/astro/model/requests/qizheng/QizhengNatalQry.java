package com.apiworks.astro.model.requests.qizheng;

import com.apiworks.astro.model.common.LangConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 七政四余本命盘请求。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengNatalQry {

    /** 语言：zh-Hans | zh-Hant，默认 zh-Hans。 */
    @JsonProperty("lang")
    private String lang = LangConstants.DEFAULT_LANG;

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

    /** tropical | sidereal */
    @JsonProperty("zodiac")
    private String zodiac = "tropical";

    /** modern（今宿）| ancient（古宿） */
    @JsonProperty("xiu_ruler")
    private String xiuRuler = "modern";

    public QizhengNatalQry() {
    }

    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }
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
    public String getZodiac() { return zodiac; }
    public void setZodiac(String zodiac) { this.zodiac = zodiac; }
    public String getXiuRuler() { return xiuRuler; }
    public void setXiuRuler(String xiuRuler) { this.xiuRuler = xiuRuler; }
}
