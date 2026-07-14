package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenPillarVo {

    /** 干支与单位，如丙午年 */
    @JsonProperty("label")
    private String label;

    /** 旬空两地支连写 */
    @JsonProperty("kong_wang")
    private String kongWang;

    public QimenPillarVo() {
    }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getKongWang() { return kongWang; }
    public void setKongWang(String kongWang) { this.kongWang = kongWang; }

}
