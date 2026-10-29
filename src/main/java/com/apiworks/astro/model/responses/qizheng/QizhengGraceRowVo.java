package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengGraceRowVo {

    @JsonProperty("self_wx")
    private String selfWx;

    @JsonProperty("self_wx_label")
    private String selfWxLabel;

    @JsonProperty("grace")
    private String grace;

    @JsonProperty("grace_label")
    private String graceLabel;

    @JsonProperty("useful")
    private String useful;

    @JsonProperty("useful_label")
    private String usefulLabel;

    @JsonProperty("foe")
    private String foe;

    @JsonProperty("foe_label")
    private String foeLabel;

    @JsonProperty("hardship")
    private String hardship;

    @JsonProperty("hardship_label")
    private String hardshipLabel;

    public QizhengGraceRowVo() {
    }

    public String getSelfWx() { return selfWx; }
    public void setSelfWx(String selfWx) { this.selfWx = selfWx; }

    public String getSelfWxLabel() { return selfWxLabel; }
    public void setSelfWxLabel(String selfWxLabel) { this.selfWxLabel = selfWxLabel; }

    public String getGrace() { return grace; }
    public void setGrace(String grace) { this.grace = grace; }

    public String getGraceLabel() { return graceLabel; }
    public void setGraceLabel(String graceLabel) { this.graceLabel = graceLabel; }

    public String getUseful() { return useful; }
    public void setUseful(String useful) { this.useful = useful; }

    public String getUsefulLabel() { return usefulLabel; }
    public void setUsefulLabel(String usefulLabel) { this.usefulLabel = usefulLabel; }

    public String getFoe() { return foe; }
    public void setFoe(String foe) { this.foe = foe; }

    public String getFoeLabel() { return foeLabel; }
    public void setFoeLabel(String foeLabel) { this.foeLabel = foeLabel; }

    public String getHardship() { return hardship; }
    public void setHardship(String hardship) { this.hardship = hardship; }

    public String getHardshipLabel() { return hardshipLabel; }
    public void setHardshipLabel(String hardshipLabel) { this.hardshipLabel = hardshipLabel; }

}
