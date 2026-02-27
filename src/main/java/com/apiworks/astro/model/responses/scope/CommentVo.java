package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentVo {

    /** 运势偏好。 */
    @JsonProperty("prefer")
    private String prefer;

    /** 运势避免。 */
    @JsonProperty("avoid")
    private String avoid;

    /** 运势总结。 */
    @JsonProperty("summary")
    private String summary;

    public String getPrefer() { return prefer; }
    public void setPrefer(String prefer) { this.prefer = prefer; }
    public String getAvoid() { return avoid; }
    public void setAvoid(String avoid) { this.avoid = avoid; }
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
}
