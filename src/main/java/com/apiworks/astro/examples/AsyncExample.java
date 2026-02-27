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
import com.apiworks.astro.model.responses.ziwei.ZiweiNatalVo;

import java.util.concurrent.CompletableFuture;

/**
 * 异步客户端示例：使用 CompletableFuture 调用本命盘、八字、运势、紫微、报告等。
 * 运行前请设置环境变量：APIWORKS_APP_ID、APIWORKS_APP_KEY
 */
public class AsyncExample {

    public static void main(String[] args) throws Exception {
        String appId = System.getenv("APIWORKS_APP_ID");
        String appKey = System.getenv("APIWORKS_APP_KEY");
        if (appId == null || appKey == null || appId.isEmpty() || appKey.isEmpty()) {
            System.err.println("请设置环境变量: APIWORKS_APP_ID, APIWORKS_APP_KEY");
            return;
        }

        try (AsyncAstroCloudClient client = new AsyncAstroCloudClient(appId, appKey)) {
            // 1. 单次异步：本命盘
            CompletableFuture<ApiResp<AstroDataVo>> natalFuture = client.chartNatal(new SinglePointQry(
                new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4074, 39.9042)));
            natalFuture.thenAccept(resp -> {
                if (resp.getCode() == 0 && resp.getData() != null) {
                    System.out.println("[异步] 本命盘 行星数: " + (resp.getData().getPlanet() != null ? resp.getData().getPlanet().size() : 0));
                } else {
                    System.out.println("[异步] 本命盘 code=" + resp.getCode() + " msg=" + resp.getMsg());
                }
            }).exceptionally(ex -> {
                System.err.println("[异步] 本命盘 error: " + ex.getMessage());
                return null;
            });

            // 2. 链式：八字 -> 再查运势
            BaziNatalQry baziQry = new BaziNatalQry();
            baziQry.setBirthDt("1990-08-14 12:00:00");
            baziQry.setTz(8);
            baziQry.setGender("male");

            ScopeQryReq scopeQry = new ScopeQryReq(
                new TimeAndLocation("1990-01-01 12:00:00", 8, 116.4, 39.9),
                new TimeAndLocation("2025-02-26 12:00:00", 8, 116.4, 39.9));

            client.baziNatal(baziQry)
                .thenCompose(baziResp -> {
                    if (baziResp.getCode() == 0) {
                        System.out.println("[异步] 八字命盘 OK");
                    }
                    return client.scopeDay("user-async-demo", scopeQry);
                })
                .thenAccept(scopeResp -> {
                    if (scopeResp.getCode() == 0 && scopeResp.getData() != null && scopeResp.getData().getScopeTotal() != null) {
                        System.out.println("[异步] 日运势总分: " + scopeResp.getData().getScopeTotal().getVal());
                    }
                })
                .exceptionally(ex -> {
                    System.err.println("[异步] 八字/运势 error: " + ex.getMessage());
                    return null;
                });

            // 3. 并行多请求：紫微 + 桃花报告
            ZiweiNatalQry ziweiQry = new ZiweiNatalQry();
            ziweiQry.setBirthDt("1999-10-17 21:00:00");
            ziweiQry.setTz(8);
            ziweiQry.setGender("female");

            RomanticCreateQry romanticQry = new RomanticCreateQry();
            romanticQry.setUserBirthPoint(new TimeAndLocation("1990-01-01 13:14:15", 8, 116.4, 39.9));
            romanticQry.setUserCurrentPoint(new TimeAndLocation("2025-11-26 13:14:15", 8, 116.4, 39.9));
            romanticQry.setUserId("user-async-demo");

            CompletableFuture<ApiResp<ZiweiNatalVo>> ziweiFuture = client.ziweiNatal(ziweiQry);
            CompletableFuture<ApiResp<AstroReportVo>> reportFuture = client.reportRomantic(romanticQry);

            CompletableFuture.allOf(ziweiFuture, reportFuture).thenRun(() -> {
                try {
                    ApiResp<ZiweiNatalVo> z = ziweiFuture.get();
                    if (z.getCode() == 0 && z.getData() != null) {
                        System.out.println("[异步] 紫微 命主: " + z.getData().getSoulLord());
                    }
                    ApiResp<AstroReportVo> r = reportFuture.get();
                    if (r.getCode() == 0 && r.getData() != null && r.getData().getSerialNo() != null) {
                        System.out.println("[异步] 桃花报告 serialNo: " + r.getData().getSerialNo());
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }).exceptionally(ex -> {
                System.err.println("[异步] 紫微/报告 error: " + ex.getMessage());
                return null;
            });

            // 等待所有异步完成（示例中简单 sleep，实际可用 CountDownLatch 或 main 不退出）
            Thread.sleep(15_000);
            System.out.println("示例结束。");
        }
    }
}
