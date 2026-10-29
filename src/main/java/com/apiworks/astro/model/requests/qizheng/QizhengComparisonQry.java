package com.apiworks.astro.model.requests.qizheng;

import com.apiworks.astro.model.common.LangConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 七政四余比较盘；user_list 长度必须为 2：[0]=A，[1]=B。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengComparisonQry {

    /** 语言：zh-Hans | zh-Hant，默认 zh-Hans。 */
    @JsonProperty("lang")
    private String lang = LangConstants.DEFAULT_LANG;

    @JsonProperty("user_list")
    private List<QizhengPersonQry> userList;

    /** tropical | sidereal */
    @JsonProperty("zodiac")
    private String zodiac = "tropical";

    /** modern | ancient */
    @JsonProperty("xiu_ruler")
    private String xiuRuler = "modern";

    public QizhengComparisonQry() {
    }

    public QizhengComparisonQry(List<QizhengPersonQry> userList) {
        this.userList = userList;
    }

    public String getLang() { return lang; }
    public void setLang(String lang) { this.lang = lang; }
    public List<QizhengPersonQry> getUserList() { return userList; }
    public void setUserList(List<QizhengPersonQry> userList) { this.userList = userList; }
    public String getZodiac() { return zodiac; }
    public void setZodiac(String zodiac) { this.zodiac = zodiac; }
    public String getXiuRuler() { return xiuRuler; }
    public void setXiuRuler(String xiuRuler) { this.xiuRuler = xiuRuler; }
}
