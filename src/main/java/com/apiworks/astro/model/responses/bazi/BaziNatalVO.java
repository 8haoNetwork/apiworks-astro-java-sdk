package com.apiworks.astro.model.responses.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaziNatalVO {

    /** 出生时间。 */
    @JsonProperty("birth_dt")
    private String birthDt;

    /** 真太阳时。 */
    @JsonProperty("birth_solar_dt")
    private String birthSolarDt;

    /** 出生节气。 */
    @JsonProperty("birth_solar_term")
    private String birthSolarTerm;

    /** 天干冲克。 */
    @JsonProperty("tg_chong_ke")
    private List<String> tgChongKe;

    /** 地支冲克。 */
    @JsonProperty("dz_chong_ke")
    private List<String> dzChongKe;

    /** 四柱信息。 */
    @JsonProperty("pillars")
    private List<PillarInfo> pillars;

    /** 大运开始时间。 */
    @JsonProperty("flow_start_dt")
    private String flowStartDt;

    /** 大运信息。 */
    @JsonProperty("flow_decadal")
    private List<FlowInfo> flowDecadal;

    /** 旺相囚死。 */
    @JsonProperty("wang_xiang")
    private List<String> wangXiang;

    public String getBirthDt() { return birthDt; }
    public void setBirthDt(String birthDt) { this.birthDt = birthDt; }
    public String getBirthSolarDt() { return birthSolarDt; }
    public void setBirthSolarDt(String birthSolarDt) { this.birthSolarDt = birthSolarDt; }
    public String getBirthSolarTerm() { return birthSolarTerm; }
    public void setBirthSolarTerm(String birthSolarTerm) { this.birthSolarTerm = birthSolarTerm; }
    public List<String> getTgChongKe() { return tgChongKe; }
    public void setTgChongKe(List<String> tgChongKe) { this.tgChongKe = tgChongKe; }
    public List<String> getDzChongKe() { return dzChongKe; }
    public void setDzChongKe(List<String> dzChongKe) { this.dzChongKe = dzChongKe; }
    public List<PillarInfo> getPillars() { return pillars; }
    public void setPillars(List<PillarInfo> pillars) { this.pillars = pillars; }
    public String getFlowStartDt() { return flowStartDt; }
    public void setFlowStartDt(String flowStartDt) { this.flowStartDt = flowStartDt; }
    public List<FlowInfo> getFlowDecadal() { return flowDecadal; }
    public void setFlowDecadal(List<FlowInfo> flowDecadal) { this.flowDecadal = flowDecadal; }
    public List<String> getWangXiang() { return wangXiang; }
    public void setWangXiang(List<String> wangXiang) { this.wangXiang = wangXiang; }
}
