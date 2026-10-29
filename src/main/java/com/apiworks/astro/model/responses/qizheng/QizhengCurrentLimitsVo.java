package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengCurrentLimitsVo {

    @JsonProperty("xiao_xian")
    private String xiaoXian;

    @JsonProperty("xiao_xian_label")
    private String xiaoXianLabel;

    @JsonProperty("yue_xian")
    private String yueXian;

    @JsonProperty("yue_xian_label")
    private String yueXianLabel;

    @JsonProperty("fei_xian")
    private String feiXian;

    @JsonProperty("fei_xian_label")
    private String feiXianLabel;

    @JsonProperty("tong_xian")
    private String tongXian;

    @JsonProperty("tong_xian_label")
    private String tongXianLabel;

    @JsonProperty("da_xian_palace")
    private String daXianPalace;

    @JsonProperty("da_xian_palace_label")
    private String daXianPalaceLabel;

    @JsonProperty("da_xian_start_age")
    private int daXianStartAge;

    @JsonProperty("da_xian_end_age")
    private int daXianEndAge;

    @JsonProperty("chan_ri")
    private String chanRi;

    @JsonProperty("chan_ri_label")
    private String chanRiLabel;

    @JsonProperty("ding_du")
    private QizhengDingDuVo dingDu;

    public QizhengCurrentLimitsVo() {
    }

    public String getXiaoXian() { return xiaoXian; }
    public void setXiaoXian(String xiaoXian) { this.xiaoXian = xiaoXian; }

    public String getXiaoXianLabel() { return xiaoXianLabel; }
    public void setXiaoXianLabel(String xiaoXianLabel) { this.xiaoXianLabel = xiaoXianLabel; }

    public String getYueXian() { return yueXian; }
    public void setYueXian(String yueXian) { this.yueXian = yueXian; }

    public String getYueXianLabel() { return yueXianLabel; }
    public void setYueXianLabel(String yueXianLabel) { this.yueXianLabel = yueXianLabel; }

    public String getFeiXian() { return feiXian; }
    public void setFeiXian(String feiXian) { this.feiXian = feiXian; }

    public String getFeiXianLabel() { return feiXianLabel; }
    public void setFeiXianLabel(String feiXianLabel) { this.feiXianLabel = feiXianLabel; }

    public String getTongXian() { return tongXian; }
    public void setTongXian(String tongXian) { this.tongXian = tongXian; }

    public String getTongXianLabel() { return tongXianLabel; }
    public void setTongXianLabel(String tongXianLabel) { this.tongXianLabel = tongXianLabel; }

    public String getDaXianPalace() { return daXianPalace; }
    public void setDaXianPalace(String daXianPalace) { this.daXianPalace = daXianPalace; }

    public String getDaXianPalaceLabel() { return daXianPalaceLabel; }
    public void setDaXianPalaceLabel(String daXianPalaceLabel) { this.daXianPalaceLabel = daXianPalaceLabel; }

    public int getDaXianStartAge() { return daXianStartAge; }
    public void setDaXianStartAge(int daXianStartAge) { this.daXianStartAge = daXianStartAge; }

    public int getDaXianEndAge() { return daXianEndAge; }
    public void setDaXianEndAge(int daXianEndAge) { this.daXianEndAge = daXianEndAge; }

    public String getChanRi() { return chanRi; }
    public void setChanRi(String chanRi) { this.chanRi = chanRi; }

    public String getChanRiLabel() { return chanRiLabel; }
    public void setChanRiLabel(String chanRiLabel) { this.chanRiLabel = chanRiLabel; }

    public QizhengDingDuVo getDingDu() { return dingDu; }
    public void setDingDu(QizhengDingDuVo dingDu) { this.dingDu = dingDu; }

}
