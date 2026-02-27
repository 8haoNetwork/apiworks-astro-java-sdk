package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScopeInfoVo {

    /** 标签。 */
    @JsonProperty("label")
    private String label;

    /** 图标 URL。 */
    @JsonProperty("icon")
    private String icon;

    /** 颜色值。 */
    @JsonProperty("color")
    private String color;

    /** 运势分数。 */
    @JsonProperty("val")
    private double val;

    /** 运势内容。 */
    @JsonProperty("content")
    private String content;

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public double getVal() { return val; }
    public void setVal(double val) { this.val = val; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
