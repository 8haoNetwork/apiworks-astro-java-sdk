package com.apiworks.astro.model.responses.naks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class NaksRelationComments {

    /** 关系描述。 */
    @JsonProperty("description")
    private String description;

    /** 段落列表。 */
    @JsonProperty("comments")
    private List<NaksSection> comments;
}
