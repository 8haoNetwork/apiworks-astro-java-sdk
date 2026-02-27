package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZiweiDetailVo extends ZiweiChartVo {

    /** 本命星曜解读列表。 */
    @JsonProperty("natal_star_interps")
    private List<StarInterpretation> natalStarInterps;

    /** 大运星曜解读列表。 */
    @JsonProperty("decadal_star_interps")
    private List<StarInterpretation> decadalStarInterps;

    /** 流年星曜解读列表。 */
    @JsonProperty("yearly_star_interps")
    private List<StarInterpretation> yearlyStarInterps;

    /** 流月星曜解读列表。 */
    @JsonProperty("monthly_star_interps")
    private List<StarInterpretation> monthlyStarInterps;

    /** 流日星曜解读列表。 */
    @JsonProperty("daily_star_interps")
    private List<StarInterpretation> dailyStarInterps;

    /** 流时星曜解读列表。 */
    @JsonProperty("hourly_star_interps")
    private List<StarInterpretation> hourlyStarInterps;

    public List<StarInterpretation> getNatalStarInterps() { return natalStarInterps; }
    public void setNatalStarInterps(List<StarInterpretation> natalStarInterps) { this.natalStarInterps = natalStarInterps; }
    public List<StarInterpretation> getDecadalStarInterps() { return decadalStarInterps; }
    public void setDecadalStarInterps(List<StarInterpretation> decadalStarInterps) { this.decadalStarInterps = decadalStarInterps; }
    public List<StarInterpretation> getYearlyStarInterps() { return yearlyStarInterps; }
    public void setYearlyStarInterps(List<StarInterpretation> yearlyStarInterps) { this.yearlyStarInterps = yearlyStarInterps; }
    public List<StarInterpretation> getMonthlyStarInterps() { return monthlyStarInterps; }
    public void setMonthlyStarInterps(List<StarInterpretation> monthlyStarInterps) { this.monthlyStarInterps = monthlyStarInterps; }
    public List<StarInterpretation> getDailyStarInterps() { return dailyStarInterps; }
    public void setDailyStarInterps(List<StarInterpretation> dailyStarInterps) { this.dailyStarInterps = dailyStarInterps; }
    public List<StarInterpretation> getHourlyStarInterps() { return hourlyStarInterps; }
    public void setHourlyStarInterps(List<StarInterpretation> hourlyStarInterps) { this.hourlyStarInterps = hourlyStarInterps; }
}
