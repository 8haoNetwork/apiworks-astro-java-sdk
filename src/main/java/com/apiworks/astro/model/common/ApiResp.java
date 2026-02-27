package com.apiworks.astro.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 通用 API 响应包装类。code = 0 表示成功。
 * <p>
 * 对应后端服务返回的统一响应结构：
 * <ul>
 *     <li>code: 状态码，0 表示成功</li>
 *     <li>msg: 提示信息</li>
     *     <li>data: 业务数据载体</li>
 *     <li>exeTime: 执行耗时（秒）</li>
 * </ul>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResp<T> {

    @JsonProperty("code")
    private int code;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("data")
    private T data;

    @JsonProperty("exe_time")
    private double exeTime;

    public ApiResp() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public double getExeTime() {
        return exeTime;
    }

    public void setExeTime(double exeTime) {
        this.exeTime = exeTime;
    }

    @Override
    public String toString() {
        return "ApiResp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", exeTime=" + exeTime +
                '}';
    }
}

