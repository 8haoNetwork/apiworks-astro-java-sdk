package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengDingDuVo {

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("earthly_branch")
    private String earthlyBranch;

    @JsonProperty("earthly_branch_label")
    private String earthlyBranchLabel;

    @JsonProperty("palace_degree")
    private double palaceDegree;

    @JsonProperty("xiu")
    private String xiu;

    @JsonProperty("xiu_label")
    private String xiuLabel;

    @JsonProperty("xiu_degree")
    private double xiuDegree;

    @JsonProperty("lord")
    private String lord;

    @JsonProperty("lord_label")
    private String lordLabel;

    public QizhengDingDuVo() {
    }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getEarthlyBranch() { return earthlyBranch; }
    public void setEarthlyBranch(String earthlyBranch) { this.earthlyBranch = earthlyBranch; }

    public String getEarthlyBranchLabel() { return earthlyBranchLabel; }
    public void setEarthlyBranchLabel(String earthlyBranchLabel) { this.earthlyBranchLabel = earthlyBranchLabel; }

    public double getPalaceDegree() { return palaceDegree; }
    public void setPalaceDegree(double palaceDegree) { this.palaceDegree = palaceDegree; }

    public String getXiu() { return xiu; }
    public void setXiu(String xiu) { this.xiu = xiu; }

    public String getXiuLabel() { return xiuLabel; }
    public void setXiuLabel(String xiuLabel) { this.xiuLabel = xiuLabel; }

    public double getXiuDegree() { return xiuDegree; }
    public void setXiuDegree(double xiuDegree) { this.xiuDegree = xiuDegree; }

    public String getLord() { return lord; }
    public void setLord(String lord) { this.lord = lord; }

    public String getLordLabel() { return lordLabel; }
    public void setLordLabel(String lordLabel) { this.lordLabel = lordLabel; }

}
