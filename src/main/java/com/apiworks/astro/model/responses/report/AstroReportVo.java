package com.apiworks.astro.model.responses.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AstroReportVo {

    /** 报告类型。 */
    @JsonProperty("type")
    private String type;

    /** 报告任务流水号。 */
    @JsonProperty("serial_no")
    private String serialNo;

    /** 查询日期。 */
    @JsonProperty("qry_date")
    private String qryDate;

    /** 报告状态。 */
    @JsonProperty("status")
    private String status;

    /** 报告内容（JSON 或 HTML 片段）。 */
    @JsonProperty("content")
    private String content;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getSerialNo() { return serialNo; }
    public void setSerialNo(String serialNo) { this.serialNo = serialNo; }
    public String getQryDate() { return qryDate; }
    public void setQryDate(String qryDate) { this.qryDate = qryDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
