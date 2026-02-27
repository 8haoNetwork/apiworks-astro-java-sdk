package com.apiworks.astro.model.responses.sign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignVo {

    /** 星座 ID。 */
    @JsonProperty("id")
    private int id;

    /** 星座名称。 */
    @JsonProperty("name")
    private String name;

    /** 星座英文名称。 */
    @JsonProperty("en_name")
    private String enName;

    /** 属性。 */
    @JsonProperty("attr")
    private String attr;

    /** 图片 URL。 */
    @JsonProperty("img_url")
    private String imgUrl;

    /** 推荐图片 URL。 */
    @JsonProperty("rec_img_url")
    private String recImgUrl;

    /** 圆形图片 URL。 */
    @JsonProperty("circle_img_url")
    private String circleImgUrl;

    /** 日期范围。 */
    @JsonProperty("date")
    private String date;

    /** 详情信息列表。 */
    @JsonProperty("details")
    private List<SignInfoVo> details;
}
