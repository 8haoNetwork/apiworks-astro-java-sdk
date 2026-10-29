package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 比较盘：A 本命壳 + flow_* 承载 B。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengComparisonVo extends QizhengNatalVo {

    @JsonProperty("other_gender")
    private String otherGender;

    @JsonProperty("other_birth_dt")
    private String otherBirthDt;

    @JsonProperty("other_solar_dt")
    private String otherSolarDt;

    @JsonProperty("other_ming")
    private QizhengMingDegreeVo otherMing;

    @JsonProperty("flow_stars")
    private List<QizhengStarVo> flowStars;

    @JsonProperty("flow_aspects")
    private List<QizhengAspectVo> flowAspects;

    public QizhengComparisonVo() {
    }

    public String getOtherGender() { return otherGender; }
    public void setOtherGender(String otherGender) { this.otherGender = otherGender; }

    public String getOtherBirthDt() { return otherBirthDt; }
    public void setOtherBirthDt(String otherBirthDt) { this.otherBirthDt = otherBirthDt; }

    public String getOtherSolarDt() { return otherSolarDt; }
    public void setOtherSolarDt(String otherSolarDt) { this.otherSolarDt = otherSolarDt; }

    public QizhengMingDegreeVo getOtherMing() { return otherMing; }
    public void setOtherMing(QizhengMingDegreeVo otherMing) { this.otherMing = otherMing; }

    public List<QizhengStarVo> getFlowStars() { return flowStars; }
    public void setFlowStars(List<QizhengStarVo> flowStars) { this.flowStars = flowStars; }

    public List<QizhengAspectVo> getFlowAspects() { return flowAspects; }
    public void setFlowAspects(List<QizhengAspectVo> flowAspects) { this.flowAspects = flowAspects; }

}
