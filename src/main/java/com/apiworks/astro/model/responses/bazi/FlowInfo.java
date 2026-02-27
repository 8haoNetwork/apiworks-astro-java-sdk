package com.apiworks.astro.model.responses.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class FlowInfo {

    /** 四柱类型。 */
    @JsonProperty("type")
    private String type;

    /** 流盘关键字。 */
    @JsonProperty("key")
    private String key;

    /** 流盘子关键字。 */
    @JsonProperty("sub_key")
    private String subKey;

    /** 天干。 */
    @JsonProperty("tg")
    private String tg;

    /** 天干神煞。 */
    @JsonProperty("tg_shen_sha")
    private String tgShenSha;

    /** 地支。 */
    @JsonProperty("dz")
    private String dz;

    /** 地支神煞。 */
    @JsonProperty("dz_shen_sha")
    private String dzShenSha;

    /** 是否为当前时段。 */
    @JsonProperty("is_current")
    private boolean current;
}
