package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class SignPlanetArray {

    /** 行星代码。 */
    @JsonProperty("planet_code")
    private String planetCode;

    /** 行星英文名。 */
    @JsonProperty("planet_en")
    private String planetEn;

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

    /** 度。 */
    @JsonProperty("deg")
    private int deg;

    /** 分。 */
    @JsonProperty("min")
    private int min;

    /** 秒。 */
    @JsonProperty("sec")
    private int sec;

    /** 星座 ID。 */
    @JsonProperty("sign_id")
    private int signId;

    /** 星座英文名。 */
    @JsonProperty("sign_en")
    private String signEn;

    /** 星座中文名。 */
    @JsonProperty("sign_cn")
    private String signCn;

    /** 星座字体。 */
    @JsonProperty("sign_font")
    private String signFont;
}
