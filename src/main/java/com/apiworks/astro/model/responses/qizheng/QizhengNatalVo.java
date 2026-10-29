package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 本命盘（不含行运）。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengNatalVo {

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("birth_dt")
    private String birthDt;

    @JsonProperty("solar_dt")
    private String solarDt;

    @JsonProperty("basic")
    private QizhengBasicVo basic;

    @JsonProperty("ming")
    private QizhengMingDegreeVo ming;

    @JsonProperty("stars")
    private List<QizhengStarVo> stars;

    @JsonProperty("palaces")
    private List<QizhengPalaceVo> palaces;

    @JsonProperty("xiu_spans")
    private List<QizhengXiuSpanVo> xiuSpans;

    @JsonProperty("hua_yao_groups")
    private List<QizhengHuaYaoGroupVo> huaYaoGroups;

    @JsonProperty("aspects")
    private List<QizhengAspectVo> aspects;

    @JsonProperty("patterns")
    private List<QizhengPatternVo> patterns;

    @JsonProperty("dongwei_segments")
    private List<QizhengDongweiSegmentVo> dongweiSegments;

    @JsonProperty("reading")
    private QizhengReadingVo reading;

    public QizhengNatalVo() {
    }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthDt() { return birthDt; }
    public void setBirthDt(String birthDt) { this.birthDt = birthDt; }

    public String getSolarDt() { return solarDt; }
    public void setSolarDt(String solarDt) { this.solarDt = solarDt; }

    public QizhengBasicVo getBasic() { return basic; }
    public void setBasic(QizhengBasicVo basic) { this.basic = basic; }

    public QizhengMingDegreeVo getMing() { return ming; }
    public void setMing(QizhengMingDegreeVo ming) { this.ming = ming; }

    public List<QizhengStarVo> getStars() { return stars; }
    public void setStars(List<QizhengStarVo> stars) { this.stars = stars; }

    public List<QizhengPalaceVo> getPalaces() { return palaces; }
    public void setPalaces(List<QizhengPalaceVo> palaces) { this.palaces = palaces; }

    public List<QizhengXiuSpanVo> getXiuSpans() { return xiuSpans; }
    public void setXiuSpans(List<QizhengXiuSpanVo> xiuSpans) { this.xiuSpans = xiuSpans; }

    public List<QizhengHuaYaoGroupVo> getHuaYaoGroups() { return huaYaoGroups; }
    public void setHuaYaoGroups(List<QizhengHuaYaoGroupVo> huaYaoGroups) { this.huaYaoGroups = huaYaoGroups; }

    public List<QizhengAspectVo> getAspects() { return aspects; }
    public void setAspects(List<QizhengAspectVo> aspects) { this.aspects = aspects; }

    public List<QizhengPatternVo> getPatterns() { return patterns; }
    public void setPatterns(List<QizhengPatternVo> patterns) { this.patterns = patterns; }

    public List<QizhengDongweiSegmentVo> getDongweiSegments() { return dongweiSegments; }
    public void setDongweiSegments(List<QizhengDongweiSegmentVo> dongweiSegments) { this.dongweiSegments = dongweiSegments; }

    public QizhengReadingVo getReading() { return reading; }
    public void setReading(QizhengReadingVo reading) { this.reading = reading; }

}
