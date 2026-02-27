package com.apiworks.astro.model.requests.report;

import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 报告：合盘。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TogetherCreateQry {

    /** 用户出生点。 */
    @JsonProperty("user_birth_point")
    private TimeAndLocation userBirthPoint;

    /** 对方出生点。 */
    @JsonProperty("other_birth_point")
    private TimeAndLocation otherBirthPoint;

    /** 用户 ID */
    @JsonProperty("user_id")
    private String userId;

    public TimeAndLocation getUserBirthPoint() {
        return userBirthPoint;
    }

    public void setUserBirthPoint(TimeAndLocation userBirthPoint) {
        this.userBirthPoint = userBirthPoint;
    }

    public TimeAndLocation getOtherBirthPoint() {
        return otherBirthPoint;
    }

    public void setOtherBirthPoint(TimeAndLocation otherBirthPoint) {
        this.otherBirthPoint = otherBirthPoint;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

