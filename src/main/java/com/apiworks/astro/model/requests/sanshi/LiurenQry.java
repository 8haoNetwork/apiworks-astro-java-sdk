package com.apiworks.astro.model.requests.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 大六壬 / 金口诀排盘请求。
 * <p>
 * type: daliuren（默认）| jinkoujue
 * gui_method: tian（天贵，默认）| di（地贵）
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenQry extends SanshiCalendarQry {

    /** daliuren | jinkoujue */
    @JsonProperty("type")
    private String type = "daliuren";

    /** 金口诀地分：zi…hai */
    @JsonProperty("di_fen")
    private String diFen;

    /** tian | di */
    @JsonProperty("gui_method")
    private String guiMethod = "tian";

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDiFen() { return diFen; }
    public void setDiFen(String diFen) { this.diFen = diFen; }
    public String getGuiMethod() { return guiMethod; }
    public void setGuiMethod(String guiMethod) { this.guiMethod = guiMethod; }
}
