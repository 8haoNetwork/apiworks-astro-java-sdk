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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * 异步版 ApiWorks 星盘 API 客户端。
 * <p>
 * 行为与同步 {@link AstroCloudClient} 完全一致，但所有方法均返回 {@link CompletableFuture}，
 * 便于在异步/响应式场景下串联多个调用。
 * <ul>
 *     <li>请求头、基础路径、返回结构与后端 HTTP API 保持一致</li>
 *     <li>方法名称与同步版一一对应（如 {@code chartNatal}、{@code scopeDay} 等）</li>
 * </ul>
 * <p>
 * 使用完毕后可调用 {@link #close()} 关闭内部线程池，避免进程退出时出现线程未结束的 warning。
 */
public class AsyncAstroCloudClient implements AutoCloseable {

    public static final String DEFAULT_BASE_URL = AstroCloudClient.DEFAULT_BASE_URL;

    private final String appId;
    private final String appKey;
    private final String baseUrl;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public AsyncAstroCloudClient(String appId, String appKey) {
        this(appId, appKey, DEFAULT_BASE_URL, 30_000);
    }

    public AsyncAstroCloudClient(String appId, String appKey, String baseUrl, long timeoutMillis) {
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
        if (url == null) return DEFAULT_BASE_URL;
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

    private <T> CompletableFuture<ApiResp<T>> executeJsonAsync(String method, String path, Object body,
                                                                 TypeReference<ApiResp<T>> typeRef) {
        CompletableFuture<ApiResp<T>> future = new CompletableFuture<>();
        RequestBody requestBody = null;
        if (body != null) {
            try {
                requestBody = RequestBody.create(objectMapper.writeValueAsString(body), JSON);
            } catch (Exception e) {
                future.completeExceptionally(e);
                return future;
            }
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
                future.completeExceptionally(new IllegalArgumentException("Unsupported method: " + method));
                return future;
        }
        httpClient.newCall(builder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    String respBody = response.body() != null ? response.body().string() : "";
                    if (!response.isSuccessful()) {
                        String detail = respBody.isEmpty() ? "" : "; body: " + (respBody.length() > 512 ? respBody.substring(0, 512) + "..." : respBody);
                        future.completeExceptionally(new IOException("HTTP " + response.code() + " for " + path + detail));
                        return;
                    }
                    if (respBody.isEmpty()) {
                        future.completeExceptionally(new IOException("Empty response body for " + path));
                        return;
                    }
                    future.complete(objectMapper.readValue(respBody, typeRef));
                } catch (Exception e) {
                    future.completeExceptionally(e);
                } finally {
                    response.close();
                }
            }
        });
        return future;
    }

    private CompletableFuture<byte[]> executeBytesAsync(String path) {
        CompletableFuture<byte[]> future = new CompletableFuture<>();
        Request request = baseRequest(path).get().build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    byte[] bodyBytes = response.body() != null ? response.body().bytes() : new byte[0];
                    if (!response.isSuccessful()) {
                        String bodyStr = bodyBytes.length > 512 ? new String(bodyBytes, 0, 512, StandardCharsets.UTF_8) + "..." : new String(bodyBytes, StandardCharsets.UTF_8);
                        String detail = bodyBytes.length == 0 ? "" : "; body: " + bodyStr;
                        future.completeExceptionally(new IOException("HTTP " + response.code() + " for " + path + detail));
                        return;
                    }
                    future.complete(bodyBytes);
                } catch (Exception e) {
                    future.completeExceptionally(e);
                } finally {
                    response.close();
                }
            }
        });
        return future;
    }

    // ----- Chart: single point -----
    public CompletableFuture<ApiResp<AstroDataVo>> chartNatal(SinglePointQry qry) {
        return executeJsonAsync("POST", "/chart/natal", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartCurrent(SinglePointQry qry) {
        return executeJsonAsync("POST", "/chart/current", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    // ----- Chart: double point -----
    public CompletableFuture<ApiResp<AstroDataVo>> chartTransit(DoublePointQry qry) {
        return executeJsonAsync("POST", "/chart/transit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartComparison(DoublePointQry qry) {
        return executeJsonAsync("POST", "/chart/comparison", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartComposite(DoublePointQry qry) {
        return executeJsonAsync("POST", "/chart/composite", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartTimesMidPoint(DoublePointQry qry) {
        return executeJsonAsync("POST", "/chart/timesMidPoint", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartMarks(DoublePointQry qry) {
        return executeJsonAsync("POST", "/chart/marks", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartLunarReturn(DoublePointQry qry) {
        return executeJsonAsync("POST", "/chart/lunarReturn", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartSolarReturn(DoublePointQry qry) {
        return executeJsonAsync("POST", "/chart/solarReturn", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    // ----- Chart: single point + transit date -----
    public CompletableFuture<ApiResp<AstroDataVo>> chartTripleLimit(SpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/tripleLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartSecondaryLimit(SpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/secondaryLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartFirdaria(SpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/firdaria", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartSmallLimit(SpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/smallLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartSolarArc(SpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/solarArc", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    // ----- Chart: double point + transit date -----
    public CompletableFuture<ApiResp<AstroDataVo>> chartComposeTripleLimit(DpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/composeTripleLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartComposeSecLimit(DpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/composeSecLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartMarksTripleLimit(DpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/marksTripleLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartMarksSecLimit(DpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/marksSecLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartTmpTripleLimit(DpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/tmpTripleLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroDataVo>> chartTmpSecLimit(DpTransitDateQry qry) {
        return executeJsonAsync("POST", "/chart/tmpSecLimit", qry, new TypeReference<ApiResp<AstroDataVo>>() {});
    }

    // ----- Scope -----
    public CompletableFuture<ApiResp<ScopeRespVo>> scopeDay(String uid, ScopeQryReq qry) {
        return executeJsonAsync("POST", "/scope/day/" + uid, qry, new TypeReference<ApiResp<ScopeRespVo>>() {});
    }

    public CompletableFuture<ApiResp<ScopeRespVo>> scopeWeek(String uid, ScopeQryReq qry) {
        return executeJsonAsync("POST", "/scope/week/" + uid, qry, new TypeReference<ApiResp<ScopeRespVo>>() {});
    }

    public CompletableFuture<ApiResp<ScopeRespVo>> scopeMonth(String uid, ScopeQryReq qry) {
        return executeJsonAsync("POST", "/scope/month/" + uid, qry, new TypeReference<ApiResp<ScopeRespVo>>() {});
    }

    public CompletableFuture<ApiResp<ScopeRespVo>> scopeYear(String uid, ScopeQryReq qry) {
        return executeJsonAsync("POST", "/scope/year/" + uid, qry, new TypeReference<ApiResp<ScopeRespVo>>() {});
    }

    // ----- Event -----
    public CompletableFuture<ApiResp<AstroEventVo>> eventTransit(ScopeQryReq qry) {
        return executeJsonAsync("POST", "/event/transit", qry, new TypeReference<ApiResp<AstroEventVo>>() {});
    }

    // ----- Sign -----
    public CompletableFuture<ApiResp<MySignRespVo>> mySign(String uid, SignQry qry) {
        return executeJsonAsync("POST", "/mySign/" + uid, qry, new TypeReference<ApiResp<MySignRespVo>>() {});
    }

    public CompletableFuture<ApiResp<List<SignVo>>> signsList() {
        return signsList(null);
    }

    public CompletableFuture<ApiResp<List<SignVo>>> signsList(String lang) {
        return executeJsonAsync("GET", withLangQuery("/signs", lang), null, new TypeReference<ApiResp<List<SignVo>>>() {});
    }

    public CompletableFuture<ApiResp<SignVo>> signInfo(String signId) {
        return signInfo(signId, null);
    }

    public CompletableFuture<ApiResp<SignVo>> signInfo(String signId, String lang) {
        return executeJsonAsync("GET", withLangQuery("/signs/" + signId, lang), null, new TypeReference<ApiResp<SignVo>>() {});
    }

    public CompletableFuture<ApiResp<Map<String, List<SignCompatVo>>>> signCompat(String signId) {
        return signCompat(signId, null);
    }

    public CompletableFuture<ApiResp<Map<String, List<SignCompatVo>>>> signCompat(String signId, String lang) {
        return executeJsonAsync("GET", withLangQuery("/signs/" + signId + "/compat", lang), null,
                new TypeReference<ApiResp<Map<String, List<SignCompatVo>>>>() {});
    }

    // ----- Bazi -----
    public CompletableFuture<ApiResp<BaziNatalVO>> baziNatal(BaziNatalQry qry) {
        return executeJsonAsync("POST", "/bazi/natal", qry, new TypeReference<ApiResp<BaziNatalVO>>() {});
    }

    public CompletableFuture<ApiResp<BaziFlowVO>> baziFlow(BaziFlowQry qry) {
        return executeJsonAsync("POST", "/bazi/flow", qry, new TypeReference<ApiResp<BaziFlowVO>>() {});
    }

    public CompletableFuture<ApiResp<BaziMatchVO>> baziMatch(BaziMatchQry qry) {
        return executeJsonAsync("POST", "/bazi/match", qry, new TypeReference<ApiResp<BaziMatchVO>>() {});
    }

    public CompletableFuture<ApiResp<BaziSummaryVO>> baziSummary(BaziNatalQry qry) {
        return executeJsonAsync("POST", "/bazi/summary", qry, new TypeReference<ApiResp<BaziSummaryVO>>() {});
    }

    // ----- Ziwei -----
    public CompletableFuture<ApiResp<ZiweiNatalVo>> ziweiNatal(ZiweiNatalQry qry) {
        return executeJsonAsync("POST", "/ziwei/natal", qry, new TypeReference<ApiResp<ZiweiNatalVo>>() {});
    }

    public CompletableFuture<ApiResp<ZiweiChartVo>> ziweiChart(ZiweiQry qry) {
        return executeJsonAsync("POST", "/ziwei/chart", qry, new TypeReference<ApiResp<ZiweiChartVo>>() {});
    }

    public CompletableFuture<ApiResp<ZiweiDetailVo>> ziweiDetail(ZiweiQry qry) {
        return executeJsonAsync("POST", "/ziwei/detail", qry, new TypeReference<ApiResp<ZiweiDetailVo>>() {});
    }

    // ----- Naks -----
    public CompletableFuture<ApiResp<NaksVo>> naksRelations(NaksQry qry) {
        return executeJsonAsync("POST", "/naks/relations", qry, new TypeReference<ApiResp<NaksVo>>() {});
    }

    // ----- Sanshi: Qimen / Liuren -----
    public CompletableFuture<ApiResp<QimenResultVo>> qimen(QimenQry qry) {
        return executeJsonAsync("POST", "/qimen", qry, new TypeReference<ApiResp<QimenResultVo>>() {});
    }

    public CompletableFuture<ApiResp<LiurenResultVo>> liuren(LiurenQry qry) {
        return executeJsonAsync("POST", "/liuren", qry, new TypeReference<ApiResp<LiurenResultVo>>() {});
    }

    // ----- Report -----
    public CompletableFuture<ApiResp<AstroReportVo>> reportRomantic(RomanticCreateQry qry) {
        return executeJsonAsync("POST", "/report/romantic", qry, new TypeReference<ApiResp<AstroReportVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroReportVo>> reportWeeklyScope(WeeklyScopeCreateQry qry) {
        return executeJsonAsync("POST", "/report/weeklyScope", qry, new TypeReference<ApiResp<AstroReportVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroReportVo>> reportYearlyScope(YearlyScopeCreateQry qry) {
        return executeJsonAsync("POST", "/report/yearlyScope", qry, new TypeReference<ApiResp<AstroReportVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroReportVo>> reportTogether(TogetherCreateQry qry) {
        return executeJsonAsync("POST", "/report/together", qry, new TypeReference<ApiResp<AstroReportVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroReportVo>> reportWealth(WealthCreateQry qry) {
        return executeJsonAsync("POST", "/report/wealth", qry, new TypeReference<ApiResp<AstroReportVo>>() {});
    }

    public CompletableFuture<ApiResp<AstroReportVo>> reportGet(String uid, String serialNo) {
        return executeJsonAsync("GET", "/report/" + uid + "/" + serialNo, null, new TypeReference<ApiResp<AstroReportVo>>() {});
    }

    public CompletableFuture<byte[]> reportGetHtml(String uid, String serialNo) {
        return executeBytesAsync("/report/" + uid + "/" + serialNo + "/html");
    }
}
