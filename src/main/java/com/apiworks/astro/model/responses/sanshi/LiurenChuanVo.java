package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenChuanVo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("zhi")
    private String zhi;

    @JsonProperty("gan_zhi")
    private String ganZhi;

    @JsonProperty("tian_jiang")
    private String tianJiang;

    @JsonProperty("liu_qin")
    private String liuQin;

    @JsonProperty("kong_wang")
    private String kongWang;

    @JsonProperty("shen")
    private String shen;

    @JsonProperty("interpret")
    private LiurenInterpretVo interpret;

    public LiurenChuanVo() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getZhi() { return zhi; }
    public void setZhi(String zhi) { this.zhi = zhi; }

    public String getGanZhi() { return ganZhi; }
    public void setGanZhi(String ganZhi) { this.ganZhi = ganZhi; }

    public String getTianJiang() { return tianJiang; }
    public void setTianJiang(String tianJiang) { this.tianJiang = tianJiang; }

    public String getLiuQin() { return liuQin; }
    public void setLiuQin(String liuQin) { this.liuQin = liuQin; }

    public String getKongWang() { return kongWang; }
    public void setKongWang(String kongWang) { this.kongWang = kongWang; }

    public String getShen() { return shen; }
    public void setShen(String shen) { this.shen = shen; }

    public LiurenInterpretVo getInterpret() { return interpret; }
    public void setInterpret(LiurenInterpretVo interpret) { this.interpret = interpret; }

}
