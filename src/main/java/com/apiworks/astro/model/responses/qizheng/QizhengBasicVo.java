package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengBasicVo {

    @JsonProperty("pillars")
    private QizhengPillarsVo pillars;

    @JsonProperty("lunar_date")
    private String lunarDate;

    @JsonProperty("is_day")
    private boolean day;

    @JsonProperty("day_night_label")
    private String dayNightLabel;

    @JsonProperty("jie_qi")
    private List<QizhengJieQiVo> jieQi;

    @JsonProperty("grace")
    private QizhengGraceVo grace;

    @JsonProperty("shen")
    private QizhengShenDegreeVo shen;

    @JsonProperty("tong_xian_span")
    private QizhengTongXianSpanVo tongXianSpan;

    public QizhengBasicVo() {
    }

    public QizhengPillarsVo getPillars() { return pillars; }
    public void setPillars(QizhengPillarsVo pillars) { this.pillars = pillars; }

    public String getLunarDate() { return lunarDate; }
    public void setLunarDate(String lunarDate) { this.lunarDate = lunarDate; }

    public boolean isDay() { return day; }
    public void setDay(boolean day) { this.day = day; }

    public String getDayNightLabel() { return dayNightLabel; }
    public void setDayNightLabel(String dayNightLabel) { this.dayNightLabel = dayNightLabel; }

    public List<QizhengJieQiVo> getJieQi() { return jieQi; }
    public void setJieQi(List<QizhengJieQiVo> jieQi) { this.jieQi = jieQi; }

    public QizhengGraceVo getGrace() { return grace; }
    public void setGrace(QizhengGraceVo grace) { this.grace = grace; }

    public QizhengShenDegreeVo getShen() { return shen; }
    public void setShen(QizhengShenDegreeVo shen) { this.shen = shen; }

    public QizhengTongXianSpanVo getTongXianSpan() { return tongXianSpan; }
    public void setTongXianSpan(QizhengTongXianSpanVo tongXianSpan) { this.tongXianSpan = tongXianSpan; }

}
