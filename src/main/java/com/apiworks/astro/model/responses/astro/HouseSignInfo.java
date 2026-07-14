package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class HouseSignInfo {

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

    /** 星座本地化名称（随 lang）。 */
    @JsonProperty("sign_name")
    private String signName = "";

    /** 星座字体。 */
    @JsonProperty("sign_font")
    private String signFont;
}
