package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengXiuDegreeVo {

    /** 二十八宿 key */
    @JsonProperty("xiu")
    private String xiu;

    /** 宿内度 */
    @JsonProperty("degree")
    private double degree;

    public QizhengXiuDegreeVo() {
    }

    public String getXiu() { return xiu; }
    public void setXiu(String xiu) { this.xiu = xiu; }

    public double getDegree() { return degree; }
    public void setDegree(double degree) { this.degree = degree; }

}
