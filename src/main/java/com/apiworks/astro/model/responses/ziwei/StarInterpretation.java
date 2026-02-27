package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class StarInterpretation {

    /** 星曜名称。 */
    @JsonProperty("star_name")
    private String starName;

    /** 宫位名称。 */
    @JsonProperty("palace_name")
    private String palaceName;

    /** 解读内容。 */
    @JsonProperty("interpretation")
    private String interpretation;
}
