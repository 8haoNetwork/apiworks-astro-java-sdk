package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenJieQiItemVo {

    /** 节气名 */
    @JsonProperty("name")
    private String name;

    /** 交节本地时间 */
    @JsonProperty("jiaojie_local")
    private String jiaojieLocal;

    public QimenJieQiItemVo() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getJiaojieLocal() { return jiaojieLocal; }
    public void setJiaojieLocal(String jiaojieLocal) { this.jiaojieLocal = jiaojieLocal; }

}
