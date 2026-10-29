package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengLimitYearVo {

    @JsonProperty("age")
    private int age;

    @JsonProperty("year")
    private int year;

    @JsonProperty("gan_zhi")
    private String ganZhi;

    @JsonProperty("xiao_xian")
    private String xiaoXian;

    @JsonProperty("xiao_xian_label")
    private String xiaoXianLabel;

    @JsonProperty("fei_xian")
    private String feiXian;

    @JsonProperty("fei_xian_label")
    private String feiXianLabel;

    @JsonProperty("tong_xian")
    private String tongXian;

    @JsonProperty("tong_xian_label")
    private String tongXianLabel;

    public QizhengLimitYearVo() {
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getGanZhi() { return ganZhi; }
    public void setGanZhi(String ganZhi) { this.ganZhi = ganZhi; }

    public String getXiaoXian() { return xiaoXian; }
    public void setXiaoXian(String xiaoXian) { this.xiaoXian = xiaoXian; }

    public String getXiaoXianLabel() { return xiaoXianLabel; }
    public void setXiaoXianLabel(String xiaoXianLabel) { this.xiaoXianLabel = xiaoXianLabel; }

    public String getFeiXian() { return feiXian; }
    public void setFeiXian(String feiXian) { this.feiXian = feiXian; }

    public String getFeiXianLabel() { return feiXianLabel; }
    public void setFeiXianLabel(String feiXianLabel) { this.feiXianLabel = feiXianLabel; }

    public String getTongXian() { return tongXian; }
    public void setTongXian(String tongXian) { this.tongXian = tongXian; }

    public String getTongXianLabel() { return tongXianLabel; }
    public void setTongXianLabel(String tongXianLabel) { this.tongXianLabel = tongXianLabel; }

}
