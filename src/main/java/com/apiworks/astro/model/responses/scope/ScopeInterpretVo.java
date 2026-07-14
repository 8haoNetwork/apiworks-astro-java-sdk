package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 运势语料（含 impact_info）。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScopeInterpretVo {

    @JsonProperty("chartType")
    private String chartType;

    @JsonProperty("from_cn")
    private String fromCn;

    @JsonProperty("to_cn")
    private String toCn;

    @JsonProperty("from_en")
    private String fromEn;

    @JsonProperty("to_en")
    private String toEn;

    /** 主体对象本地化名称（随 lang）。 */
    @JsonProperty("from_name")
    private String fromName = "";

    /** 客体对象本地化名称（随 lang）。 */
    @JsonProperty("to_name")
    private String toName = "";

    @JsonProperty("type")
    private String type;

    @JsonProperty("in_out")
    private String inOut;

    @JsonProperty("occurred_at_ts")
    private Long occurredAtTs;

    @JsonProperty("start_days")
    private Integer startDays;

    @JsonProperty("start_days_desc")
    private String startDaysDesc;

    @JsonProperty("remain_days")
    private Integer remainDays;

    @JsonProperty("remain_days_desc")
    private String remainDaysDesc;

    @JsonProperty("total_span_days")
    private Integer totalSpanDays;

    @JsonProperty("jx_type")
    private String jxType;

    @JsonProperty("tip")
    private String tip;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("impact_info")
    private List<ImpactInfo> impactInfo;

    public String getChartType() { return chartType; }
    public void setChartType(String chartType) { this.chartType = chartType; }
    public String getFromCn() { return fromCn; }
    public void setFromCn(String fromCn) { this.fromCn = fromCn; }
    public String getToCn() { return toCn; }
    public void setToCn(String toCn) { this.toCn = toCn; }
    public String getFromEn() { return fromEn; }
    public void setFromEn(String fromEn) { this.fromEn = fromEn; }
    public String getToEn() { return toEn; }
    public void setToEn(String toEn) { this.toEn = toEn; }
    public String getFromName() { return fromName; }
    public void setFromName(String fromName) { this.fromName = fromName; }
    public String getToName() { return toName; }
    public void setToName(String toName) { this.toName = toName; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getInOut() { return inOut; }
    public void setInOut(String inOut) { this.inOut = inOut; }
    public Long getOccurredAtTs() { return occurredAtTs; }
    public void setOccurredAtTs(Long occurredAtTs) { this.occurredAtTs = occurredAtTs; }
    public Integer getStartDays() { return startDays; }
    public void setStartDays(Integer startDays) { this.startDays = startDays; }
    public String getStartDaysDesc() { return startDaysDesc; }
    public void setStartDaysDesc(String startDaysDesc) { this.startDaysDesc = startDaysDesc; }
    public Integer getRemainDays() { return remainDays; }
    public void setRemainDays(Integer remainDays) { this.remainDays = remainDays; }
    public String getRemainDaysDesc() { return remainDaysDesc; }
    public void setRemainDaysDesc(String remainDaysDesc) { this.remainDaysDesc = remainDaysDesc; }
    public Integer getTotalSpanDays() { return totalSpanDays; }
    public void setTotalSpanDays(Integer totalSpanDays) { this.totalSpanDays = totalSpanDays; }
    public String getJxType() { return jxType; }
    public void setJxType(String jxType) { this.jxType = jxType; }
    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public List<ImpactInfo> getImpactInfo() { return impactInfo; }
    public void setImpactInfo(List<ImpactInfo> impactInfo) { this.impactInfo = impactInfo; }
}
