package com.apiworks.astro.examples;

import com.apiworks.astro.AsyncAstroCloudClient;
import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.common.TimeAndLocation;
import com.apiworks.astro.model.requests.bazi.BaziNatalQry;
import com.apiworks.astro.model.requests.report.RomanticCreateQry;
import com.apiworks.astro.model.requests.scope.ScopeQryReq;
import com.apiworks.astro.model.requests.ziwei.ZiweiNatalQry;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;
import com.apiworks.astro.model.responses.report.AstroReportVo;
import com.apiworks.astro.model.responses.scope.ScopeRespVo;
import com.apiworks.astro.model.responses.ziwei.ZiweiNatalVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 使用真实后端地址验证 {@link AsyncExample} 中各异步接口调用是否正常。
 * 仅当环境变量 APIWORKS_APP_ID、APIWORKS_APP_KEY 均已设置时执行。
 */
@EnabledIfEnvironmentVariable(named = "APIWORKS_APP_ID", matches = ".+")
@EnabledIfEnvironmentVariable(named = "APIWORKS_APP_KEY", matches = ".+")
class AsyncExampleRealBackendIT {

    private AsyncAstroCloudClient client;

    @BeforeEach
    void setUp() {
        String appId = System.getenv("APIWORKS_APP_ID");
        String appKey = System.getenv("APIWORKS_APP_KEY");
        client = new AsyncAstroCloudClient(appId, appKey);
    }

    @Test
    void chartNatal() throws Exception {
        CompletableFuture<ApiResp<AstroDataVo>> future = client.chartNatal(
                new SinglePointQry(new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4074, 39.9042)));
        ApiResp<AstroDataVo> resp = future.get(15, TimeUnit.SECONDS);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
        assertNotNull(resp.getData().getPlanet());
    }

    @Test
    void baziNatalThenScopeDay() throws Exception {
        BaziNatalQry baziQry = new BaziNatalQry();
        baziQry.setBirthDt("1990-08-14 12:00:00");
        baziQry.setTz(8);
        baziQry.setGender("male");
        ScopeQryReq scopeQry = new ScopeQryReq(
                new TimeAndLocation("1990-01-01 12:00:00", 8, 116.4, 39.9),
                new TimeAndLocation("2025-02-26 12:00:00", 8, 116.4, 39.9));

        ApiResp<ScopeRespVo> scopeResp = client.baziNatal(baziQry)
                .thenCompose(baziResp -> {
                    assertEquals(0, baziResp.getCode(), "bazi msg: " + baziResp.getMsg());
                    return client.scopeDay("user-async-demo", scopeQry);
                })
                .get(20, TimeUnit.SECONDS);
        assertEquals(0, scopeResp.getCode(), "scope msg: " + scopeResp.getMsg());
        assertNotNull(scopeResp.getData());
    }

    @Test
    void ziweiNatalAndReportRomantic() throws Exception {
        ZiweiNatalQry ziweiQry = new ZiweiNatalQry();
        ziweiQry.setBirthDt("1999-10-17 21:00:00");
        ziweiQry.setTz(8);
        ziweiQry.setGender("female");
        RomanticCreateQry romanticQry = new RomanticCreateQry();
        romanticQry.setUserBirthPoint(new TimeAndLocation("1990-01-01 13:14:15", 8, 116.4, 39.9));
        romanticQry.setUserCurrentPoint(new TimeAndLocation("2025-11-26 13:14:15", 8, 116.4, 39.9));
        romanticQry.setUserId("user-async-demo");

        CompletableFuture<ApiResp<ZiweiNatalVo>> zFuture = client.ziweiNatal(ziweiQry);
        CompletableFuture<ApiResp<AstroReportVo>> rFuture = client.reportRomantic(romanticQry);

        ApiResp<ZiweiNatalVo> z = zFuture.get(15, TimeUnit.SECONDS);
        ApiResp<AstroReportVo> r = rFuture.get(15, TimeUnit.SECONDS);
        assertEquals(0, z.getCode(), "ziwei msg: " + z.getMsg());
        assertEquals(0, r.getCode(), "report msg: " + r.getMsg());
        assertNotNull(z.getData());
        assertNotNull(r.getData());
        assertNotNull(r.getData().getSerialNo());
    }
}
