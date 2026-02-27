package com.apiworks.astro.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 时间和地理位置信息，用于构造各种星盘/运势请求。
 * <p>
 * 字段含义与后端 HTTP API 保持一致：
 * <ul>
 *     <li>{@code birthDt}：日期时间字符串，格式 {@code yyyy-MM-dd HH:mm:ss}，例如 {@code 1999-10-17 21:00:00}</li>
 *     <li>{@code tz}：时区偏移（整型小时），例如北京时间为 {@code 8}</li>
 *     <li>{@code longitude}/{@code latitude}：经纬度（十进制度）</li>
 *     <li>{@code dstAuto}：是否自动处理夏令时（中国场景下一般保持 true）</li>
 * </ul>
 * 推荐统一使用同一时区和格式，便于在多端（Web/移动/其他语言 SDK）之间保持一致。
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeAndLocation {

    @JsonProperty("birth_dt")
    private String birthDt;

    @JsonProperty("tz")
    private int tz;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("dst_auto")
    private boolean dstAuto = true;

    public TimeAndLocation() {
    }

    public TimeAndLocation(String birthDt, int tz, double longitude, double latitude) {
        this.birthDt = birthDt;
        this.tz = tz;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dstAuto = true;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public int getTz() {
        return tz;
    }

    public void setTz(int tz) {
        this.tz = tz;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isDstAuto() {
        return dstAuto;
    }

    public void setDstAuto(boolean dstAuto) {
        this.dstAuto = dstAuto;
    }
}

