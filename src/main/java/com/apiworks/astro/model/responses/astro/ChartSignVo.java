package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class ChartSignVo {

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

    /** 星座属性列表。 */
    @JsonProperty("sign_attribute")
    private List<String> signAttribute;

    /** 守护星列表。 */
    @JsonProperty("sign_guardian")
    private List<SignGuardian> signGuardian;

    /** 星座内行星列表。 */
    @JsonProperty("planet_array")
    private List<SignPlanetArray> planetArray;
}
