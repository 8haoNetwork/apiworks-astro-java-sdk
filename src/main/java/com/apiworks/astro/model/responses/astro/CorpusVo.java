package com.apiworks.astro.model.responses.astro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CorpusVo {

    /** 星盘类型。 */
    @JsonProperty("chartType")
    private String chartType;

    /** 主体对象中文名。 */
    @JsonProperty("from_cn")
    private String fromCn;

    /** 客体对象中文名。 */
    @JsonProperty("to_cn")
    private String toCn;

    /** 主体对象英文名。 */
    @JsonProperty("from_en")
    private String fromEn;

    /** 客体对象英文名。 */
    @JsonProperty("to_en")
    private String toEn;

    /** 主体对象本地化名称（随 lang）。 */
    @JsonProperty("from_name")
    private String fromName = "";

    /** 客体对象本地化名称（随 lang）。 */
    @JsonProperty("to_name")
    private String toName = "";

    /** 语料类型。 */
    @JsonProperty("type")
    private String type;

    /** 相位角度。 */
    @JsonProperty("asp_angle")
    private Integer aspAngle;

    /** 星象发生时间戳（秒）。 */
    @JsonProperty("occurred_at_ts")
    private Long occurredAtTs;

    /** 入相/出相标记。 */
    @JsonProperty("in_out")
    private String inOut;

    /** 距离开始还有多少天。 */
    @JsonProperty("start_days")
    private Integer startDays;

    /** 开始时间描述。 */
    @JsonProperty("start_days_desc")
    private String startDaysDesc;

    /** 剩余天数。 */
    @JsonProperty("remain_days")
    private Integer remainDays;

    /** 剩余时间描述。 */
    @JsonProperty("remain_days_desc")
    private String remainDaysDesc;

    /** 吉凶类型。 */
    @JsonProperty("jx_type")
    private String jxType;

    /** 提示信息。 */
    @JsonProperty("tip")
    private String tip;

    /** 星象标题。 */
    @JsonProperty("title")
    private String title;

    /** 语料内容。 */
    @JsonProperty("content")
    private String content;
}
