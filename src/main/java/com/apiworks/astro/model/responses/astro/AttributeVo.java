package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class AttributeVo {

    /** 火象星座中的行星。 */
    @JsonProperty("fire")
    private List<AttributePlanet> fire;

    /** 土象星座中的行星。 */
    @JsonProperty("soil")
    private List<AttributePlanet> soil;

    /** 风象星座中的行星。 */
    @JsonProperty("wind")
    private List<AttributePlanet> wind;

    /** 水象星座中的行星。 */
    @JsonProperty("water")
    private List<AttributePlanet> water;

    /** 本位星座中的行星。 */
    @JsonProperty("standard")
    private List<AttributePlanet> standard;

    /** 固定星座中的行星。 */
    @JsonProperty("fixed")
    private List<AttributePlanet> fixedAttr;

    /** 变动星座中的行星。 */
    @JsonProperty("change")
    private List<AttributePlanet> change;
}
