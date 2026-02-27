package com.apiworks.astro.model.responses.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class WxInfo {

    /** 五行。 */
    @JsonProperty("wx")
    private String wx;

    /** 是否为日主。 */
    @JsonProperty("is_day_master")
    private boolean dayMaster;

    /** 比例。 */
    @JsonProperty("ratio")
    private double ratio;

    /** 十神列表。 */
    @JsonProperty("shi_shen")
    private List<String> shiShen;
}
