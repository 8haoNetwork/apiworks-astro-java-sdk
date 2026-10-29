package com.apiworks.astro.model.responses.qizheng;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QizhengAspectVo {

    @JsonProperty("from_star")
    private String fromStar;

    @JsonProperty("to_star")
    private String toStar;

    @JsonProperty("type")
    private String type;

    @JsonProperty("type_label")
    private String typeLabel;

    @JsonProperty("angle")
    private double angle;

    @JsonProperty("orb")
    private double orb;

    public QizhengAspectVo() {
    }

    public String getFromStar() { return fromStar; }
    public void setFromStar(String fromStar) { this.fromStar = fromStar; }

    public String getToStar() { return toStar; }
    public void setToStar(String toStar) { this.toStar = toStar; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTypeLabel() { return typeLabel; }
    public void setTypeLabel(String typeLabel) { this.typeLabel = typeLabel; }

    public double getAngle() { return angle; }
    public void setAngle(double angle) { this.angle = angle; }

    public double getOrb() { return orb; }
    public void setOrb(double orb) { this.orb = orb; }

}
