package com.apiworks.astro.model.responses.naks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class NaksSection {

    /** 段落标题。 */
    @JsonProperty("title")
    private String title;

    /** 段落内容。 */
    @JsonProperty("content")
    private String content;
}
