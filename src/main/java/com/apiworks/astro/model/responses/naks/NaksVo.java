package com.apiworks.astro.model.responses.naks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NaksVo {

    /** 本命星宿信息。 */
    @JsonProperty("natal_naks_info")
    private NaksInfo natalNaksInfo;

    /** 值日星宿信息。 */
    @JsonProperty("daily_naks_info")
    private NaksInfo dailyNaksInfo;

    /** 与他人本命星宿的关系。 */
    @JsonProperty("others_natal_relation")
    private List<NaksRelation> othersNatalRelation;

    /** 与他人值日星宿的关系。 */
    @JsonProperty("others_daily_relation")
    private List<NaksRelation> othersDailyRelation;

    /** 本命星宿解读。 */
    @JsonProperty("natal_interps")
    private List<NaksSection> natalInterps;

    /** 值日星宿解读。 */
    @JsonProperty("daily_interps")
    private List<NaksSection> dailyInterps;

    /** 分析时间。 */
    @JsonProperty("analysis_time")
    private String analysisTime;
}
