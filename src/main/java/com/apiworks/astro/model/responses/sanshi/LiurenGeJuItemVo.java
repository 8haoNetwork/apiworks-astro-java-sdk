package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenGeJuItemVo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("interpret")
    private LiurenInterpretVo interpret;

    public LiurenGeJuItemVo() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LiurenInterpretVo getInterpret() { return interpret; }
    public void setInterpret(LiurenInterpretVo interpret) { this.interpret = interpret; }

}
