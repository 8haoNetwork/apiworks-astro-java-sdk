package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class NatalPalace {

    /** 宫位索引。 */
    @JsonProperty("index")
    private int index;

    /** 宫位名称。 */
    @JsonProperty("name")
    private String name;

    /** 宫位天干。 */
    @JsonProperty("heavenly_stem")
    private String heavenlyStem;

    /** 宫位地支。 */
    @JsonProperty("earthly_branch")
    private String earthlyBranch;

    /** 主星列表。 */
    @JsonProperty("major_stars")
    private List<StarWithMutagen> majorStars;

    /** 副星列表。 */
    @JsonProperty("minor_stars")
    private List<StarWithMutagen> minorStars;

    /** 辅助星列表。 */
    @JsonProperty("adj_stars")
    private List<Star> adjStars;

    /** 长生十二神。 */
    @JsonProperty("life_12_star")
    private String life12Star;

    /** 神煞列表。 */
    @JsonProperty("spirit_stars")
    private List<String> spiritStars;

    /** 宫位起始度数。 */
    @JsonProperty("range_start")
    private Integer rangeStart;

    /** 宫位结束度数。 */
    @JsonProperty("range_end")
    private Integer rangeEnd;

    /** 是否在范围内。 */
    @JsonProperty("in_range")
    private boolean inRange;

    /** 大运信息。 */
    @JsonProperty("decadal")
    private List<Integer> decadal;

    /** 四化星落宫信息列表。 */
    @JsonProperty("mutagen_infos")
    private List<PalaceMutagenItem> mutagenInfos;
}
