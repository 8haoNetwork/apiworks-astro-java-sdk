package com.apiworks.astro.model.responses.sanshi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QimenPaiFaVo {

    /** 一行排法摘要 */
    @JsonProperty("digest")
    private String digest;

    /** 起局类型中文 */
    @JsonProperty("qiju_type")
    private String qijuType;

    @JsonProperty("ju_method")
    private String juMethod;

    /** 排盘方式中文 */
    @JsonProperty("pai_method")
    private String paiMethod;

    @JsonProperty("ju_lineage")
    private String juLineage;

    public QimenPaiFaVo() {
    }

    public String getDigest() { return digest; }
    public void setDigest(String digest) { this.digest = digest; }

    public String getQijuType() { return qijuType; }
    public void setQijuType(String qijuType) { this.qijuType = qijuType; }

    public String getJuMethod() { return juMethod; }
    public void setJuMethod(String juMethod) { this.juMethod = juMethod; }

    public String getPaiMethod() { return paiMethod; }
    public void setPaiMethod(String paiMethod) { this.paiMethod = paiMethod; }

    public String getJuLineage() { return juLineage; }
    public void setJuLineage(String juLineage) { this.juLineage = juLineage; }

}
