package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * 奇门排盘统一响应。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenResultVo {

    @JsonProperty("input_time")
    private String inputTime;

    @JsonProperty("true_solar_time")
    private String trueSolarTime;

    @JsonProperty("lunar")
    private String lunar;

    @JsonProperty("weekday_cn")
    private String weekdayCn;

    @JsonProperty("pai_fa")
    private QimenPaiFaVo paiFa;

    @JsonProperty("type")
    private String type;

    @JsonProperty("ju_method")
    private String juMethod;

    @JsonProperty("pai_method")
    private String paiMethod;

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

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("location")
    private String location;

    @JsonProperty("nian_ming")
    private String nianMing;

    @JsonProperty("liuren_data")
    private Map<String, LiurenInfoVo> liurenData;

    @JsonProperty("year_gan_zhi")
    private String yearGanZhi;

    @JsonProperty("month_gan_zhi")
    private String monthGanZhi;

    @JsonProperty("day_gan_zhi")
    private String dayGanZhi;

    /** shijia_chaibu | rijia_jinhan | shanxiang | … */
    @JsonProperty("pan_variant")
    private String panVariant;

    @JsonProperty("shan_xiang")
    private QimenShanXiangVo shanXiang;

    /** yang | yin */
    @JsonProperty("yin_yang")
    private String yinYang;

    @JsonProperty("ju_display")
    private String juDisplay;

    @JsonProperty("solar_term")
    private String solarTerm;

    @JsonProperty("ding_ju_term")
    private String dingJuTerm;

    @JsonProperty("ju_num")
    private Integer juNum;

    @JsonProperty("yuan")
    private String yuan;

    @JsonProperty("hour_pillar")
    private QimenPillarVo hourPillar;

    @JsonProperty("xun_shou")
    private String xunShou;

    @JsonProperty("zhi_fu")
    private String zhiFu;

    @JsonProperty("zhi_shi")
    private String zhiShi;

    @JsonProperty("tian_yi")
    private String tianYi;

    @JsonProperty("special_patterns")
    private List<QimenSpecialPatternVo> specialPatterns;

    @JsonProperty("jiu_gong")
    private Map<String, JiuGongCellVo> jiuGong;

    @JsonProperty("huang_hei_dao")
    private List<QimenHuangHeiDaoHourVo> huangHeiDao;

    @JsonProperty("shi_gan_zhi")
    private String shiGanZhi;

    public QimenResultVo() {
    }

    public String getInputTime() { return inputTime; }
    public void setInputTime(String inputTime) { this.inputTime = inputTime; }

    public String getTrueSolarTime() { return trueSolarTime; }
    public void setTrueSolarTime(String trueSolarTime) { this.trueSolarTime = trueSolarTime; }

    public String getLunar() { return lunar; }
    public void setLunar(String lunar) { this.lunar = lunar; }

    public String getWeekdayCn() { return weekdayCn; }
    public void setWeekdayCn(String weekdayCn) { this.weekdayCn = weekdayCn; }

    public QimenPaiFaVo getPaiFa() { return paiFa; }
    public void setPaiFa(QimenPaiFaVo paiFa) { this.paiFa = paiFa; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getJuMethod() { return juMethod; }
    public void setJuMethod(String juMethod) { this.juMethod = juMethod; }

    public String getPaiMethod() { return paiMethod; }
    public void setPaiMethod(String paiMethod) { this.paiMethod = paiMethod; }

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

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getNianMing() { return nianMing; }
    public void setNianMing(String nianMing) { this.nianMing = nianMing; }

    public Map<String, LiurenInfoVo> getLiurenData() { return liurenData; }
    public void setLiurenData(Map<String, LiurenInfoVo> liurenData) { this.liurenData = liurenData; }

    public String getYearGanZhi() { return yearGanZhi; }
    public void setYearGanZhi(String yearGanZhi) { this.yearGanZhi = yearGanZhi; }

    public String getMonthGanZhi() { return monthGanZhi; }
    public void setMonthGanZhi(String monthGanZhi) { this.monthGanZhi = monthGanZhi; }

    public String getDayGanZhi() { return dayGanZhi; }
    public void setDayGanZhi(String dayGanZhi) { this.dayGanZhi = dayGanZhi; }

    public String getPanVariant() { return panVariant; }
    public void setPanVariant(String panVariant) { this.panVariant = panVariant; }

    public QimenShanXiangVo getShanXiang() { return shanXiang; }
    public void setShanXiang(QimenShanXiangVo shanXiang) { this.shanXiang = shanXiang; }

    public String getYinYang() { return yinYang; }
    public void setYinYang(String yinYang) { this.yinYang = yinYang; }

    public String getJuDisplay() { return juDisplay; }
    public void setJuDisplay(String juDisplay) { this.juDisplay = juDisplay; }

    public String getSolarTerm() { return solarTerm; }
    public void setSolarTerm(String solarTerm) { this.solarTerm = solarTerm; }

    public String getDingJuTerm() { return dingJuTerm; }
    public void setDingJuTerm(String dingJuTerm) { this.dingJuTerm = dingJuTerm; }

    public Integer getJuNum() { return juNum; }
    public void setJuNum(Integer juNum) { this.juNum = juNum; }

    public String getYuan() { return yuan; }
    public void setYuan(String yuan) { this.yuan = yuan; }

    public QimenPillarVo getHourPillar() { return hourPillar; }
    public void setHourPillar(QimenPillarVo hourPillar) { this.hourPillar = hourPillar; }

    public String getXunShou() { return xunShou; }
    public void setXunShou(String xunShou) { this.xunShou = xunShou; }

    public String getZhiFu() { return zhiFu; }
    public void setZhiFu(String zhiFu) { this.zhiFu = zhiFu; }

    public String getZhiShi() { return zhiShi; }
    public void setZhiShi(String zhiShi) { this.zhiShi = zhiShi; }

    public String getTianYi() { return tianYi; }
    public void setTianYi(String tianYi) { this.tianYi = tianYi; }

    public List<QimenSpecialPatternVo> getSpecialPatterns() { return specialPatterns; }
    public void setSpecialPatterns(List<QimenSpecialPatternVo> specialPatterns) { this.specialPatterns = specialPatterns; }

    public Map<String, JiuGongCellVo> getJiuGong() { return jiuGong; }
    public void setJiuGong(Map<String, JiuGongCellVo> jiuGong) { this.jiuGong = jiuGong; }

    public List<QimenHuangHeiDaoHourVo> getHuangHeiDao() { return huangHeiDao; }
    public void setHuangHeiDao(List<QimenHuangHeiDaoHourVo> huangHeiDao) { this.huangHeiDao = huangHeiDao; }

    public String getShiGanZhi() { return shiGanZhi; }
    public void setShiGanZhi(String shiGanZhi) { this.shiGanZhi = shiGanZhi; }

}
