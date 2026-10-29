package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengSpiritStarCatalogItemVo {

    @JsonProperty("key")
    private String key;

    @JsonProperty("label")
    private String label;

    @JsonProperty("layer")
    private String layer;

    @JsonProperty("scopes")
    private List<String> scopes;

    @JsonProperty("implemented")
    private boolean implemented;

    @JsonProperty("primary")
    private boolean primary;

    @JsonProperty("alias_of")
    private String aliasOf;

    @JsonProperty("default_visible_natal")
    private boolean defaultVisibleNatal;

    @JsonProperty("default_visible_flow")
    private boolean defaultVisibleFlow;

    @JsonProperty("ui_order")
    private int uiOrder;

    public QizhengSpiritStarCatalogItemVo() {
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getLayer() { return layer; }
    public void setLayer(String layer) { this.layer = layer; }

    public List<String> getScopes() { return scopes; }
    public void setScopes(List<String> scopes) { this.scopes = scopes; }

    public boolean isImplemented() { return implemented; }
    public void setImplemented(boolean implemented) { this.implemented = implemented; }

    public boolean isPrimary() { return primary; }
    public void setPrimary(boolean primary) { this.primary = primary; }

    public String getAliasOf() { return aliasOf; }
    public void setAliasOf(String aliasOf) { this.aliasOf = aliasOf; }

    public boolean isDefaultVisibleNatal() { return defaultVisibleNatal; }
    public void setDefaultVisibleNatal(boolean defaultVisibleNatal) { this.defaultVisibleNatal = defaultVisibleNatal; }

    public boolean isDefaultVisibleFlow() { return defaultVisibleFlow; }
    public void setDefaultVisibleFlow(boolean defaultVisibleFlow) { this.defaultVisibleFlow = defaultVisibleFlow; }

    public int getUiOrder() { return uiOrder; }
    public void setUiOrder(int uiOrder) { this.uiOrder = uiOrder; }

}
