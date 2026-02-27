package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class Pattern {

    /** 格局名称。 */
    @JsonProperty("name")
    private String name;

    /** 格局描述。 */
    @JsonProperty("description")
    private String description;
}
