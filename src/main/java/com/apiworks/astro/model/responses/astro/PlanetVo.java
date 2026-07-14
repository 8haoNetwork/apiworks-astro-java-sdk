package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class PlanetVo {

    /** 行星所在星座信息。 */
    @JsonProperty("sign")
    private PlanetSignInfo sign;

    /** 行星英文名。 */
    @JsonProperty("planet_en")
    private String planetEn;

    /** 行星代码。 */
    @JsonProperty("planet_code")
    private String planetCode;

    /** 行星中文名。 */
    @JsonProperty("planet_cn")
    private String planetCn;

    /** 行星本地化名称（随 lang）。 */
    @JsonProperty("planet_name")
    private String planetName = "";

    /** 行星黄道经度。 */
    @JsonProperty("longitude")
    private double longitude;

    /** 行星所在宫位 ID。 */
    @JsonProperty("house_id")
    private int houseId;

    /** 行星速度。 */
    @JsonProperty("speed")
    private double speed;

    /** 行星字体。 */
    @JsonProperty("planet_font")
    private String planetFont;

    /** 宫头黄道经度。 */
    @JsonProperty("house_longitude")
    private double houseLongitude;

    /** 宫头度数。 */
    @JsonProperty("house_deg")
    private int houseDeg;

    /** 宫头分数。 */
    @JsonProperty("house_min")
    private int houseMin;

    /** 宫头秒数。 */
    @JsonProperty("house_sec")
    private int houseSec;

    /** 相位容许度列表。 */
    @JsonProperty("planet_allow_degree")
    private List<PlanetAllowDegree> planetAllowDegree;
}
