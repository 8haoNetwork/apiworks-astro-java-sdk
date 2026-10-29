package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengDongweiSegmentVo {

    @JsonProperty("sequence")
    private int sequence;

    @JsonProperty("palace_index")
    private int palaceIndex;

    @JsonProperty("palace_key")
    private String palaceKey;

    @JsonProperty("earthly_branch")
    private String earthlyBranch;

    @JsonProperty("span_years")
    private double spanYears;

    @JsonProperty("start_age")
    private double startAge;

    @JsonProperty("end_age")
    private double endAge;

    @JsonProperty("start_year")
    private int startYear;

    @JsonProperty("end_year")
    private int endYear;

    public QizhengDongweiSegmentVo() {
    }

    public int getSequence() { return sequence; }
    public void setSequence(int sequence) { this.sequence = sequence; }

    public int getPalaceIndex() { return palaceIndex; }
    public void setPalaceIndex(int palaceIndex) { this.palaceIndex = palaceIndex; }

    public String getPalaceKey() { return palaceKey; }
    public void setPalaceKey(String palaceKey) { this.palaceKey = palaceKey; }

    public String getEarthlyBranch() { return earthlyBranch; }
    public void setEarthlyBranch(String earthlyBranch) { this.earthlyBranch = earthlyBranch; }

    public double getSpanYears() { return spanYears; }
    public void setSpanYears(double spanYears) { this.spanYears = spanYears; }

    public double getStartAge() { return startAge; }
    public void setStartAge(double startAge) { this.startAge = startAge; }

    public double getEndAge() { return endAge; }
    public void setEndAge(double endAge) { this.endAge = endAge; }

    public int getStartYear() { return startYear; }
    public void setStartYear(int startYear) { this.startYear = startYear; }

    public int getEndYear() { return endYear; }
    public void setEndYear(int endYear) { this.endYear = endYear; }

}
