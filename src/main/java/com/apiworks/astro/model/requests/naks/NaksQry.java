package com.apiworks.astro.model.requests.naks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 星宿关系请求。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaksQry {

    /** 用户本人的出生信息。 */
    @JsonProperty("birth_info")
    private NaksBirthInfo birthInfo;

    /** 其他人的出生信息列表。 */
    @JsonProperty("others_birth_info")
    private List<NaksBirthInfo> othersBirthInfo;

    /** 目标日期时间。 */
    @JsonProperty("target_dt")
    private String targetDt;

    /** 是否使用真太阳时。 */
    @JsonProperty("is_solar_time")
    private boolean solarTime;

    /** 是否按“晚子时”处理。 */
    @JsonProperty("is_late_zi")
    private boolean lateZi;

    /** 牛宿处理方式：nvxiu | douxiu。 */
    @JsonProperty("niu_xiu_handle")
    private String niuXiuHandle = "nvxiu";

    public NaksBirthInfo getBirthInfo() {
        return birthInfo;
    }

    public void setBirthInfo(NaksBirthInfo birthInfo) {
        this.birthInfo = birthInfo;
    }

    public List<NaksBirthInfo> getOthersBirthInfo() {
        return othersBirthInfo;
    }

    public void setOthersBirthInfo(List<NaksBirthInfo> othersBirthInfo) {
        this.othersBirthInfo = othersBirthInfo;
    }

    public String getTargetDt() {
        return targetDt;
    }

    public void setTargetDt(String targetDt) {
        this.targetDt = targetDt;
    }

    public boolean isSolarTime() {
        return solarTime;
    }

    public void setSolarTime(boolean solarTime) {
        this.solarTime = solarTime;
    }

    public boolean isLateZi() {
        return lateZi;
    }

    public void setLateZi(boolean lateZi) {
        this.lateZi = lateZi;
    }

    public String getNiuXiuHandle() {
        return niuXiuHandle;
    }

    public void setNiuXiuHandle(String niuXiuHandle) {
        this.niuXiuHandle = niuXiuHandle;
    }
}

