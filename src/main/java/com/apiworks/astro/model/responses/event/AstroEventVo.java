package com.apiworks.astro.model.responses.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AstroEventVo {

    /** 星盘类型。 */
    @JsonProperty("chart_type")
    private String chartType;

    /** 星象类型。 */
    @JsonProperty("asp_type")
    private String aspType;

    /** 源星体。 */
    @JsonProperty("from_obj")
    private String fromObj;

    /** 目标星体。 */
    @JsonProperty("to_obj")
    private String toObj;

    /** 星象事件类型（In/Out）。 */
    @JsonProperty("event_type")
    private String eventType;

    /** 发生时间字符串。 */
    @JsonProperty("occurred_at")
    private String occurredAt;
}
