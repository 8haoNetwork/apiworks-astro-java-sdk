package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengReadingItemVo {

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("key")
    private String key;

    @JsonProperty("tone")
    private String tone;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("refs")
    private Map<String, String> refs;

    public QizhengReadingItemVo() {
    }

    public String getKind() { return kind; }
    public void setKind(String kind) { this.kind = kind; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getTone() { return tone; }
    public void setTone(String tone) { this.tone = tone; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public Map<String, String> getRefs() { return refs; }
    public void setRefs(Map<String, String> refs) { this.refs = refs; }

}
