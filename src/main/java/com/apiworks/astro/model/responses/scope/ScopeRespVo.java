package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScopeRespVo {

    /** 总体运势。 */
    @JsonProperty("scope_total")
    private ScopeTotalVo scopeTotal;

    /** 各分项运势。 */
    @JsonProperty("scope_info")
    private List<ScopeInfoVo> scopeInfo;

    /** 幸运信息。 */
    @JsonProperty("luck_info")
    private List<LuckInfoVo> luckInfo;

    /** 星座信息。 */
    @JsonProperty("sign_info")
    private SignScopeVo signInfo;

    /** 总体点评。 */
    @JsonProperty("comment")
    private CommentVo comment;

    /** 运势语料。 */
    @JsonProperty("corpus")
    private List<ScopeInterpretVo> corpus;

    public ScopeTotalVo getScopeTotal() { return scopeTotal; }
    public void setScopeTotal(ScopeTotalVo scopeTotal) { this.scopeTotal = scopeTotal; }
    public List<ScopeInfoVo> getScopeInfo() { return scopeInfo; }
    public void setScopeInfo(List<ScopeInfoVo> scopeInfo) { this.scopeInfo = scopeInfo; }
    public List<LuckInfoVo> getLuckInfo() { return luckInfo; }
    public void setLuckInfo(List<LuckInfoVo> luckInfo) { this.luckInfo = luckInfo; }
    public SignScopeVo getSignInfo() { return signInfo; }
    public void setSignInfo(SignScopeVo signInfo) { this.signInfo = signInfo; }
    public CommentVo getComment() { return comment; }
    public void setComment(CommentVo comment) { this.comment = comment; }
    public List<ScopeInterpretVo> getCorpus() { return corpus; }
    public void setCorpus(List<ScopeInterpretVo> corpus) { this.corpus = corpus; }
}
