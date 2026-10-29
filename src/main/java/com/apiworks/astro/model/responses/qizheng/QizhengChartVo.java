package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 本命 + 行运。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengChartVo extends QizhengNatalVo {

    @JsonProperty("target_dt")
    private String targetDt;

    @JsonProperty("flow_year_stem")
    private String flowYearStem;

    @JsonProperty("flow_year_branch")
    private String flowYearBranch;

    @JsonProperty("flow_stars")
    private List<QizhengStarVo> flowStars;

    @JsonProperty("flow_aspects")
    private List<QizhengAspectVo> flowAspects;

    @JsonProperty("current_limits")
    private QizhengCurrentLimitsVo currentLimits;

    @JsonProperty("limit_years")
    private List<QizhengLimitYearVo> limitYears;

    public QizhengChartVo() {
    }

    public String getTargetDt() { return targetDt; }
    public void setTargetDt(String targetDt) { this.targetDt = targetDt; }

    public String getFlowYearStem() { return flowYearStem; }
    public void setFlowYearStem(String flowYearStem) { this.flowYearStem = flowYearStem; }

    public String getFlowYearBranch() { return flowYearBranch; }
    public void setFlowYearBranch(String flowYearBranch) { this.flowYearBranch = flowYearBranch; }

    public List<QizhengStarVo> getFlowStars() { return flowStars; }
    public void setFlowStars(List<QizhengStarVo> flowStars) { this.flowStars = flowStars; }

    public List<QizhengAspectVo> getFlowAspects() { return flowAspects; }
    public void setFlowAspects(List<QizhengAspectVo> flowAspects) { this.flowAspects = flowAspects; }

    public QizhengCurrentLimitsVo getCurrentLimits() { return currentLimits; }
    public void setCurrentLimits(QizhengCurrentLimitsVo currentLimits) { this.currentLimits = currentLimits; }

    public List<QizhengLimitYearVo> getLimitYears() { return limitYears; }
    public void setLimitYears(List<QizhengLimitYearVo> limitYears) { this.limitYears = limitYears; }

}
