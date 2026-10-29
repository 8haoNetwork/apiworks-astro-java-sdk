package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengHuaYaoItemVo {

    @JsonProperty("key")
    private String key;

    @JsonProperty("label")
    private String label;

    @JsonProperty("natal_star")
    private String natalStar;

    @JsonProperty("natal_star_label")
    private String natalStarLabel;

    @JsonProperty("flow_star")
    private String flowStar;

    @JsonProperty("flow_star_label")
    private String flowStarLabel;

    public QizhengHuaYaoItemVo() {
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getNatalStar() { return natalStar; }
    public void setNatalStar(String natalStar) { this.natalStar = natalStar; }

    public String getNatalStarLabel() { return natalStarLabel; }
    public void setNatalStarLabel(String natalStarLabel) { this.natalStarLabel = natalStarLabel; }

    public String getFlowStar() { return flowStar; }
    public void setFlowStar(String flowStar) { this.flowStar = flowStar; }

    public String getFlowStarLabel() { return flowStarLabel; }
    public void setFlowStarLabel(String flowStarLabel) { this.flowStarLabel = flowStarLabel; }

}
