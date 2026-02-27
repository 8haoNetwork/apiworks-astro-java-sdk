package com.apiworks.astro.model.responses.sign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignCompatVo {

    /** 主星座名称。 */
    @JsonProperty("from_sign_name")
    private String fromSignName;

    /** 主星座图片 URL。 */
    @JsonProperty("from_img_url")
    private String fromImgUrl;

    /** 目标星座名称。 */
    @JsonProperty("to_sign_name")
    private String toSignName;

    /** 目标星座图片 URL。 */
    @JsonProperty("to_img_url")
    private String toImgUrl;

    /** 配对得分。 */
    @JsonProperty("score")
    private int score;

    /** 总体评语。 */
    @JsonProperty("comment")
    private String comment;

    /** 男-女描述。 */
    @JsonProperty("male_desc")
    private String maleDesc;

    /** 女-男描述。 */
    @JsonProperty("female_desc")
    private String femaleDesc;
}
