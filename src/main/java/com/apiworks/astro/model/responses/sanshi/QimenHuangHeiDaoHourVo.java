package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenHuangHeiDaoHourVo {

    @JsonProperty("hour_branch")
    private String hourBranch;

    @JsonProperty("hour_label")
    private String hourLabel;

    @JsonProperty("god_code")
    private String godCode;

    @JsonProperty("god_name")
    private String godName;

    /** huang | hei */
    @JsonProperty("dao_type")
    private String daoType;

    @JsonProperty("auspicious")
    private boolean auspicious;

    @JsonProperty("brief")
    private String brief;

    public QimenHuangHeiDaoHourVo() {
    }

    public String getHourBranch() { return hourBranch; }
    public void setHourBranch(String hourBranch) { this.hourBranch = hourBranch; }

    public String getHourLabel() { return hourLabel; }
    public void setHourLabel(String hourLabel) { this.hourLabel = hourLabel; }

    public String getGodCode() { return godCode; }
    public void setGodCode(String godCode) { this.godCode = godCode; }

    public String getGodName() { return godName; }
    public void setGodName(String godName) { this.godName = godName; }

    public String getDaoType() { return daoType; }
    public void setDaoType(String daoType) { this.daoType = daoType; }

    public boolean isAuspicious() { return auspicious; }
    public void setAuspicious(boolean auspicious) { this.auspicious = auspicious; }

    public String getBrief() { return brief; }
    public void setBrief(String brief) { this.brief = brief; }

}
