package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiurenInterpretVo {

    @JsonProperty("category")
    private String category;

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("scenarios")
    private List<String> scenarios;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("level")
    private String level;

    @JsonProperty("level_cn")
    private String levelCn;

    @JsonProperty("meta_lines")
    private List<String> metaLines;

    public LiurenInterpretVo() {
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public List<String> getScenarios() { return scenarios; }
    public void setScenarios(List<String> scenarios) { this.scenarios = scenarios; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getLevelCn() { return levelCn; }
    public void setLevelCn(String levelCn) { this.levelCn = levelCn; }

    public List<String> getMetaLines() { return metaLines; }
    public void setMetaLines(List<String> metaLines) { this.metaLines = metaLines; }

}
