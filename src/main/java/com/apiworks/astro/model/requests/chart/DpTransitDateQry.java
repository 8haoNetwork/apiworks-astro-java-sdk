package com.apiworks.astro.model.requests.chart;

import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 双点 + 行运日期（组合三限/次限、马科三限/次限、临时三限/次限等）。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DpTransitDateQry extends ChartBaseQry {

    /** 两个时间-地点点。 */
    @JsonProperty("user_list")
    private List<TimeAndLocation> userList;

    /** 行运时间，格式 yyyy-MM-dd HH:mm:ss。 */
    @JsonProperty("transit_dt")
    private String transitDt;

    public DpTransitDateQry() {
        super();
    }

    public DpTransitDateQry(List<TimeAndLocation> userList, String transitDt) {
        this();
        this.userList = userList;
        this.transitDt = transitDt;
    }

    public List<TimeAndLocation> getUserList() {
        return userList;
    }

    public void setUserList(List<TimeAndLocation> userList) {
        this.userList = userList;
    }

    public String getTransitDt() {
        return transitDt;
    }

    public void setTransitDt(String transitDt) {
        this.transitDt = transitDt;
    }
}

