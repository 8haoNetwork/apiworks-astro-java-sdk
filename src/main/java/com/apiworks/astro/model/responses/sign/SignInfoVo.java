package com.apiworks.astro.model.responses.sign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class SignInfoVo {

    /** 信息标签。 */
    @JsonProperty("tag")
    private String tag;

    /** 标签标题。 */
    @JsonProperty("label")
    private String label;

    /** 具体信息。 */
    @JsonProperty("info")
    private String info;
}
