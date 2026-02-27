package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class StarWithMutagen {

    /** 星曜名称。 */
    @JsonProperty("name")
    private String name;

    /** 星曜类型。 */
    @JsonProperty("type")
    private String type;

    /** 亮度。 */
    @JsonProperty("brightness")
    private String brightness;

    /** 四化星变换类型列表。 */
    @JsonProperty("transform_types")
    private List<TransformInfo> transformTypes;
}
