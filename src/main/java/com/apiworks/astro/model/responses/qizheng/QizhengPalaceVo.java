package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengPalaceVo {

    @JsonProperty("index")
    private int index;

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("earthly_branch")
    private String earthlyBranch;

    @JsonProperty("earthly_branch_label")
    private String earthlyBranchLabel;

    @JsonProperty("spirit_stars")
    private List<String> spiritStars;

    @JsonProperty("spirit_star_labels")
    private List<String> spiritStarLabels;

    @JsonProperty("flow_spirit_stars")
    private List<String> flowSpiritStars;

    @JsonProperty("flow_spirit_star_labels")
    private List<String> flowSpiritStarLabels;

    @JsonProperty("changsheng")
    private String changsheng;

    @JsonProperty("changsheng_label")
    private String changshengLabel;

    public QizhengPalaceVo() {
    }

    public int getIndex() { return index; }
    public void setIndex(int index) { this.index = index; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEarthlyBranch() { return earthlyBranch; }
    public void setEarthlyBranch(String earthlyBranch) { this.earthlyBranch = earthlyBranch; }

    public String getEarthlyBranchLabel() { return earthlyBranchLabel; }
    public void setEarthlyBranchLabel(String earthlyBranchLabel) { this.earthlyBranchLabel = earthlyBranchLabel; }

    public List<String> getSpiritStars() { return spiritStars; }
    public void setSpiritStars(List<String> spiritStars) { this.spiritStars = spiritStars; }

    public List<String> getSpiritStarLabels() { return spiritStarLabels; }
    public void setSpiritStarLabels(List<String> spiritStarLabels) { this.spiritStarLabels = spiritStarLabels; }

    public List<String> getFlowSpiritStars() { return flowSpiritStars; }
    public void setFlowSpiritStars(List<String> flowSpiritStars) { this.flowSpiritStars = flowSpiritStars; }

    public List<String> getFlowSpiritStarLabels() { return flowSpiritStarLabels; }
    public void setFlowSpiritStarLabels(List<String> flowSpiritStarLabels) { this.flowSpiritStarLabels = flowSpiritStarLabels; }

    public String getChangsheng() { return changsheng; }
    public void setChangsheng(String changsheng) { this.changsheng = changsheng; }

    public String getChangshengLabel() { return changshengLabel; }
    public void setChangshengLabel(String changshengLabel) { this.changshengLabel = changshengLabel; }

}
