package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class SignGuardian {

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
