package com.apiworks.astro.model.responses.scope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignScopeVo {

    /** 星座英文名。 */
    @JsonProperty("sign_name")
    private String signName;

    /** 星座图标 URL。 */
    @JsonProperty("sign_icon")
    private String signIcon;

    public String getSignName() { return signName; }
    public void setSignName(String signName) { this.signName = signName; }
    public String getSignIcon() { return signIcon; }
    public void setSignIcon(String signIcon) { this.signIcon = signIcon; }
}
