package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class HousePlanetArray {

    /** 度。 */
    @JsonProperty("deg")
    private int deg;

    /** 分。 */
    @JsonProperty("min")
    private int min;

    /** 秒。 */
    @JsonProperty("sec")
    private int sec;

    /** 行星黄道经度。 */
    @JsonProperty("longitude")
    private double longitude;

    /** 行星代码。 */
    @JsonProperty("planet_code")
    private String planetCode;

    /** 行星英文名。 */
    @JsonProperty("planet_en")
    private String planetEn;

    /** 行星中文名。 */
    @JsonProperty("planet_cn")
    private String planetCn;

    /** 行星字体。 */
    @JsonProperty("planet_font")
    private String planetFont;
}
