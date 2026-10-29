package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengReadingVo {

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("highlights")
    private List<QizhengReadingItemVo> highlights;

    @JsonProperty("timing")
    private QizhengReadingTimingVo timing;

    @JsonProperty("relation")
    private QizhengReadingRelationVo relation;

    public QizhengReadingVo() {
    }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public List<QizhengReadingItemVo> getHighlights() { return highlights; }
    public void setHighlights(List<QizhengReadingItemVo> highlights) { this.highlights = highlights; }

    public QizhengReadingTimingVo getTiming() { return timing; }
    public void setTiming(QizhengReadingTimingVo timing) { this.timing = timing; }

    public QizhengReadingRelationVo getRelation() { return relation; }
    public void setRelation(QizhengReadingRelationVo relation) { this.relation = relation; }

}
