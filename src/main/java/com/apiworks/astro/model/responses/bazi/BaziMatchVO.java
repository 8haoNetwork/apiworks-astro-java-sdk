package com.apiworks.astro.model.responses.bazi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaziMatchVO {

    /** 你的八字命盘。 */
    @JsonProperty("your_natal")
    private BaziNatalVO yourNatal;

    /** 对方八字命盘。 */
    @JsonProperty("other_natal")
    private BaziNatalVO otherNatal;

    /** 合盘解读。 */
    @JsonProperty("interpretation")
    private String interpretation;

    public BaziNatalVO getYourNatal() { return yourNatal; }
    public void setYourNatal(BaziNatalVO yourNatal) { this.yourNatal = yourNatal; }
    public BaziNatalVO getOtherNatal() { return otherNatal; }
    public void setOtherNatal(BaziNatalVO otherNatal) { this.otherNatal = otherNatal; }
    public String getInterpretation() { return interpretation; }
    public void setInterpretation(String interpretation) { this.interpretation = interpretation; }
}
