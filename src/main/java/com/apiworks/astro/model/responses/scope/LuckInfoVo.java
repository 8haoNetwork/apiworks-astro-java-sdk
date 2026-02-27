package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LuckInfoVo {

    /** 标签。 */
    @JsonProperty("label")
    private String label;

    /** 值。 */
    @JsonProperty("val")
    private String val;

    /** 图标 URL。 */
    @JsonProperty("icon")
    private String icon;

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public String getVal() { return val; }
    public void setVal(String val) { this.val = val; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
}
