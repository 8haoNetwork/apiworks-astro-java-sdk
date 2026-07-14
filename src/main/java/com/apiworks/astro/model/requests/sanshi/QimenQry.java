package com.apiworks.astro.model.requests.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 奇门遁甲排盘请求。
 * <p>
 * type: shijia（时家，默认）| rijia（日家）| shanxiang（山向）
 * pai_method: zhuanpan | feipan
 * ju_method: 时家 chaibu/zhirun/maoshan/yinpan；日家 jinhan/traditional；山向 not_applicable
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenQry extends SanshiCalendarQry {

    /** shijia | rijia | shanxiang */
    @JsonProperty("type")
    private String type = "shijia";

    /** zhuanpan | feipan */
    @JsonProperty("pai_method")
    private String paiMethod = "zhuanpan";

    /** 飞盘子流派（仅 feipan）：zhigui | yinpan | faqiao | mingfa | kuonang */
    @JsonProperty("feipan_style")
    private String feipanStyle = "zhigui";

    /** 定局方法，省略时按 type 默认。 */
    @JsonProperty("ju_method")
    private String juMethod;

    /** 奇门穿壬（附六壬简数据）。 */
    @JsonProperty("with_liuren")
    private Boolean withLiuren = Boolean.FALSE;

    /** 兼容：坐山十二支拼音，如 zi。 */
    @JsonProperty("shan")
    private String shan;

    /** 坐山二十四山英文 code，如 gui。 */
    @JsonProperty("shan_mount")
    private String shanMount;

    /** 三元：shang | zhong | xia。 */
    @JsonProperty("yuan")
    private String yuan;

    /** 天禽寄宫（山向+转盘）：kun2 | gen8 | seasonal。 */
    @JsonProperty("tianqin_ji")
    private String tianqinJi;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getPaiMethod() { return paiMethod; }
    public void setPaiMethod(String paiMethod) { this.paiMethod = paiMethod; }
    public String getFeipanStyle() { return feipanStyle; }
    public void setFeipanStyle(String feipanStyle) { this.feipanStyle = feipanStyle; }
    public String getJuMethod() { return juMethod; }
    public void setJuMethod(String juMethod) { this.juMethod = juMethod; }
    public Boolean getWithLiuren() { return withLiuren; }
    public void setWithLiuren(Boolean withLiuren) { this.withLiuren = withLiuren; }
    public String getShan() { return shan; }
    public void setShan(String shan) { this.shan = shan; }
    public String getShanMount() { return shanMount; }
    public void setShanMount(String shanMount) { this.shanMount = shanMount; }
    public String getYuan() { return yuan; }
    public void setYuan(String yuan) { this.yuan = yuan; }
    public String getTianqinJi() { return tianqinJi; }
    public void setTianqinJi(String tianqinJi) { this.tianqinJi = tianqinJi; }
}
