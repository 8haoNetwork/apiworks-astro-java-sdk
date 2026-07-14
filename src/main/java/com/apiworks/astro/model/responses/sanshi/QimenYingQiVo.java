package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenYingQiVo {

    /** 后天数 */
    @JsonProperty("houtian")
    private int houtian;

    @JsonProperty("xiantian")
    private Integer xiantian;

    @JsonProperty("wuxing")
    private List<Integer> wuxing;

    @JsonProperty("pool")
    private List<Integer> pool;

    public QimenYingQiVo() {
    }

    public int getHoutian() { return houtian; }
    public void setHoutian(int houtian) { this.houtian = houtian; }

    public Integer getXiantian() { return xiantian; }
    public void setXiantian(Integer xiantian) { this.xiantian = xiantian; }

    public List<Integer> getWuxing() { return wuxing; }
    public void setWuxing(List<Integer> wuxing) { this.wuxing = wuxing; }

    public List<Integer> getPool() { return pool; }
    public void setPool(List<Integer> pool) { this.pool = pool; }

}
