package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenKeVo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("tian")
    private String tian;

    @JsonProperty("di")
    private String di;

    @JsonProperty("tian_jiang")
    private String tianJiang;

    @JsonProperty("wu_xing")
    private String wuXing;

    @JsonProperty("yin_yang")
    private String yinYang;

    @JsonProperty("wang_shuai")
    private String wangShuai;

    @JsonProperty("is_yong_shen")
    private Boolean yongShen;

    @JsonProperty("na_yin")
    private String naYin;

    @JsonProperty("interpret")
    private LiurenInterpretVo interpret;

    public LiurenKeVo() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTian() { return tian; }
    public void setTian(String tian) { this.tian = tian; }

    public String getDi() { return di; }
    public void setDi(String di) { this.di = di; }

    public String getTianJiang() { return tianJiang; }
    public void setTianJiang(String tianJiang) { this.tianJiang = tianJiang; }

    public String getWuXing() { return wuXing; }
    public void setWuXing(String wuXing) { this.wuXing = wuXing; }

    public String getYinYang() { return yinYang; }
    public void setYinYang(String yinYang) { this.yinYang = yinYang; }

    public String getWangShuai() { return wangShuai; }
    public void setWangShuai(String wangShuai) { this.wangShuai = wangShuai; }

    public Boolean getYongShen() { return yongShen; }
    public void setYongShen(Boolean yongShen) { this.yongShen = yongShen; }

    public String getNaYin() { return naYin; }
    public void setNaYin(String naYin) { this.naYin = naYin; }

    public LiurenInterpretVo getInterpret() { return interpret; }
    public void setInterpret(LiurenInterpretVo interpret) { this.interpret = interpret; }

}
