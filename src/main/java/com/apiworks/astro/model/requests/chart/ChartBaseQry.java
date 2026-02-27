package com.apiworks.astro.model.requests.chart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChartBaseQry {

    /** 行星代码列表（body codes）。 */
    @JsonProperty("bodies")
    private List<String> bodies;

    /** 小行星代码列表。 */
    @JsonProperty("asteroids")
    private List<String> asteroids;

    /** 虚拟天体代码列表。 */
    @JsonProperty("virtual_bodies")
    private List<String> virtualBodies;

    /** 黄道类型：tropical | sidereal。 */
    @JsonProperty("zodiac")
    private String zodiac;

    /** 计算方法：modern | classical。 */
    @JsonProperty("calc_method")
    private String calcMethod;

    /** 宫位制，如 P/K/W 等，可为空使用默认。 */
    @JsonProperty("house_system")
    private String houseSystem;

    /** 渲染模式：default | pro | no_display。 */
    @JsonProperty("render_mode")
    private String renderMode;

    /** 是否包含语料。 */
    @JsonProperty("include_corpus")
    private Boolean includeCorpus;

    /** 行星容许度设置。 */
    @JsonProperty("planet_orbs")
    private Map<String, Double> planetOrbs;

    /** 相位容许度设置。 */
    @JsonProperty("aspect_orbs")
    private Map<String, Double> aspectOrbs;

    public ChartBaseQry() {
        this.bodies = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "m");
        this.asteroids = List.of();
        this.virtualBodies = List.of("11");
        this.zodiac = "tropical";
        this.calcMethod = "modern";
        this.renderMode = "default";
        this.includeCorpus = Boolean.TRUE;
        this.planetOrbs = new HashMap<>();
        this.aspectOrbs = new HashMap<>();
    }

    public List<String> getBodies() {
        return bodies;
    }

    public void setBodies(List<String> bodies) {
        this.bodies = bodies;
    }

    public List<String> getAsteroids() {
        return asteroids;
    }

    public void setAsteroids(List<String> asteroids) {
        this.asteroids = asteroids;
    }

    public List<String> getVirtualBodies() {
        return virtualBodies;
    }

    public void setVirtualBodies(List<String> virtualBodies) {
        this.virtualBodies = virtualBodies;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getCalcMethod() {
        return calcMethod;
    }

    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }

    public String getHouseSystem() {
        return houseSystem;
    }

    public void setHouseSystem(String houseSystem) {
        this.houseSystem = houseSystem;
    }

    public String getRenderMode() {
        return renderMode;
    }

    public void setRenderMode(String renderMode) {
        this.renderMode = renderMode;
    }

    public Boolean getIncludeCorpus() {
        return includeCorpus;
    }

    public void setIncludeCorpus(Boolean includeCorpus) {
        this.includeCorpus = includeCorpus;
    }

    public Map<String, Double> getPlanetOrbs() {
        return planetOrbs;
    }

    public void setPlanetOrbs(Map<String, Double> planetOrbs) {
        this.planetOrbs = planetOrbs;
    }

    public Map<String, Double> getAspectOrbs() {
        return aspectOrbs;
    }

    public void setAspectOrbs(Map<String, Double> aspectOrbs) {
        this.aspectOrbs = aspectOrbs;
    }
}

