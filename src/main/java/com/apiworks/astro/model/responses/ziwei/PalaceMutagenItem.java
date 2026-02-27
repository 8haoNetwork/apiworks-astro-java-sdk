package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class PalaceMutagenItem {

    /** 星曜名称。 */
    @JsonProperty("star_name")
    private String starName;

    /** 宫位索引。 */
    @JsonProperty("palace_index")
    private int palaceIndex;

    /** 四化星类型。 */
    @JsonProperty("mutagen_type")
    private String mutagenType;
}
