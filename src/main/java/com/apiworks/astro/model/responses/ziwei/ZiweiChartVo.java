package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZiweiChartVo extends ZiweiNatalVo {

    /** 流年斗君。 */
    @JsonProperty("current_year_doujun")
    private String currentYearDoujun;

    /** 大运数据。 */
    @JsonProperty("decadal")
    private Horoscope decadal;

    /** 流年数据。 */
    @JsonProperty("yearly")
    private Horoscope yearly;

    /** 流月数据。 */
    @JsonProperty("monthly")
    private Horoscope monthly;

    /** 流日数据。 */
    @JsonProperty("daily")
    private Horoscope daily;

    /** 流时数据。 */
    @JsonProperty("hourly")
    private Horoscope hourly;

    public String getCurrentYearDoujun() { return currentYearDoujun; }
    public void setCurrentYearDoujun(String currentYearDoujun) { this.currentYearDoujun = currentYearDoujun; }
    public Horoscope getDecadal() { return decadal; }
    public void setDecadal(Horoscope decadal) { this.decadal = decadal; }
    public Horoscope getYearly() { return yearly; }
    public void setYearly(Horoscope yearly) { this.yearly = yearly; }
    public Horoscope getMonthly() { return monthly; }
    public void setMonthly(Horoscope monthly) { this.monthly = monthly; }
    public Horoscope getDaily() { return daily; }
    public void setDaily(Horoscope daily) { this.daily = daily; }
    public Horoscope getHourly() { return hourly; }
    public void setHourly(Horoscope hourly) { this.hourly = hourly; }
}
