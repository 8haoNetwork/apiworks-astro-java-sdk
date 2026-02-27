package com.apiworks.astro.model.responses.ziwei;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZiweiNatalVo {

    /** 性别。 */
    @JsonProperty("gender")
    private String gender;

    /** 出生日期时间。 */
    @JsonProperty("birth_date")
    private String birthDate;

    /** 真太阳时。 */
    @JsonProperty("solar_date")
    private String solarDate;

    /** 农历日期。 */
    @JsonProperty("lunar_date")
    private String lunarDate;

    /** 农历四柱。 */
    @JsonProperty("lunar_ganzhi")
    private String lunarGanzhi;

    /** 节气四柱。 */
    @JsonProperty("solar_term_ganzhi")
    private String solarTermGanzhi;

    /** 生肖。 */
    @JsonProperty("zodiac")
    private String zodiac;

    /** 五行局。 */
    @JsonProperty("five_elements_class")
    private String fiveElementsClass;

    /** 命宫索引。 */
    @JsonProperty("natal_palace_idx")
    private int natalPalaceIdx;

    /** 身宫索引。 */
    @JsonProperty("body_palace_idx")
    private int bodyPalaceIdx;

    /** 命主。 */
    @JsonProperty("soul_lord")
    private String soulLord;

    /** 身主。 */
    @JsonProperty("body_lord")
    private String bodyLord;

    /** 子年斗君。 */
    @JsonProperty("birth_year_doujun")
    private String birthYearDoujun;

    /** 本命运限数据。 */
    @JsonProperty("natal")
    private NatalHoroscope natal;

    /** 命盘格局列表。 */
    @JsonProperty("patterns")
    private List<Pattern> patterns;

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public String getSolarDate() { return solarDate; }
    public void setSolarDate(String solarDate) { this.solarDate = solarDate; }
    public String getLunarDate() { return lunarDate; }
    public void setLunarDate(String lunarDate) { this.lunarDate = lunarDate; }
    public String getLunarGanzhi() { return lunarGanzhi; }
    public void setLunarGanzhi(String lunarGanzhi) { this.lunarGanzhi = lunarGanzhi; }
    public String getSolarTermGanzhi() { return solarTermGanzhi; }
    public void setSolarTermGanzhi(String solarTermGanzhi) { this.solarTermGanzhi = solarTermGanzhi; }
    public String getZodiac() { return zodiac; }
    public void setZodiac(String zodiac) { this.zodiac = zodiac; }
    public String getFiveElementsClass() { return fiveElementsClass; }
    public void setFiveElementsClass(String fiveElementsClass) { this.fiveElementsClass = fiveElementsClass; }
    public int getNatalPalaceIdx() { return natalPalaceIdx; }
    public void setNatalPalaceIdx(int natalPalaceIdx) { this.natalPalaceIdx = natalPalaceIdx; }
    public int getBodyPalaceIdx() { return bodyPalaceIdx; }
    public void setBodyPalaceIdx(int bodyPalaceIdx) { this.bodyPalaceIdx = bodyPalaceIdx; }
    public String getSoulLord() { return soulLord; }
    public void setSoulLord(String soulLord) { this.soulLord = soulLord; }
    public String getBodyLord() { return bodyLord; }
    public void setBodyLord(String bodyLord) { this.bodyLord = bodyLord; }
    public String getBirthYearDoujun() { return birthYearDoujun; }
    public void setBirthYearDoujun(String birthYearDoujun) { this.birthYearDoujun = birthYearDoujun; }
    public NatalHoroscope getNatal() { return natal; }
    public void setNatal(NatalHoroscope natal) { this.natal = natal; }
    public List<Pattern> getPatterns() { return patterns; }
    public void setPatterns(List<Pattern> patterns) { this.patterns = patterns; }
}
