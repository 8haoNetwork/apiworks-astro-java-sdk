package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenPalaceMarkerVo {

    /** kong_wang | yi_ma | … */
    @JsonProperty("code")
    private String code;

    /** 展示名 */
    @JsonProperty("name")
    private String name;

    @JsonProperty("brief")
    private String brief;

    public QimenPalaceMarkerVo() {
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrief() { return brief; }
    public void setBrief(String brief) { this.brief = brief; }

}
