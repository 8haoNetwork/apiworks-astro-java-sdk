package com.apiworks.astro.model.requests.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 七政四余排盘（本命 + 行运）。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengQry extends QizhengNatalQry {

    /** 行运参照时刻；不传则当天 12:00:00。 */
    @JsonProperty("target_dt")
    private String targetDt;

    public String getTargetDt() { return targetDt; }
    public void setTargetDt(String targetDt) { this.targetDt = targetDt; }
}
