package com.apiworks.astro.model.common;

/**
 * 多语言相关常量。请求体 / 查询参数 {@code lang} 支持：
 * {@code zh-Hans}（简体，默认）、{@code zh-Hant}（繁体）、{@code en}（部分接口）。
 */
public final class LangConstants {

    /** 默认语言：简体中文。 */
    public static final String DEFAULT_LANG = "zh-Hans";

    private LangConstants() {
    }
}
