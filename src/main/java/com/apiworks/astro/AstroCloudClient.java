package com.apiworks.astro;

import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.requests.bazi.BaziFlowQry;
import com.apiworks.astro.model.requests.bazi.BaziMatchQry;
import com.apiworks.astro.model.requests.bazi.BaziNatalQry;
import com.apiworks.astro.model.requests.naks.NaksQry;
import com.apiworks.astro.model.requests.report.RomanticCreateQry;
import com.apiworks.astro.model.requests.report.TogetherCreateQry;
import com.apiworks.astro.model.requests.report.WealthCreateQry;
import com.apiworks.astro.model.requests.report.WeeklyScopeCreateQry;
import com.apiworks.astro.model.requests.report.YearlyScopeCreateQry;
import com.apiworks.astro.model.requests.qizheng.QizhengComparisonQry;
import com.apiworks.astro.model.requests.qizheng.QizhengNatalQry;
import com.apiworks.astro.model.requests.qizheng.QizhengQry;
import com.apiworks.astro.model.requests.sanshi.LiurenQry;
import com.apiworks.astro.model.requests.sanshi.QimenQry;
import com.apiworks.astro.model.requests.scope.ScopeQryReq;
import com.apiworks.astro.model.requests.sign.SignQry;
import com.apiworks.astro.model.requests.ziwei.ZiweiNatalQry;
import com.apiworks.astro.model.requests.ziwei.ZiweiQry;
import com.apiworks.astro.model.requests.chart.DoublePointQry;
import com.apiworks.astro.model.requests.chart.DpTransitDateQry;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.requests.chart.SpTransitDateQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;
import com.apiworks.astro.model.responses.bazi.BaziFlowVO;
import com.apiworks.astro.model.responses.bazi.BaziMatchVO;
import com.apiworks.astro.model.responses.bazi.BaziNatalVO;
import com.apiworks.astro.model.responses.bazi.BaziSummaryVO;
import com.apiworks.astro.model.responses.event.AstroEventVo;
import com.apiworks.astro.model.responses.naks.NaksVo;
import com.apiworks.astro.model.responses.report.AstroReportVo;
import com.apiworks.astro.model.responses.qizheng.QizhengChartVo;
import com.apiworks.astro.model.responses.qizheng.QizhengComparisonVo;
import com.apiworks.astro.model.responses.qizheng.QizhengNatalVo;
import com.apiworks.astro.model.responses.qizheng.QizhengSpiritStarCatalogVo;
import com.apiworks.astro.model.responses.sanshi.LiurenResultVo;
import com.apiworks.astro.model.responses.sanshi.QimenResultVo;
import com.apiworks.astro.model.responses.scope.ScopeRespVo;
import com.apiworks.astro.model.responses.sign.MySignRespVo;
import com.apiworks.astro.model.responses.sign.SignCompatVo;
import com.apiworks.astro.model.responses.sign.SignVo;
import com.apiworks.astro.model.responses.ziwei.ZiweiChartVo;
import com.apiworks.astro.model.responses.ziwei.ZiweiDetailVo;
import com.apiworks.astro.model.responses.ziwei.ZiweiNatalVo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Java 版 ApiWorks 星盘 API 客户端（同步）。
 * <p>
 * 封装了星盘服务的所有 HTTP 接口：
 * <ul>
 *     <li>所有请求都会携带头部 {@code X-App-Id}、{@code X-App-Key}</li>
 *     <li>基础网关默认为 {@link #DEFAULT_BASE_URL}</li>
 *     <li>所有方法返回 {@code ApiResp<T>}，其中 {@code code=0} 表示成功</li>
 * </ul>
 * 主要能力：
 * <ul>
 *     <li>chart：全部 {@code /chart/*} 端点，如本命盘、行运盘、三限、次限等</li>
 *     <li>sign：{@code /mySign}、{@code /signs}、{@code /signs/{id}}、{@code /signs/{id}/compat}</li>
 *     <li>scope：日/周/月/年运势 {@code /scope/day|week|month|year}</li>
 *     <li>event：行运事件 {@code /event/transit}</li>
 *     <li>bazi：八字命盘/流盘/合盘/总结 {@code /bazi/natal|flow|match|summary}</li>
 *     <li>ziwei：紫微命盘/运限/解读 {@code /ziwei/natal|chart|detail}</li>
 *     <li>naks：星宿关系 {@code /naks/relations}</li>
 *     <li>sanshi：奇门遁甲 {@code /qimen}、大六壬/金口诀 {@code /liuren}</li>
 *     <li>zhengyu：七政四余 {@code /zhengyu/natal|chart|comparison|spirit-stars/catalog}</li>
 *     <li>report：桃花/周运/年运/合盘/财运报告 {@code /report/*}</li>
 *     <li>多语言：请求体或查询参数 {@code lang}（{@code zh-Hans}/{@code zh-Hant}/{@code en}）</li>
 * </ul>
 * 需要的请求/响应模型可在 {@code com.apiworks.astro.model.requests.*}、
 * {@code com.apiworks.astro.model.responses.*} 包中按需扩展。
 * <p>
 * 使用完毕后可调用 {@link #close()} 关闭内部线程池，避免进程退出时出现线程未结束的 warning
 * （例如通过 {@code mvn exec:java} 运行示例时）。长期运行的应用可复用同一客户端，不必每次关闭。
 */
public class AstroCloudClient implements AutoCloseable {

    public static final String DEFAULT_BASE_URL = "https://cloud.apiworks.com/open/astro";

    private final String appId;
    private final String appKey;
    private final String baseUrl;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public AstroCloudClient(String appId, String appKey) {
        this(appId, appKey, DEFAULT_BASE_URL, 30_000);
    }

    public AstroCloudClient(String appId, String appKey, String baseUrl, long timeoutMillis) {
        this.appId = appId;
        this.appKey = appKey;
        this.baseUrl = trimTrailingSlash(baseUrl);
        this.httpClient = new OkHttpClient.Builder()
                .callTimeout(Duration.ofMillis(timeoutMillis))
                .build();
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private String trimTrailingSlash(String url) {
        if (url == null) {
            return DEFAULT_BASE_URL;
        }
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }

    private static String withLangQuery(String path, String lang) {
        if (lang == null || lang.isEmpty()) {
            return path;
        }
        String separator = path.contains("?") ? "&" : "?";
        return path + separator + "lang=" + lang;
    }

    /**
     * 关闭客户端占用的线程池与连接池，避免进程退出时 OkHttp 线程未结束的 warning。
     * 调用后本客户端不可再使用。
     */
    @Override
    public void close() {
        httpClient.connectionPool().evictAll();
        var executor = httpClient.dispatcher().executorService();
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                executor.awaitTermination(1, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private Request.Builder baseRequest(String path) {
        return new Request.Builder()
                .url(baseUrl + path)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-App-Id", appId)
                .addHeader("X-App-Key", appKey);
    }

    private <T> ApiResp<T> executeJson(String method,
                                       String path,
                                       Object body,
                                       TypeReference<ApiResp<T>> typeRef) throws IOException {
        RequestBody requestBody = null;
        if (body != null) {
            String json = objectMapper.writeValueAsString(body);
            requestBody = RequestBody.create(json, JSON);
        }
        Request.Builder builder = baseRequest(path);
        switch (method) {
            case "GET":
                builder.get();
                break;
            case "POST":
                builder.post(requestBody != null ? requestBody : RequestBody.create(new byte[0], JSON));
                break;
            default:
                throw new IllegalArgumentException("Unsupported method: " + method);
        }

        try (Response resp = httpClient.newCall(builder.build()).execute()) {
            String respBody = resp.body() != null ? resp.body().string() : "";
            if (!resp.isSuccessful()) {
                String detail = respBody.isEmpty() ? "" : "; body: " + (respBody.length() > 512 ? respBody.substring(0, 512) + "..." : respBody);
                throw new IOException("HTTP " + resp.code() + " for " + path + detail);
            }
            if (respBody.isEmpty()) {
                throw new IOException("Empty response body for " + path);
            }
            return objectMapper.readValue(respBody, typeRef);
        }
    }

    // ----- Chart: single point -----

    /**
     * POST {@code /chart/natal} - 本命盘。
     *
     * @param qry 单点星盘查询参数（出生时间 + 地理位置等）
     * @return 本命盘数据封装在 {@code ApiResp<AstroDataVo>} 中
     * @throws IOException 网络或反序列化异常
     */
    public ApiResp<AstroDataVo> chartNatal(SinglePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/natal",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/current} - 当前天象盘。
     * 用于计算当前时间/地点的行星位置。
     */
    public ApiResp<AstroDataVo> chartCurrent(SinglePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/current",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    // ----- Chart: double point -----

    /**
     * POST {@code /chart/transit} - 行运盘。
     * 使用出生点 + 行运点两组时间地点。
     */
    public ApiResp<AstroDataVo> chartTransit(DoublePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/transit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/comparison} - 比较盘。
     */
    public ApiResp<AstroDataVo> chartComparison(DoublePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/comparison",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/composite} - 组合盘。
     */
    public ApiResp<AstroDataVo> chartComposite(DoublePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/composite",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/timesMidPoint} - 中点盘。
     */
    public ApiResp<AstroDataVo> chartTimesMidPoint(DoublePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/timesMidPoint",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/marks} - Marks（马科）盘。
     */
    public ApiResp<AstroDataVo> chartMarks(DoublePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/marks",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/lunarReturn} - 月回归盘。
     */
    public ApiResp<AstroDataVo> chartLunarReturn(DoublePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/lunarReturn",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/solarReturn} - 日回归盘（太阳回归）。
     */
    public ApiResp<AstroDataVo> chartSolarReturn(DoublePointQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/solarReturn",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    // ----- Chart: single point + transit date -----

    /**
     * POST {@code /chart/tripleLimit} - 三限盘。
     * 单点 + 行运日期。
     */
    public ApiResp<AstroDataVo> chartTripleLimit(SpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/tripleLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/secondaryLimit} - 次限盘（Secondary progression）。
     */
    public ApiResp<AstroDataVo> chartSecondaryLimit(SpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/secondaryLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/firdaria} - 法达盘（Firdaria）。
     */
    public ApiResp<AstroDataVo> chartFirdaria(SpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/firdaria",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/smallLimit} - 小限盘。
     */
    public ApiResp<AstroDataVo> chartSmallLimit(SpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/smallLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/solarArc} - 日弧盘（Solar arc）。
     */
    public ApiResp<AstroDataVo> chartSolarArc(SpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/solarArc",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    // ----- Chart: double point + transit date -----

    /**
     * POST {@code /chart/composeTripleLimit} - 组合三限盘。
     */
    public ApiResp<AstroDataVo> chartComposeTripleLimit(DpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/composeTripleLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/composeSecLimit} - 组合次限盘。
     */
    public ApiResp<AstroDataVo> chartComposeSecLimit(DpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/composeSecLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/marksTripleLimit} - 马科三限盘。
     */
    public ApiResp<AstroDataVo> chartMarksTripleLimit(DpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/marksTripleLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/marksSecLimit} - 马科次限盘。
     */
    public ApiResp<AstroDataVo> chartMarksSecLimit(DpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/marksSecLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/tmpTripleLimit} - 临时三限盘。
     */
    public ApiResp<AstroDataVo> chartTmpTripleLimit(DpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/tmpTripleLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    /**
     * POST {@code /chart/tmpSecLimit} - 临时次限盘。
     */
    public ApiResp<AstroDataVo> chartTmpSecLimit(DpTransitDateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/chart/tmpSecLimit",
                qry,
                new TypeReference<ApiResp<AstroDataVo>>() {
                }
        );
    }

    // ----- Scope -----

    /**
     * POST {@code /scope/day/{uid}} - 日运势。
     *
     * @param uid 业务方用户 ID（用于个性化缓存与透传）
     */
    public ApiResp<ScopeRespVo> scopeDay(String uid, ScopeQryReq qry) throws IOException {
        return executeJson(
                "POST",
                "/scope/day/" + uid,
                qry,
                new TypeReference<ApiResp<ScopeRespVo>>() {
                }
        );
    }

    /**
     * POST {@code /scope/week/{uid}} - 周运势。
     */
    public ApiResp<ScopeRespVo> scopeWeek(String uid, ScopeQryReq qry) throws IOException {
        return executeJson(
                "POST",
                "/scope/week/" + uid,
                qry,
                new TypeReference<ApiResp<ScopeRespVo>>() {
                }
        );
    }

    /**
     * POST {@code /scope/month/{uid}} - 月运势。
     */
    public ApiResp<ScopeRespVo> scopeMonth(String uid, ScopeQryReq qry) throws IOException {
        return executeJson(
                "POST",
                "/scope/month/" + uid,
                qry,
                new TypeReference<ApiResp<ScopeRespVo>>() {
                }
        );
    }

    /**
     * POST {@code /scope/year/{uid}} - 年运势。
     */
    public ApiResp<ScopeRespVo> scopeYear(String uid, ScopeQryReq qry) throws IOException {
        return executeJson(
                "POST",
                "/scope/year/" + uid,
                qry,
                new TypeReference<ApiResp<ScopeRespVo>>() {
                }
        );
    }

    // ----- Event -----

    /**
     * POST {@code /event/transit} - 行运事件列表。
     */
    public ApiResp<AstroEventVo> eventTransit(ScopeQryReq qry) throws IOException {
        return executeJson(
                "POST",
                "/event/transit",
                qry,
                new TypeReference<ApiResp<AstroEventVo>>() {
                }
        );
    }

    // ----- Sign -----

    /**
     * POST {@code /mySign/{uid}} - 用户星座（包含简要运势，需传出生点 body）。
     */
    public ApiResp<MySignRespVo> mySign(String uid, SignQry qry) throws IOException {
        return executeJson(
                "POST",
                "/mySign/" + uid,
                qry,
                new TypeReference<ApiResp<MySignRespVo>>() {
                }
        );
    }

    /**
     * GET {@code /signs} - 星座列表。
     */
    public ApiResp<java.util.List<SignVo>> signsList() throws IOException {
        return signsList(null);
    }

    /**
     * GET {@code /signs} - 星座列表。
     *
     * @param lang 可选语言：zh-Hans | zh-Hant | en
     */
    public ApiResp<java.util.List<SignVo>> signsList(String lang) throws IOException {
        return executeJson(
                "GET",
                withLangQuery("/signs", lang),
                null,
                new TypeReference<ApiResp<java.util.List<SignVo>>>() {
                }
        );
    }

    /**
     * GET {@code /signs/{signId}} - 星座详情。
     */
    public ApiResp<SignVo> signInfo(String signId) throws IOException {
        return signInfo(signId, null);
    }

    /**
     * GET {@code /signs/{signId}} - 星座详情。
     *
     * @param lang 可选语言：zh-Hans | zh-Hant | en
     */
    public ApiResp<SignVo> signInfo(String signId, String lang) throws IOException {
        return executeJson(
                "GET",
                withLangQuery("/signs/" + signId, lang),
                null,
                new TypeReference<ApiResp<SignVo>>() {
                }
        );
    }

    /**
     * GET {@code /signs/{signId}/compat} - 星座配对关系。
     */
    public ApiResp<java.util.Map<String, java.util.List<SignCompatVo>>> signCompat(String signId) throws IOException {
        return signCompat(signId, null);
    }

    /**
     * GET {@code /signs/{signId}/compat} - 星座配对关系。
     *
     * @param lang 可选语言：zh-Hans | zh-Hant | en
     */
    public ApiResp<java.util.Map<String, java.util.List<SignCompatVo>>> signCompat(String signId, String lang) throws IOException {
        return executeJson(
                "GET",
                withLangQuery("/signs/" + signId + "/compat", lang),
                null,
                new TypeReference<ApiResp<java.util.Map<String, java.util.List<SignCompatVo>>>>() {
                }
        );
    }

    // ----- Bazi -----

    /**
     * POST {@code /bazi/natal} - 八字命盘。
     */
    public ApiResp<BaziNatalVO> baziNatal(BaziNatalQry qry) throws IOException {
        return executeJson(
                "POST",
                "/bazi/natal",
                qry,
                new TypeReference<ApiResp<BaziNatalVO>>() {
                }
        );
    }

    /**
     * POST {@code /bazi/flow} - 八字流盘（带目标日期）。
     */
    public ApiResp<BaziFlowVO> baziFlow(BaziFlowQry qry) throws IOException {
        return executeJson(
                "POST",
                "/bazi/flow",
                qry,
                new TypeReference<ApiResp<BaziFlowVO>>() {
                }
        );
    }

    /**
     * POST {@code /bazi/match} - 八字合盘（两个人）。
     */
    public ApiResp<BaziMatchVO> baziMatch(BaziMatchQry qry) throws IOException {
        return executeJson(
                "POST",
                "/bazi/match",
                qry,
                new TypeReference<ApiResp<BaziMatchVO>>() {
                }
        );
    }

    /**
     * POST {@code /bazi/summary} - 八字总结。
     */
    public ApiResp<BaziSummaryVO> baziSummary(BaziNatalQry qry) throws IOException {
        return executeJson(
                "POST",
                "/bazi/summary",
                qry,
                new TypeReference<ApiResp<BaziSummaryVO>>() {
                }
        );
    }

    // ----- Ziwei -----

    /**
     * POST {@code /ziwei/natal} - 紫微本命盘。
     */
    public ApiResp<ZiweiNatalVo> ziweiNatal(ZiweiNatalQry qry) throws IOException {
        return executeJson(
                "POST",
                "/ziwei/natal",
                qry,
                new TypeReference<ApiResp<ZiweiNatalVo>>() {
                }
        );
    }

    /**
     * POST {@code /ziwei/chart} - 紫微运限盘（带流年/流月等）。
     */
    public ApiResp<ZiweiChartVo> ziweiChart(ZiweiQry qry) throws IOException {
        return executeJson(
                "POST",
                "/ziwei/chart",
                qry,
                new TypeReference<ApiResp<ZiweiChartVo>>() {
                }
        );
    }

    /**
     * POST {@code /ziwei/detail} - 紫微运限 + 解读。
     */
    public ApiResp<ZiweiDetailVo> ziweiDetail(ZiweiQry qry) throws IOException {
        return executeJson(
                "POST",
                "/ziwei/detail",
                qry,
                new TypeReference<ApiResp<ZiweiDetailVo>>() {
                }
        );
    }

    // ----- Naks -----

    /**
     * POST {@code /naks/relations} - 星宿关系（本命 / 值日 / 与他人的关系）。
     */
    public ApiResp<NaksVo> naksRelations(NaksQry qry) throws IOException {
        return executeJson(
                "POST",
                "/naks/relations",
                qry,
                new TypeReference<ApiResp<NaksVo>>() {
                }
        );
    }

    // ----- Sanshi: Qimen / Liuren -----

    /**
     * POST {@code /qimen} - 奇门遁甲排盘。
     */
    public ApiResp<QimenResultVo> qimen(QimenQry qry) throws IOException {
        return executeJson(
                "POST",
                "/qimen",
                qry,
                new TypeReference<ApiResp<QimenResultVo>>() {
                }
        );
    }

    /**
     * POST {@code /liuren} - 大六壬 / 金口诀排盘。
     */
    public ApiResp<LiurenResultVo> liuren(LiurenQry qry) throws IOException {
        return executeJson(
                "POST",
                "/liuren",
                qry,
                new TypeReference<ApiResp<LiurenResultVo>>() {
                }
        );
    }

    // ----- Qizheng (七政四余 / 政余) -----

    /**
     * POST {@code /zhengyu/natal} - 七政四余本命盘。
     */
    public ApiResp<QizhengNatalVo> zhengyuNatal(QizhengNatalQry qry) throws IOException {
        return executeJson(
                "POST",
                "/zhengyu/natal",
                qry,
                new TypeReference<ApiResp<QizhengNatalVo>>() {
                }
        );
    }

    /**
     * POST {@code /zhengyu/chart} - 七政四余排盘（本命+行运）。
     */
    public ApiResp<QizhengChartVo> zhengyuChart(QizhengQry qry) throws IOException {
        return executeJson(
                "POST",
                "/zhengyu/chart",
                qry,
                new TypeReference<ApiResp<QizhengChartVo>>() {
                }
        );
    }

    /**
     * POST {@code /zhengyu/comparison} - 七政四余比较盘。
     */
    public ApiResp<QizhengComparisonVo> zhengyuComparison(QizhengComparisonQry qry) throws IOException {
        return executeJson(
                "POST",
                "/zhengyu/comparison",
                qry,
                new TypeReference<ApiResp<QizhengComparisonVo>>() {
                }
        );
    }

    /**
     * GET {@code /zhengyu/spirit-stars/catalog} - 七政四余神煞目录。
     */
    public ApiResp<QizhengSpiritStarCatalogVo> zhengyuSpiritStarsCatalog() throws IOException {
        return zhengyuSpiritStarsCatalog(null);
    }

    /**
     * GET {@code /zhengyu/spirit-stars/catalog} - 七政四余神煞目录。
     *
     * @param lang 可选语言：zh-Hans | zh-Hant
     */
    public ApiResp<QizhengSpiritStarCatalogVo> zhengyuSpiritStarsCatalog(String lang) throws IOException {
        return executeJson(
                "GET",
                withLangQuery("/zhengyu/spirit-stars/catalog", lang),
                null,
                new TypeReference<ApiResp<QizhengSpiritStarCatalogVo>>() {
                }
        );
    }

    // ----- Report -----

    /**
     * POST {@code /report/romantic} - 桃花报告（恋爱/吸引力）。创建报告任务并返回流水号。
     */
    public ApiResp<AstroReportVo> reportRomantic(RomanticCreateQry romanticCreateQry) throws IOException {
        return executeJson(
                "POST",
                "/report/romantic",
                romanticCreateQry,
                new TypeReference<ApiResp<AstroReportVo>>() {
                }
        );
    }

    /**
     * POST {@code /report/weeklyScope} - 周运报告。
     */
    public ApiResp<AstroReportVo> reportWeeklyScope(WeeklyScopeCreateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/report/weeklyScope",
                qry,
                new TypeReference<ApiResp<AstroReportVo>>() {
                }
        );
    }

    /**
     * POST {@code /report/yearlyScope} - 年运报告。
     */
    public ApiResp<AstroReportVo> reportYearlyScope(YearlyScopeCreateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/report/yearlyScope",
                qry,
                new TypeReference<ApiResp<AstroReportVo>>() {
                }
        );
    }

    /**
     * POST {@code /report/together} - 合盘报告。
     */
    public ApiResp<AstroReportVo> reportTogether(TogetherCreateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/report/together",
                qry,
                new TypeReference<ApiResp<AstroReportVo>>() {
                }
        );
    }

    /**
     * POST {@code /report/wealth} - 财运报告。
     */
    public ApiResp<AstroReportVo> reportWealth(WealthCreateQry qry) throws IOException {
        return executeJson(
                "POST",
                "/report/wealth",
                qry,
                new TypeReference<ApiResp<AstroReportVo>>() {
                }
        );
    }

    /**
     * GET {@code /report/{uid}/{serialNo}} - 获取报告 JSON 内容。
     */
    public ApiResp<AstroReportVo> reportGet(String uid, String serialNo) throws IOException {
        return executeJson(
                "GET",
                "/report/" + uid + "/" + serialNo,
                null,
                new TypeReference<ApiResp<AstroReportVo>>() {
                }
        );
    }

    /**
     * GET {@code /report/{uid}/{serialNo}/html} - 获取报告 HTML 内容（字节数组）。
     */
    public byte[] reportGetHtml(String uid, String serialNo) throws IOException {
        Request.Builder builder = baseRequest("/report/" + uid + "/" + serialNo + "/html").get();
        try (Response resp = httpClient.newCall(builder.build()).execute()) {
            if (!resp.isSuccessful()) {
                throw new IOException("HTTP " + resp.code() + " for /report html");
            }
            if (resp.body() == null) {
                return new byte[0];
            }
            return resp.body().bytes();
        }
    }
}

