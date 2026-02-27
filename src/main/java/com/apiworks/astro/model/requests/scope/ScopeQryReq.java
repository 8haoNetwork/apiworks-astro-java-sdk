package com.apiworks.astro.model.requests.scope;

import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 运势相关请求的基础查询参数。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScopeQryReq {

    /** 出生时间和地点。 */
    @JsonProperty("birth_point")
    private TimeAndLocation birthPoint;

    /** 行运时间和地点。 */
    @JsonProperty("transit_point")
    private TimeAndLocation transitPoint;

    public ScopeQryReq() {
    }

    public ScopeQryReq(TimeAndLocation birthPoint, TimeAndLocation transitPoint) {
        this.birthPoint = birthPoint;
        this.transitPoint = transitPoint;
    }

    public TimeAndLocation getBirthPoint() {
        return birthPoint;
    }

    public void setBirthPoint(TimeAndLocation birthPoint) {
        this.birthPoint = birthPoint;
    }

    public TimeAndLocation getTransitPoint() {
        return transitPoint;
    }

    public void setTransitPoint(TimeAndLocation transitPoint) {
        this.transitPoint = transitPoint;
    }
}

