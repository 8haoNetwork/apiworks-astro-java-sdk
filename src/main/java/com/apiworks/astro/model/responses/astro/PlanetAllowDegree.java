package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class PlanetAllowDegree {

    /** 对方行星代码。 */
    @JsonProperty("planet_code")
    private String planetCode;

    /** 对方行星英文名。 */
    @JsonProperty("planet_en")
    private String planetEn;

    /** 对方行星中文名。 */
    @JsonProperty("planet_cn")
    private String planetCn;

    /** 行星本地化名称（随 lang）。 */
    @JsonProperty("planet_name")
    private String planetName = "";

    /** 对方行星字体。 */
    @JsonProperty("planet_font")
    private String planetFont;

    /** 对方行星当前黄道经度。 */
    @JsonProperty("current_longitude")
    private double currentLongitude;

    /** 相位角度。 */
    @JsonProperty("asp_angle")
    private int aspAngle;

    /** 入相/出相。 */
    @JsonProperty("in_out")
    private String inOut;

    /** 度。 */
    @JsonProperty("deg")
    private int deg;

    /** 分。 */
    @JsonProperty("min")
    private int min;

    /** 秒。 */
    @JsonProperty("sec")
    private int sec;
}
