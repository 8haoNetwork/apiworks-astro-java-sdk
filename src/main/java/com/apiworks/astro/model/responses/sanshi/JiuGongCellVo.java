package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiuGongCellVo {

    /** 1–9 */
    @JsonProperty("luoshu")
    private int luoshu;

    /** 卦名 */
    @JsonProperty("bagua")
    private String bagua;

    /** 宫标识 */
    @JsonProperty("gong")
    private String gong;

    /** 宫位五行 */
    @JsonProperty("wuxing")
    private String wuxing;

    @JsonProperty("di_pan_gan")
    private List<String> diPanGan;

    @JsonProperty("tian_pan_gan")
    private List<String> tianPanGan;

    @JsonProperty("an_gan")
    private String anGan;

    @JsonProperty("an_gan_layers")
    private List<String> anGanLayers;

    @JsonProperty("shen_trail")
    private String shenTrail;

    @JsonProperty("men_trail")
    private String menTrail;

    @JsonProperty("jiu_xing")
    private String jiuXing;

    @JsonProperty("ba_men")
    private String baMen;

    @JsonProperty("ba_shen")
    private String baShen;

    @JsonProperty("ge_ju")
    private QimenGeJuVo geJu;

    @JsonProperty("markers")
    private List<QimenPalaceMarkerVo> markers;

    @JsonProperty("palace_aux")
    private QimenPalaceAuxVo palaceAux;

    @JsonProperty("ying_qi")
    private QimenYingQiVo yingQi;

    @JsonProperty("nei_wai")
    private String neiWai;

    @JsonProperty("shen_xing")
    private String shenXing;

    @JsonProperty("ju")
    private String ju;

    public JiuGongCellVo() {
    }

    public int getLuoshu() { return luoshu; }
    public void setLuoshu(int luoshu) { this.luoshu = luoshu; }

    public String getBagua() { return bagua; }
    public void setBagua(String bagua) { this.bagua = bagua; }

    public String getGong() { return gong; }
    public void setGong(String gong) { this.gong = gong; }

    public String getWuxing() { return wuxing; }
    public void setWuxing(String wuxing) { this.wuxing = wuxing; }

    public List<String> getDiPanGan() { return diPanGan; }
    public void setDiPanGan(List<String> diPanGan) { this.diPanGan = diPanGan; }

    public List<String> getTianPanGan() { return tianPanGan; }
    public void setTianPanGan(List<String> tianPanGan) { this.tianPanGan = tianPanGan; }

    public String getAnGan() { return anGan; }
    public void setAnGan(String anGan) { this.anGan = anGan; }

    public List<String> getAnGanLayers() { return anGanLayers; }
    public void setAnGanLayers(List<String> anGanLayers) { this.anGanLayers = anGanLayers; }

    public String getShenTrail() { return shenTrail; }
    public void setShenTrail(String shenTrail) { this.shenTrail = shenTrail; }

    public String getMenTrail() { return menTrail; }
    public void setMenTrail(String menTrail) { this.menTrail = menTrail; }

    public String getJiuXing() { return jiuXing; }
    public void setJiuXing(String jiuXing) { this.jiuXing = jiuXing; }

    public String getBaMen() { return baMen; }
    public void setBaMen(String baMen) { this.baMen = baMen; }

    public String getBaShen() { return baShen; }
    public void setBaShen(String baShen) { this.baShen = baShen; }

    public QimenGeJuVo getGeJu() { return geJu; }
    public void setGeJu(QimenGeJuVo geJu) { this.geJu = geJu; }

    public List<QimenPalaceMarkerVo> getMarkers() { return markers; }
    public void setMarkers(List<QimenPalaceMarkerVo> markers) { this.markers = markers; }

    public QimenPalaceAuxVo getPalaceAux() { return palaceAux; }
    public void setPalaceAux(QimenPalaceAuxVo palaceAux) { this.palaceAux = palaceAux; }

    public QimenYingQiVo getYingQi() { return yingQi; }
    public void setYingQi(QimenYingQiVo yingQi) { this.yingQi = yingQi; }

    public String getNeiWai() { return neiWai; }
    public void setNeiWai(String neiWai) { this.neiWai = neiWai; }

    public String getShenXing() { return shenXing; }
    public void setShenXing(String shenXing) { this.shenXing = shenXing; }

    public String getJu() { return ju; }
    public void setJu(String ju) { this.ju = ju; }

}
