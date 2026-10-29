package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengStarVo {

    /** 星曜 key */
    @JsonProperty("key")
    private String key;

    @JsonProperty("label")
    private String label;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("speed")
    private double speed;

    @JsonProperty("palace_degree")
    private double palaceDegree;

    @JsonProperty("xiu_degree")
    private QizhengXiuDegreeVo xiuDegree;

    @JsonProperty("statuses")
    private List<String> statuses;

    @JsonProperty("status_labels")
    private List<String> statusLabels;

    @JsonProperty("dignities")
    private List<String> dignities;

    @JsonProperty("dignity_label")
    private String dignityLabel;

    @JsonProperty("hua_yao")
    private String huaYao;

    @JsonProperty("hua_yao_label")
    private String huaYaoLabel;

    @JsonProperty("ten_god")
    private String tenGod;

    @JsonProperty("ten_god_label")
    private String tenGodLabel;

    @JsonProperty("in_own_xiu")
    private boolean inOwnXiu;

    @JsonProperty("palace_index")
    private int palaceIndex;

    public QizhengStarVo() {
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public double getPalaceDegree() { return palaceDegree; }
    public void setPalaceDegree(double palaceDegree) { this.palaceDegree = palaceDegree; }

    public QizhengXiuDegreeVo getXiuDegree() { return xiuDegree; }
    public void setXiuDegree(QizhengXiuDegreeVo xiuDegree) { this.xiuDegree = xiuDegree; }

    public List<String> getStatuses() { return statuses; }
    public void setStatuses(List<String> statuses) { this.statuses = statuses; }

    public List<String> getStatusLabels() { return statusLabels; }
    public void setStatusLabels(List<String> statusLabels) { this.statusLabels = statusLabels; }

    public List<String> getDignities() { return dignities; }
    public void setDignities(List<String> dignities) { this.dignities = dignities; }

    public String getDignityLabel() { return dignityLabel; }
    public void setDignityLabel(String dignityLabel) { this.dignityLabel = dignityLabel; }

    public String getHuaYao() { return huaYao; }
    public void setHuaYao(String huaYao) { this.huaYao = huaYao; }

    public String getHuaYaoLabel() { return huaYaoLabel; }
    public void setHuaYaoLabel(String huaYaoLabel) { this.huaYaoLabel = huaYaoLabel; }

    public String getTenGod() { return tenGod; }
    public void setTenGod(String tenGod) { this.tenGod = tenGod; }

    public String getTenGodLabel() { return tenGodLabel; }
    public void setTenGodLabel(String tenGodLabel) { this.tenGodLabel = tenGodLabel; }

    public boolean isInOwnXiu() { return inOwnXiu; }
    public void setInOwnXiu(boolean inOwnXiu) { this.inOwnXiu = inOwnXiu; }

    public int getPalaceIndex() { return palaceIndex; }
    public void setPalaceIndex(int palaceIndex) { this.palaceIndex = palaceIndex; }

}
