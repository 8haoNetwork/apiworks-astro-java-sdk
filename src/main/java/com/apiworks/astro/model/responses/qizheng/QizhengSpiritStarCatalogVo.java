package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengSpiritStarCatalogVo {

    @JsonProperty("version")
    private int version;

    @JsonProperty("ui_columns")
    private int uiColumns;

    @JsonProperty("items")
    private List<QizhengSpiritStarCatalogItemVo> items;

    public QizhengSpiritStarCatalogVo() {
    }

    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    public int getUiColumns() { return uiColumns; }
    public void setUiColumns(int uiColumns) { this.uiColumns = uiColumns; }

    public List<QizhengSpiritStarCatalogItemVo> getItems() { return items; }
    public void setItems(List<QizhengSpiritStarCatalogItemVo> items) { this.items = items; }

}
