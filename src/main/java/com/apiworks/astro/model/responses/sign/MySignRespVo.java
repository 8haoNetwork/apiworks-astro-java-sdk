package com.apiworks.astro.model.responses.sign;

import com.apiworks.astro.model.responses.scope.LuckInfoVo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MySignRespVo {

    /** 隐藏技能。 */
    @JsonProperty("hidden_skill")
    private String hiddenSkill;

    /** 匹配的星座。 */
    @JsonProperty("matched_signs")
    private String matchedSigns;

    /** 幸运信息列表。 */
    @JsonProperty("luck_info")
    private List<LuckInfoVo> luckInfo;

    /** 运势偏好。 */
    @JsonProperty("scope_prefer")
    private String scopePrefer;

    /** 运势避免。 */
    @JsonProperty("scope_avoid")
    private String scopeAvoid;

    /** 运势总结。 */
    @JsonProperty("scope_summary")
    private String scopeSummary;

    /** 行星星座解释列表。 */
    @JsonProperty("sign_explains")
    private List<SignExplainVo> signExplains;
}
