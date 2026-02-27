package com.apiworks.astro.model.responses.naks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class NaksRelation {

    /** 目标星宿。 */
    @JsonProperty("other_naks")
    private NaksInfo otherNaks;

    /** 关系类型。 */
    @JsonProperty("relation_type")
    private String relationType;

    /** 是否为反向关系。 */
    @JsonProperty("is_reverse")
    private boolean reverse;

    /** 关系解读。 */
    @JsonProperty("comments")
    private NaksRelationComments comments;
}
