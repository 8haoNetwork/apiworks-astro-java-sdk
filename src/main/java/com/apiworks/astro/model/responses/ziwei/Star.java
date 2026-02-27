package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class Star {

    /** 星曜名称。 */
    @JsonProperty("name")
    private String name;

    /** 星曜类型。 */
    @JsonProperty("type")
    private String type;

    /** 亮度。 */
    @JsonProperty("brightness")
    private String brightness;
}
