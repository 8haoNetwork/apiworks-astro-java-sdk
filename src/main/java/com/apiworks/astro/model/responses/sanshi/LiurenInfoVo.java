package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 奇门穿壬附带的六壬简数据。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenInfoVo {

    @JsonProperty("input_time")
    private String inputTime;

    @JsonProperty("true_solar_time")
    private String trueSolarTime;

    @JsonProperty("lunar")
    private String lunar;

    @JsonProperty("type")
    private String type;

    @JsonProperty("day_gan_zhi")
    private String dayGanZhi;

    @JsonProperty("yue_jiang")
    private String yueJiang;

    @JsonProperty("shi")
    private String shi;

    @JsonProperty("tian_pan")
    private Map<String, String> tianPan;

    @JsonProperty("di_pan")
    private Map<String, String> diPan;

    @JsonProperty("si_ke")
    private List<LiurenKeBrief> siKe;

    @JsonProperty("san_chuan")
    private List<LiurenChuanBrief> sanChuan;

    @JsonProperty("tian_jiang")
    private Map<String, String> tianJiang;

    public LiurenInfoVo() {
    }

    public String getInputTime() { return inputTime; }
    public void setInputTime(String inputTime) { this.inputTime = inputTime; }

    public String getTrueSolarTime() { return trueSolarTime; }
    public void setTrueSolarTime(String trueSolarTime) { this.trueSolarTime = trueSolarTime; }

    public String getLunar() { return lunar; }
    public void setLunar(String lunar) { this.lunar = lunar; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDayGanZhi() { return dayGanZhi; }
    public void setDayGanZhi(String dayGanZhi) { this.dayGanZhi = dayGanZhi; }

    public String getYueJiang() { return yueJiang; }
    public void setYueJiang(String yueJiang) { this.yueJiang = yueJiang; }

    public String getShi() { return shi; }
    public void setShi(String shi) { this.shi = shi; }

    public Map<String, String> getTianPan() { return tianPan; }
    public void setTianPan(Map<String, String> tianPan) { this.tianPan = tianPan; }

    public Map<String, String> getDiPan() { return diPan; }
    public void setDiPan(Map<String, String> diPan) { this.diPan = diPan; }

    public List<LiurenKeBrief> getSiKe() { return siKe; }
    public void setSiKe(List<LiurenKeBrief> siKe) { this.siKe = siKe; }

    public List<LiurenChuanBrief> getSanChuan() { return sanChuan; }
    public void setSanChuan(List<LiurenChuanBrief> sanChuan) { this.sanChuan = sanChuan; }

    public Map<String, String> getTianJiang() { return tianJiang; }
    public void setTianJiang(Map<String, String> tianJiang) { this.tianJiang = tianJiang; }

}
