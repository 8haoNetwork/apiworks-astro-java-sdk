package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class HouseVo {

    /** 宫头所在星座信息。 */
    @JsonProperty("sign")
    private HouseSignInfo sign;

    /** 宫头黄道经度。 */
    @JsonProperty("longitude")
    private double longitude;

    /** 宫位 ID。 */
    @JsonProperty("house_id")
    private int houseId;

    /** 宫位名称。 */
    @JsonProperty("house_life")
    private String houseLife;

    /** 宫主星列表。 */
    @JsonProperty("main_planet")
    private List<MainPlanet> mainPlanet;

    /** 宫位内行星列表。 */
    @JsonProperty("planet_array")
    private List<HousePlanetArray> planetArray;
}
