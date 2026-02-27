package com.apiworks.astro.model.responses.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaziFlowVO {

    /** 目标日期时间。 */
    @JsonProperty("target_dt")
    private String targetDt;

    /** 四柱信息。 */
    @JsonProperty("pillars")
    private List<PillarInfo> pillars;

    /** 大运开始时间。 */
    @JsonProperty("flow_start_dt")
    private String flowStartDt;

    /** 大运信息。 */
    @JsonProperty("flow_decadal")
    private List<FlowInfo> flowDecadal;

    /** 流年信息。 */
    @JsonProperty("flow_year")
    private List<FlowInfo> flowYear;

    /** 流月信息。 */
    @JsonProperty("flow_month")
    private List<FlowInfo> flowMonth;

    /** 流日信息。 */
    @JsonProperty("flow_day")
    private List<FlowInfo> flowDay;

    /** 流时信息。 */
    @JsonProperty("flow_hour")
    private List<FlowInfo> flowHour;

    /** 天干冲克。 */
    @JsonProperty("tg_chong_ke")
    private List<String> tgChongKe;

    /** 地支冲克。 */
    @JsonProperty("dz_chong_ke")
    private List<String> dzChongKe;

    /** 流盘天干冲克。 */
    @JsonProperty("flow_tg_chong_ke")
    private List<String> flowTgChongKe;

    /** 流盘地支冲克。 */
    @JsonProperty("flow_dz_chong_ke")
    private List<String> flowDzChongKe;

    public String getTargetDt() { return targetDt; }
    public void setTargetDt(String targetDt) { this.targetDt = targetDt; }
    public List<PillarInfo> getPillars() { return pillars; }
    public void setPillars(List<PillarInfo> pillars) { this.pillars = pillars; }
    public String getFlowStartDt() { return flowStartDt; }
    public void setFlowStartDt(String flowStartDt) { this.flowStartDt = flowStartDt; }
    public List<FlowInfo> getFlowDecadal() { return flowDecadal; }
    public void setFlowDecadal(List<FlowInfo> flowDecadal) { this.flowDecadal = flowDecadal; }
    public List<FlowInfo> getFlowYear() { return flowYear; }
    public void setFlowYear(List<FlowInfo> flowYear) { this.flowYear = flowYear; }
    public List<FlowInfo> getFlowMonth() { return flowMonth; }
    public void setFlowMonth(List<FlowInfo> flowMonth) { this.flowMonth = flowMonth; }
    public List<FlowInfo> getFlowDay() { return flowDay; }
    public void setFlowDay(List<FlowInfo> flowDay) { this.flowDay = flowDay; }
    public List<FlowInfo> getFlowHour() { return flowHour; }
    public void setFlowHour(List<FlowInfo> flowHour) { this.flowHour = flowHour; }
    public List<String> getTgChongKe() { return tgChongKe; }
    public void setTgChongKe(List<String> tgChongKe) { this.tgChongKe = tgChongKe; }
    public List<String> getDzChongKe() { return dzChongKe; }
    public void setDzChongKe(List<String> dzChongKe) { this.dzChongKe = dzChongKe; }
    public List<String> getFlowTgChongKe() { return flowTgChongKe; }
    public void setFlowTgChongKe(List<String> flowTgChongKe) { this.flowTgChongKe = flowTgChongKe; }
    public List<String> getFlowDzChongKe() { return flowDzChongKe; }
    public void setFlowDzChongKe(List<String> flowDzChongKe) { this.flowDzChongKe = flowDzChongKe; }
}
