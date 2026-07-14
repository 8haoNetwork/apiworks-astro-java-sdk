package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenShanXiangVo {

    /** 坐山英文 code */
    @JsonProperty("shan_mount")
    private String shanMount;

    /** 向山英文 code */
    @JsonProperty("xiang_mount")
    private String xiangMount;

    /** shang | zhong | xia */
    @JsonProperty("yuan")
    private String yuan;

    /** 上元/中元/下元 */
    @JsonProperty("yuan_label")
    private String yuanLabel;

    /** 用事年 */
    @JsonProperty("event_year")
    private int eventYear;

    /** 等效日柱 */
    @JsonProperty("equivalent_day")
    private String equivalentDay;

    /** 等效时柱 */
    @JsonProperty("equivalent_hour")
    private String equivalentHour;

    public QimenShanXiangVo() {
    }

    public String getShanMount() { return shanMount; }
    public void setShanMount(String shanMount) { this.shanMount = shanMount; }

    public String getXiangMount() { return xiangMount; }
    public void setXiangMount(String xiangMount) { this.xiangMount = xiangMount; }

    public String getYuan() { return yuan; }
    public void setYuan(String yuan) { this.yuan = yuan; }

    public String getYuanLabel() { return yuanLabel; }
    public void setYuanLabel(String yuanLabel) { this.yuanLabel = yuanLabel; }

    public int getEventYear() { return eventYear; }
    public void setEventYear(int eventYear) { this.eventYear = eventYear; }

    public String getEquivalentDay() { return equivalentDay; }
    public void setEquivalentDay(String equivalentDay) { this.equivalentDay = equivalentDay; }

    public String getEquivalentHour() { return equivalentHour; }
    public void setEquivalentHour(String equivalentHour) { this.equivalentHour = equivalentHour; }

}
