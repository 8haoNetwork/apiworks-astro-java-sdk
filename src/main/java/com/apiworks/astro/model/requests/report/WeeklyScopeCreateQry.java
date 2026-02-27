package com.apiworks.astro.model.requests.report;

import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 报告：周运。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeeklyScopeCreateQry {

    /** 用户出生点。 */
    @JsonProperty("user_birth_point")
    private TimeAndLocation userBirthPoint;

    /** 该周对应的行运时间。 */
    @JsonProperty("transit_dt")
    private String transitDt;

    /** 用户 ID */
    @JsonProperty("user_id")
    private String userId;

    public TimeAndLocation getUserBirthPoint() {
        return userBirthPoint;
    }

    public void setUserBirthPoint(TimeAndLocation userBirthPoint) {
        this.userBirthPoint = userBirthPoint;
    }

    public String getTransitDt() {
        return transitDt;
    }

    public void setTransitDt(String transitDt) {
        this.transitDt = transitDt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

