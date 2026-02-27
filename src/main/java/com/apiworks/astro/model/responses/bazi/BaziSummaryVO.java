package com.apiworks.astro.model.responses.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaziSummaryVO {

    /** 总体描述。 */
    @JsonProperty("general_desc")
    private String generalDesc;

    /** 五行信息。 */
    @JsonProperty("wx_info")
    private List<WxInfo> wxInfo;

    /** 阴阳属性。 */
    @JsonProperty("yin_yang")
    private String yinYang;

    /** 阴阳属性描述。 */
    @JsonProperty("yin_yang_desc")
    private String yinYangDesc;

    /** 强弱属性。 */
    @JsonProperty("qiang_ruo")
    private String qiangRuo;

    /** 强弱属性描述。 */
    @JsonProperty("qiang_ruo_desc")
    private String qiangRuoDesc;

    /** 格局。 */
    @JsonProperty("ge_ju")
    private String geJu;

    /** 格局描述。 */
    @JsonProperty("ge_ju_desc")
    private String geJuDesc;

    /** 喜用五行。 */
    @JsonProperty("xi_yong_shen")
    private List<String> xiYongShen;

    /** 忌用五行。 */
    @JsonProperty("ji_yong_shen")
    private List<String> jiYongShen;

    /** 幸运信息。 */
    @JsonProperty("lucky_info")
    private Map<String, String> luckyInfo;

    /** 契合伴侣信息。 */
    @JsonProperty("qi_he_partner")
    private String qiHePartner;

    /** 契合伴侣描述。 */
    @JsonProperty("qi_he_partner_desc")
    private String qiHePartnerDesc;

    public String getGeneralDesc() { return generalDesc; }
    public void setGeneralDesc(String generalDesc) { this.generalDesc = generalDesc; }
    public List<WxInfo> getWxInfo() { return wxInfo; }
    public void setWxInfo(List<WxInfo> wxInfo) { this.wxInfo = wxInfo; }
    public String getYinYang() { return yinYang; }
    public void setYinYang(String yinYang) { this.yinYang = yinYang; }
    public String getYinYangDesc() { return yinYangDesc; }
    public void setYinYangDesc(String yinYangDesc) { this.yinYangDesc = yinYangDesc; }
    public String getQiangRuo() { return qiangRuo; }
    public void setQiangRuo(String qiangRuo) { this.qiangRuo = qiangRuo; }
    public String getQiangRuoDesc() { return qiangRuoDesc; }
    public void setQiangRuoDesc(String qiangRuoDesc) { this.qiangRuoDesc = qiangRuoDesc; }
    public String getGeJu() { return geJu; }
    public void setGeJu(String geJu) { this.geJu = geJu; }
    public String getGeJuDesc() { return geJuDesc; }
    public void setGeJuDesc(String geJuDesc) { this.geJuDesc = geJuDesc; }
    public List<String> getXiYongShen() { return xiYongShen; }
    public void setXiYongShen(List<String> xiYongShen) { this.xiYongShen = xiYongShen; }
    public List<String> getJiYongShen() { return jiYongShen; }
    public void setJiYongShen(List<String> jiYongShen) { this.jiYongShen = jiYongShen; }
    public Map<String, String> getLuckyInfo() { return luckyInfo; }
    public void setLuckyInfo(Map<String, String> luckyInfo) { this.luckyInfo = luckyInfo; }
    public String getQiHePartner() { return qiHePartner; }
    public void setQiHePartner(String qiHePartner) { this.qiHePartner = qiHePartner; }
    public String getQiHePartnerDesc() { return qiHePartnerDesc; }
    public void setQiHePartnerDesc(String qiHePartnerDesc) { this.qiHePartnerDesc = qiHePartnerDesc; }
}
