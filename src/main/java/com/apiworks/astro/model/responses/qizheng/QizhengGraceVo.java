package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengGraceVo {

    @JsonProperty("degree")
    private QizhengGraceRowVo degree;

    @JsonProperty("palace")
    private QizhengGraceRowVo palace;

    public QizhengGraceVo() {
    }

    public QizhengGraceRowVo getDegree() { return degree; }
    public void setDegree(QizhengGraceRowVo degree) { this.degree = degree; }

    public QizhengGraceRowVo getPalace() { return palace; }
    public void setPalace(QizhengGraceRowVo palace) { this.palace = palace; }

}
