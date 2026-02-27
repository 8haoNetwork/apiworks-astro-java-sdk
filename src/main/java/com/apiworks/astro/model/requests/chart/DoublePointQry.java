package com.apiworks.astro.model.requests.chart;

import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 双点星盘（行运/比较盘等）。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoublePointQry extends ChartBaseQry {

    /** 两个时间-地点点（出生点/行运点等）。 */
    @JsonProperty("user_list")
    private List<TimeAndLocation> userList;

    public DoublePointQry() {
        super();
    }

    public DoublePointQry(List<TimeAndLocation> userList) {
        this();
        this.userList = userList;
    }

    public List<TimeAndLocation> getUserList() {
        return userList;
    }

    public void setUserList(List<TimeAndLocation> userList) {
        this.userList = userList;
    }
}

