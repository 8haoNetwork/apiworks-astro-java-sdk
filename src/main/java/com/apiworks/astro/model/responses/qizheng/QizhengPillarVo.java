package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengPillarVo {

    @JsonProperty("stem")
    private String stem;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("stem_label")
    private String stemLabel;

    @JsonProperty("branch_label")
    private String branchLabel;

    @JsonProperty("gan_zhi")
    private String ganZhi;

    public QizhengPillarVo() {
    }

    public String getStem() { return stem; }
    public void setStem(String stem) { this.stem = stem; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getStemLabel() { return stemLabel; }
    public void setStemLabel(String stemLabel) { this.stemLabel = stemLabel; }

    public String getBranchLabel() { return branchLabel; }
    public void setBranchLabel(String branchLabel) { this.branchLabel = branchLabel; }

    public String getGanZhi() { return ganZhi; }
    public void setGanZhi(String ganZhi) { this.ganZhi = ganZhi; }

}
