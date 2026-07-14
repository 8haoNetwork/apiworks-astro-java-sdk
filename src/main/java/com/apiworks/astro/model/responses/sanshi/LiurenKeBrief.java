package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 奇门穿壬附带的六壬四课简版。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenKeBrief {

    @JsonProperty("name")
    private String name;

    @JsonProperty("tian")
    private String tian;

    @JsonProperty("di")
    private String di;

    public LiurenKeBrief() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTian() { return tian; }
    public void setTian(String tian) { this.tian = tian; }

    public String getDi() { return di; }
    public void setDi(String di) { this.di = di; }

}
