package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
class Horoscope {

    /** 四化星映射。 */
    @JsonProperty("mutagen_stars")
    private Map<String, String> mutagenStars;

    /** 宫位列表。 */
    @JsonProperty("palaces")
    private List<HoroscopePalace> palaces;
}
