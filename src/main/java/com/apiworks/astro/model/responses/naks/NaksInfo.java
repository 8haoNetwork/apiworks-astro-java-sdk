package com.apiworks.astro.model.responses.naks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class NaksInfo {

    /** 星宿 ID。 */
    @JsonProperty("idx")
    private int idx;

    /** 星宿名称。 */
    @JsonProperty("name")
    private String name;

    /** 用户 ID。 */
    @JsonProperty("user_id")
    private String userId;
}
