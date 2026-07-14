package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenPalaceAuxVo {

    @JsonProperty("gan")
    private QimenGanAuxVo gan;

    public QimenPalaceAuxVo() {
    }

    public QimenGanAuxVo getGan() { return gan; }
    public void setGan(QimenGanAuxVo gan) { this.gan = gan; }

}
