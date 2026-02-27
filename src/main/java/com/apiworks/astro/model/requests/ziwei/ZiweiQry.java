package com.apiworks.astro.model.requests.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 紫微排盘（含目标日期）请求。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZiweiQry extends ZiweiNatalQry {

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

