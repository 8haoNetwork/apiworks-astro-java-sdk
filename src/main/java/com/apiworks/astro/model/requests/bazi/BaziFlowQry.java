package com.apiworks.astro.model.requests.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 带目标日期的八字流盘请求。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaziFlowQry extends BaziNatalQry {

    /** 目标日期时间。 */
    @JsonProperty("target_dt")
    private String targetDt;

    public String getTargetDt() {
        return targetDt;
    }

    public void setTargetDt(String targetDt) {
        this.targetDt = targetDt;
    }
}

