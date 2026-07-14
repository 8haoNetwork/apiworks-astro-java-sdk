package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenPalaceNoteVo {

    @JsonProperty("earth")
    private String earth;

    @JsonProperty("sky")
    private String sky;

    @JsonProperty("tian_jiang")
    private String tianJiang;

    @JsonProperty("is_shi")
    private boolean shi;

    @JsonProperty("is_di_fen")
    private boolean diFen;

    @JsonProperty("interpret")
    private LiurenInterpretVo interpret;

    public LiurenPalaceNoteVo() {
    }

    public String getEarth() { return earth; }
    public void setEarth(String earth) { this.earth = earth; }

    public String getSky() { return sky; }
    public void setSky(String sky) { this.sky = sky; }

    public String getTianJiang() { return tianJiang; }
    public void setTianJiang(String tianJiang) { this.tianJiang = tianJiang; }

    public boolean isShi() { return shi; }
    public void setShi(boolean shi) { this.shi = shi; }

    public boolean isDiFen() { return diFen; }
    public void setDiFen(boolean diFen) { this.diFen = diFen; }

    public LiurenInterpretVo getInterpret() { return interpret; }
    public void setInterpret(LiurenInterpretVo interpret) { this.interpret = interpret; }

}
