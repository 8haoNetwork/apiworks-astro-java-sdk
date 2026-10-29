package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengReadingRelationVo {

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("items")
    private List<QizhengReadingItemVo> items;

    public QizhengReadingRelationVo() {
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public List<QizhengReadingItemVo> getItems() { return items; }
    public void setItems(List<QizhengReadingItemVo> items) { this.items = items; }

}
