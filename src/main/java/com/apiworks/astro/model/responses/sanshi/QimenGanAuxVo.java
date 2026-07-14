package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenGanAuxVo {

    @JsonProperty("tian")
    private QimenGanStateVo tian;

    @JsonProperty("di")
    private QimenGanStateVo di;

    public QimenGanAuxVo() {
    }

    public QimenGanStateVo getTian() { return tian; }
    public void setTian(QimenGanStateVo tian) { this.tian = tian; }

    public QimenGanStateVo getDi() { return di; }
    public void setDi(QimenGanStateVo di) { this.di = di; }

}
