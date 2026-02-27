package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AstroDataVo {

    /** 星座信息列表。 */
    @JsonProperty("sign")
    private List<ChartSignVo> sign;

    /** 行星信息列表。 */
    @JsonProperty("planet")
    private List<PlanetVo> planet;

    /** 宫位信息列表。 */
    @JsonProperty("house")
    private List<HouseVo> house;

    /** 星座属性统计（火土风水、本位/固定/变动）。 */
    @JsonProperty("attribute")
    private AttributeVo attribute;

    /** 第二参考行星列表（部分盘型会返回）。 */
    @JsonProperty("planet_second")
    private List<PlanetVo> planetSecond;

    /** 语料信息列表（星象解释）。 */
    @JsonProperty("corpus")
    private List<CorpusVo> corpus;

    /** 星盘 SVG 图（有些接口会返回）。 */
    @JsonProperty("svg")
    private String svg;

    /** 法达（Firdaria）相关数据。 */
    @JsonProperty("firdaria")
    private Map<String, Object> firdaria;

    /** 小限盘相关数据。 */
    @JsonProperty("smalllimit")
    private Map<String, Object> smalllimit;

    /** 原始查询参数回显。 */
    @JsonProperty("param")
    private Map<String, Object> param;

    /** 额外扩展数据。 */
    @JsonProperty("extra")
    private Map<String, Object> extra;

    public List<ChartSignVo> getSign() { return sign; }
    public void setSign(List<ChartSignVo> sign) { this.sign = sign; }
    public List<PlanetVo> getPlanet() { return planet; }
    public void setPlanet(List<PlanetVo> planet) { this.planet = planet; }
    public List<HouseVo> getHouse() { return house; }
    public void setHouse(List<HouseVo> house) { this.house = house; }
    public AttributeVo getAttribute() { return attribute; }
    public void setAttribute(AttributeVo attribute) { this.attribute = attribute; }
    public List<PlanetVo> getPlanetSecond() { return planetSecond; }
    public void setPlanetSecond(List<PlanetVo> planetSecond) { this.planetSecond = planetSecond; }
    public List<CorpusVo> getCorpus() { return corpus; }
    public void setCorpus(List<CorpusVo> corpus) { this.corpus = corpus; }
    public String getSvg() { return svg; }
    public void setSvg(String svg) { this.svg = svg; }
    public Map<String, Object> getFirdaria() { return firdaria; }
    public void setFirdaria(Map<String, Object> firdaria) { this.firdaria = firdaria; }
    public Map<String, Object> getSmalllimit() { return smalllimit; }
    public void setSmalllimit(Map<String, Object> smalllimit) { this.smalllimit = smalllimit; }
    public Map<String, Object> getParam() { return param; }
    public void setParam(Map<String, Object> param) { this.param = param; }
    public Map<String, Object> getExtra() { return extra; }
    public void setExtra(Map<String, Object> extra) { this.extra = extra; }
}
