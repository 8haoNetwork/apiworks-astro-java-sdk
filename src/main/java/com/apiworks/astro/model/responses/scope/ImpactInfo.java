package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 运势语料对维度的影响倾向。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImpactInfo {

    /** 维度 key，如 love/study。 */
    @JsonProperty("key")
    private String key;

    /** 维度本地化名。 */
    @JsonProperty("cn_name")
    private String cnName;

    /** up | down */
    @JsonProperty("trend")
    private String trend;

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public String getCnName() { return cnName; }
    public void setCnName(String cnName) { this.cnName = cnName; }
    public String getTrend() { return trend; }
    public void setTrend(String trend) { this.trend = trend; }
}
