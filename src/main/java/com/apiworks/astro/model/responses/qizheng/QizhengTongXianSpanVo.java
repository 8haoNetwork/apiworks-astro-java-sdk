package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengTongXianSpanVo {

    @JsonProperty("years")
    private int years;

    @JsonProperty("months")
    private int months;

    @JsonProperty("days")
    private int days;

    @JsonProperty("exit_date")
    private String exitDate;

    @JsonProperty("label")
    private String label;

    public QizhengTongXianSpanVo() {
    }

    public int getYears() { return years; }
    public void setYears(int years) { this.years = years; }

    public int getMonths() { return months; }
    public void setMonths(int months) { this.months = months; }

    public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }

    public String getExitDate() { return exitDate; }
    public void setExitDate(String exitDate) { this.exitDate = exitDate; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

}
