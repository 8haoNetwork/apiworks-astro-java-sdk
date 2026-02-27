package com.apiworks.astro.model.responses.sign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class SignExplainVo {

    /** 标签。 */
    @JsonProperty("label")
    private String label;

    /** 行星中文名。 */
    @JsonProperty("pl")
    private String pl;

    /** 星座中文名。 */
    @JsonProperty("sign")
    private String sign;

    /** 标签类型。 */
    @JsonProperty("tag")
    private String tag;

    /** 标签图片 URL。 */
    @JsonProperty("tag_img")
    private String tagImg;

    /** 详细描述。 */
    @JsonProperty("summary")
    private Object summary;
}
