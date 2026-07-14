package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenGeJuVo {

    /** 格局名 */
    @JsonProperty("name")
    private String name;

    /** 吉凶层级 key */
    @JsonProperty("level")
    private String level;

    /** 吉凶中文 */
    @JsonProperty("level_cn")
    private String levelCn;

    /** 展示标题 */
    @JsonProperty("title")
    private String title;

    /** 一句话摘要 */
    @JsonProperty("summary")
    private String summary;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("scenarios")
    private List<String> scenarios;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("tian_gan")
    private String tianGan;

    @JsonProperty("di_gan")
    private String diGan;

    @JsonProperty("door_hint")
    private String doorHint;

    /** qiyi | star_door */
    @JsonProperty("pattern_type")
    private String patternType;

    @JsonProperty("shen_xing")
    private String shenXing;

    @JsonProperty("ba_men")
    private String baMen;

    public QimenGeJuVo() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getLevelCn() { return levelCn; }
    public void setLevelCn(String levelCn) { this.levelCn = levelCn; }

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

    public String getTianGan() { return tianGan; }
    public void setTianGan(String tianGan) { this.tianGan = tianGan; }

    public String getDiGan() { return diGan; }
    public void setDiGan(String diGan) { this.diGan = diGan; }

    public String getDoorHint() { return doorHint; }
    public void setDoorHint(String doorHint) { this.doorHint = doorHint; }

    public String getPatternType() { return patternType; }
    public void setPatternType(String patternType) { this.patternType = patternType; }

    public String getShenXing() { return shenXing; }
    public void setShenXing(String shenXing) { this.shenXing = shenXing; }

    public String getBaMen() { return baMen; }
    public void setBaMen(String baMen) { this.baMen = baMen; }

}
