package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenGanStateVo {

    @JsonProperty("changsheng")
    private String changsheng;

    @JsonProperty("wang_shuai")
    private String wangShuai;

    public QimenGanStateVo() {
    }

    public String getChangsheng() { return changsheng; }
    public void setChangsheng(String changsheng) { this.changsheng = changsheng; }

    public String getWangShuai() { return wangShuai; }
    public void setWangShuai(String wangShuai) { this.wangShuai = wangShuai; }

}
