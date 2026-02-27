package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class TransformInfo {

    /** 四化星类型。 */
    @JsonProperty("mutagen_type")
    private String mutagenType;

    /** 四化星变换类型。 */
    @JsonProperty("transform_type")
    private String transformType;
}
