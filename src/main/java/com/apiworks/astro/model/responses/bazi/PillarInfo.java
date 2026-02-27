package com.apiworks.astro.model.responses.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class PillarInfo {

    /** 四柱类型。 */
    @JsonProperty("type")
    private String type;

    /** 天干。 */
    @JsonProperty("tg")
    private String tg;

    /** 地支。 */
    @JsonProperty("dz")
    private String dz;

    /** 干神。 */
    @JsonProperty("gan_shen")
    private String ganShen;

    /** 干神简称。 */
    @JsonProperty("gan_shen_short")
    private String ganShenShort;

    /** 支神列表。 */
    @JsonProperty("zhi_shen")
    private List<String> zhiShen;

    /** 支神简称列表。 */
    @JsonProperty("zhi_shen_short")
    private List<String> zhiShenShort;

    /** 藏干五行。 */
    @JsonProperty("cang_gan_wx")
    private List<String> cangGanWx;

    /** 藏干支神。 */
    @JsonProperty("cang_gan_zs")
    private List<String> cangGanZs;

    /** 纳音。 */
    @JsonProperty("na_yin")
    private String naYin;

    /** 空亡。 */
    @JsonProperty("kong_wang")
    private String kongWang;

    /** 地势。 */
    @JsonProperty("di_shi")
    private String diShi;

    /** 自坐。 */
    @JsonProperty("zi_zuo")
    private String ziZuo;

    /** 神煞列表。 */
    @JsonProperty("shen_sha")
    private List<String> shenSha;
}
