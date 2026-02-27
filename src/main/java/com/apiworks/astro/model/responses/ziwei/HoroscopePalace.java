package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class HoroscopePalace {

    /** 宫位索引。 */
    @JsonProperty("index")
    private int index;

    /** 宫位名称。 */
    @JsonProperty("name")
    private String name;

    /** 神煞列表。 */
    @JsonProperty("spirit_stars")
    private List<String> spiritStars;

    /** 动态星列表。 */
    @JsonProperty("dynamic_stars")
    private List<String> dynamicStars;
}
