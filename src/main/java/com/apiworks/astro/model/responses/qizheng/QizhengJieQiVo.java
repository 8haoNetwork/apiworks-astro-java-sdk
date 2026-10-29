package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengJieQiVo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("name_label")
    private String nameLabel;

    @JsonProperty("at")
    private String at;

    public QizhengJieQiVo() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNameLabel() { return nameLabel; }
    public void setNameLabel(String nameLabel) { this.nameLabel = nameLabel; }

    public String getAt() { return at; }
    public void setAt(String at) { this.at = at; }

}
