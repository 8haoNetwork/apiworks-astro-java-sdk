package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScopeTotalVo {

    /** 标签。 */
    @JsonProperty("label")
    private String label;

    /** 运势分数 0-100。 */
    @JsonProperty("val")
    private double val;

    /** 开始日期。 */
    @JsonProperty("start_date")
    private String startDate;

    /** 结束日期。 */
    @JsonProperty("end_date")
    private String endDate;

    /** 提示信息。 */
    @JsonProperty("tips")
    private String tips;

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public double getVal() { return val; }
    public void setVal(double val) { this.val = val; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getTips() { return tips; }
    public void setTips(String tips) { this.tips = tips; }
}
