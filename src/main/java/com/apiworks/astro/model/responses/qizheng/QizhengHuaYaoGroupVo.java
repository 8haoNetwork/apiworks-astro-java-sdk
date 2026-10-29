package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengHuaYaoGroupVo {

    @JsonProperty("primary")
    private QizhengHuaYaoItemVo primary;

    @JsonProperty("ten_god")
    private QizhengHuaYaoItemVo tenGod;

    @JsonProperty("tags")
    private List<QizhengHuaYaoItemVo> tags;

    public QizhengHuaYaoGroupVo() {
    }

    public QizhengHuaYaoItemVo getPrimary() { return primary; }
    public void setPrimary(QizhengHuaYaoItemVo primary) { this.primary = primary; }

    public QizhengHuaYaoItemVo getTenGod() { return tenGod; }
    public void setTenGod(QizhengHuaYaoItemVo tenGod) { this.tenGod = tenGod; }

    public List<QizhengHuaYaoItemVo> getTags() { return tags; }
    public void setTags(List<QizhengHuaYaoItemVo> tags) { this.tags = tags; }

}
