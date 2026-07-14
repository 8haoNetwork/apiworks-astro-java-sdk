package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 大六壬 / 金口诀排盘完整结果。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenResultVo {

    @JsonProperty("input_time")
    private String inputTime;

    @JsonProperty("true_solar_time")
    private String trueSolarTime;

    @JsonProperty("lunar")
    private String lunar;

    @JsonProperty("weekday_cn")
    private String weekdayCn;

    @JsonProperty("type")
    private String type;

    @JsonProperty("gui_method")
    private String guiMethod;

    @JsonProperty("di_fen")
    private String diFen;

    @JsonProperty("solar_term")
    private String solarTerm;

    @JsonProperty("jie_qi_prev")
    private QimenJieQiItemVo jieQiPrev;

    @JsonProperty("jie_qi_next")
    private QimenJieQiItemVo jieQiNext;

    @JsonProperty("year_pillar")
    private QimenPillarVo yearPillar;

    @JsonProperty("month_pillar")
    private QimenPillarVo monthPillar;

    @JsonProperty("day_pillar")
    private QimenPillarVo dayPillar;

    @JsonProperty("hour_pillar")
    private QimenPillarVo hourPillar;

    @JsonProperty("year_gan_zhi")
    private String yearGanZhi;

    @JsonProperty("month_gan_zhi")
    private String monthGanZhi;

    @JsonProperty("day_gan_zhi")
    private String dayGanZhi;

    @JsonProperty("shi_gan_zhi")
    private String shiGanZhi;

    @JsonProperty("yue_jiang")
    private String yueJiang;

    @JsonProperty("yue_jiang_name")
    private String yueJiangName;

    @JsonProperty("shi")
    private String shi;

    @JsonProperty("ge_ju")
    private List<String> geJu;

    @JsonProperty("ge_ju_detail")
    private List<LiurenGeJuItemVo> geJuDetail;

    @JsonProperty("ri_ma")
    private String riMa;

    @JsonProperty("tian_pan")
    private Map<String, String> tianPan;

    @JsonProperty("di_pan")
    private Map<String, String> diPan;

    @JsonProperty("tian_jiang")
    private Map<String, String> tianJiang;

    @JsonProperty("tian_jiang_on_earth")
    private Map<String, String> tianJiangOnEarth;

    @JsonProperty("palace_notes")
    private Map<String, LiurenPalaceNoteVo> palaceNotes;

    @JsonProperty("si_ke")
    private List<LiurenKeVo> siKe;

    @JsonProperty("san_chuan")
    private List<LiurenChuanVo> sanChuan;

    public LiurenResultVo() {
    }

    public String getInputTime() { return inputTime; }
    public void setInputTime(String inputTime) { this.inputTime = inputTime; }

    public String getTrueSolarTime() { return trueSolarTime; }
    public void setTrueSolarTime(String trueSolarTime) { this.trueSolarTime = trueSolarTime; }

    public String getLunar() { return lunar; }
    public void setLunar(String lunar) { this.lunar = lunar; }

    public String getWeekdayCn() { return weekdayCn; }
    public void setWeekdayCn(String weekdayCn) { this.weekdayCn = weekdayCn; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getGuiMethod() { return guiMethod; }
    public void setGuiMethod(String guiMethod) { this.guiMethod = guiMethod; }

    public String getDiFen() { return diFen; }
    public void setDiFen(String diFen) { this.diFen = diFen; }

    public String getSolarTerm() { return solarTerm; }
    public void setSolarTerm(String solarTerm) { this.solarTerm = solarTerm; }

    public QimenJieQiItemVo getJieQiPrev() { return jieQiPrev; }
    public void setJieQiPrev(QimenJieQiItemVo jieQiPrev) { this.jieQiPrev = jieQiPrev; }

    public QimenJieQiItemVo getJieQiNext() { return jieQiNext; }
    public void setJieQiNext(QimenJieQiItemVo jieQiNext) { this.jieQiNext = jieQiNext; }

    public QimenPillarVo getYearPillar() { return yearPillar; }
    public void setYearPillar(QimenPillarVo yearPillar) { this.yearPillar = yearPillar; }

    public QimenPillarVo getMonthPillar() { return monthPillar; }
    public void setMonthPillar(QimenPillarVo monthPillar) { this.monthPillar = monthPillar; }

    public QimenPillarVo getDayPillar() { return dayPillar; }
    public void setDayPillar(QimenPillarVo dayPillar) { this.dayPillar = dayPillar; }

    public QimenPillarVo getHourPillar() { return hourPillar; }
    public void setHourPillar(QimenPillarVo hourPillar) { this.hourPillar = hourPillar; }

    public String getYearGanZhi() { return yearGanZhi; }
    public void setYearGanZhi(String yearGanZhi) { this.yearGanZhi = yearGanZhi; }

    public String getMonthGanZhi() { return monthGanZhi; }
    public void setMonthGanZhi(String monthGanZhi) { this.monthGanZhi = monthGanZhi; }

    public String getDayGanZhi() { return dayGanZhi; }
    public void setDayGanZhi(String dayGanZhi) { this.dayGanZhi = dayGanZhi; }

    public String getShiGanZhi() { return shiGanZhi; }
    public void setShiGanZhi(String shiGanZhi) { this.shiGanZhi = shiGanZhi; }

    public String getYueJiang() { return yueJiang; }
    public void setYueJiang(String yueJiang) { this.yueJiang = yueJiang; }

    public String getYueJiangName() { return yueJiangName; }
    public void setYueJiangName(String yueJiangName) { this.yueJiangName = yueJiangName; }

    public String getShi() { return shi; }
    public void setShi(String shi) { this.shi = shi; }

    public List<String> getGeJu() { return geJu; }
    public void setGeJu(List<String> geJu) { this.geJu = geJu; }

    public List<LiurenGeJuItemVo> getGeJuDetail() { return geJuDetail; }
    public void setGeJuDetail(List<LiurenGeJuItemVo> geJuDetail) { this.geJuDetail = geJuDetail; }

    public String getRiMa() { return riMa; }
    public void setRiMa(String riMa) { this.riMa = riMa; }

    public Map<String, String> getTianPan() { return tianPan; }
    public void setTianPan(Map<String, String> tianPan) { this.tianPan = tianPan; }

    public Map<String, String> getDiPan() { return diPan; }
    public void setDiPan(Map<String, String> diPan) { this.diPan = diPan; }

    public Map<String, String> getTianJiang() { return tianJiang; }
    public void setTianJiang(Map<String, String> tianJiang) { this.tianJiang = tianJiang; }

    public Map<String, String> getTianJiangOnEarth() { return tianJiangOnEarth; }
    public void setTianJiangOnEarth(Map<String, String> tianJiangOnEarth) { this.tianJiangOnEarth = tianJiangOnEarth; }

    public Map<String, LiurenPalaceNoteVo> getPalaceNotes() { return palaceNotes; }
    public void setPalaceNotes(Map<String, LiurenPalaceNoteVo> palaceNotes) { this.palaceNotes = palaceNotes; }

    public List<LiurenKeVo> getSiKe() { return siKe; }
    public void setSiKe(List<LiurenKeVo> siKe) { this.siKe = siKe; }

    public List<LiurenChuanVo> getSanChuan() { return sanChuan; }
    public void setSanChuan(List<LiurenChuanVo> sanChuan) { this.sanChuan = sanChuan; }

}
