package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengXiuSpanVo {

    /** 二十八宿 key */
    @JsonProperty("xiu")
    private String xiu;

    @JsonProperty("xiu_label")
    private String xiuLabel;

    @JsonProperty("longitude_start")
    private double longitudeStart;

    @JsonProperty("longitude_end")
    private double longitudeEnd;

    /** 度主 key */
    @JsonProperty("lord")
    private String lord;

    @JsonProperty("lord_label")
    private String lordLabel;

    public QizhengXiuSpanVo() {
    }

    public String getXiu() { return xiu; }
    public void setXiu(String xiu) { this.xiu = xiu; }

    public String getXiuLabel() { return xiuLabel; }
    public void setXiuLabel(String xiuLabel) { this.xiuLabel = xiuLabel; }

    public double getLongitudeStart() { return longitudeStart; }
    public void setLongitudeStart(double longitudeStart) { this.longitudeStart = longitudeStart; }

    public double getLongitudeEnd() { return longitudeEnd; }
    public void setLongitudeEnd(double longitudeEnd) { this.longitudeEnd = longitudeEnd; }

    public String getLord() { return lord; }
    public void setLord(String lord) { this.lord = lord; }

    public String getLordLabel() { return lordLabel; }
    public void setLordLabel(String lordLabel) { this.lordLabel = lordLabel; }

}
