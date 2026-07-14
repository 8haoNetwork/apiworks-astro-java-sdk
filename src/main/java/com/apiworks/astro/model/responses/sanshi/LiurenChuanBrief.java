package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenChuanBrief {

    @JsonProperty("name")
    private String name;

    @JsonProperty("gan_zhi")
    private String ganZhi;

    @JsonProperty("shen")
    private String shen;

    public LiurenChuanBrief() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGanZhi() { return ganZhi; }
    public void setGanZhi(String ganZhi) { this.ganZhi = ganZhi; }

    public String getShen() { return shen; }
    public void setShen(String shen) { this.shen = shen; }

}
