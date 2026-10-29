package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengPillarsVo {

    @JsonProperty("year")
    private QizhengPillarVo year;

    @JsonProperty("month")
    private QizhengPillarVo month;

    @JsonProperty("day")
    private QizhengPillarVo day;

    @JsonProperty("hour")
    private QizhengPillarVo hour;

    public QizhengPillarsVo() {
    }

    public QizhengPillarVo getYear() { return year; }
    public void setYear(QizhengPillarVo year) { this.year = year; }

    public QizhengPillarVo getMonth() { return month; }
    public void setMonth(QizhengPillarVo month) { this.month = month; }

    public QizhengPillarVo getDay() { return day; }
    public void setDay(QizhengPillarVo day) { this.day = day; }

    public QizhengPillarVo getHour() { return hour; }
    public void setHour(QizhengPillarVo hour) { this.hour = hour; }

}
