package com.apiworks.astro.examples;

import com.apiworks.astro.AstroCloudClient;
import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.common.TimeAndLocation;
import com.apiworks.astro.model.requests.bazi.BaziNatalQry;
import com.apiworks.astro.model.requests.naks.NaksBirthInfo;
import com.apiworks.astro.model.requests.naks.NaksQry;
import com.apiworks.astro.model.requests.report.RomanticCreateQry;
import com.apiworks.astro.model.requests.qizheng.QizhengComparisonQry;
import com.apiworks.astro.model.requests.qizheng.QizhengNatalQry;
import com.apiworks.astro.model.requests.qizheng.QizhengPersonQry;
import com.apiworks.astro.model.requests.qizheng.QizhengQry;
import com.apiworks.astro.model.requests.sanshi.LiurenQry;
import com.apiworks.astro.model.requests.sanshi.QimenQry;
import com.apiworks.astro.model.requests.scope.ScopeQryReq;
import com.apiworks.astro.model.requests.ziwei.ZiweiNatalQry;
import com.apiworks.astro.model.requests.chart.DoublePointQry;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;
import com.apiworks.astro.model.responses.bazi.BaziNatalVO;
import com.apiworks.astro.model.responses.naks.NaksVo;
import com.apiworks.astro.model.responses.qizheng.QizhengChartVo;
import com.apiworks.astro.model.responses.qizheng.QizhengComparisonVo;
import com.apiworks.astro.model.responses.qizheng.QizhengNatalVo;
import com.apiworks.astro.model.responses.report.AstroReportVo;
import com.apiworks.astro.model.responses.sanshi.LiurenResultVo;
import com.apiworks.astro.model.responses.sanshi.QimenResultVo;
import com.apiworks.astro.model.responses.scope.ScopeRespVo;
import com.apiworks.astro.model.responses.ziwei.ZiweiNatalVo;

import java.util.Collections;
import java.util.List;

/**
 * 同步客户端示例：本命盘、八字、运势、紫微、星宿、报告等。
 * 运行前请设置环境变量：APIWORKS_APP_ID、APIWORKS_APP_KEY
 */
public class SyncExample {

    public static void main(String[] args) {
        String appId = System.getenv("APIWORKS_APP_ID");
        String appKey = System.getenv("APIWORKS_APP_KEY");
        if (appId == null || appKey == null || appId.isEmpty() || appKey.isEmpty()) {
            System.err.println("请设置环境变量: APIWORKS_APP_ID, APIWORKS_APP_KEY");
            return;
        }

        // try-with-resources：退出时自动调用 client.close()，避免 OkHttp 线程未结束的 warning
        try (AstroCloudClient client = new AstroCloudClient(appId, appKey)) {
            // 1. 本命盘
            exampleChartNatal(client);

            // 2. 行运盘（双点）
            exampleChartTransit(client);

            // 3. 八字命盘
            exampleBaziNatal(client);

            // 4. 日运势
            exampleScopeDay(client);

            // 5. 紫微本命盘
            exampleZiweiNatal(client);

            // 6. 星宿关系
            exampleNaksRelations(client);

            // 7. 七政四余
            exampleZhengyuNatal(client);
            exampleZhengyuChart(client);
            exampleZhengyuComparison(client);

            // 8. 奇门遁甲 / 大六壬
            exampleQimen(client);
            exampleLiuren(client);

            // 9. 桃花报告（创建任务，拿到 serialNo 后可 reportGet / reportGetHtml 拉取）
            exampleReportRomantic(client);
        }
    }

    static void exampleChartNatal(AstroCloudClient client) {
        System.out.println("--- 本命盘 ---");
        TimeAndLocation tl = new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4074, 39.9042);
        SinglePointQry qry = new SinglePointQry(tl);
        try {
            ApiResp<AstroDataVo> resp = client.chartNatal(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                AstroDataVo data = resp.getData();
                System.out.println("行星数: " + (data.getPlanet() != null ? data.getPlanet().size() : 0));
                System.out.println("宫位数: " + (data.getHouse() != null ? data.getHouse().size() : 0));
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("chartNatal error: " + e.getMessage());
        }
    }

    static void exampleChartTransit(AstroCloudClient client) {
        System.out.println("--- 行运盘 ---");
        TimeAndLocation birth = new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4, 39.9);
        TimeAndLocation transit = new TimeAndLocation("2025-02-26 12:00:00", 8, 116.4, 39.9);
        DoublePointQry qry = new DoublePointQry(List.of(birth, transit));
        try {
            ApiResp<AstroDataVo> resp = client.chartTransit(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                System.out.println("行运盘获取成功, 耗时: " + resp.getExeTime() + "s");
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("chartTransit error: " + e.getMessage());
        }
    }

    static void exampleBaziNatal(AstroCloudClient client) {
        System.out.println("--- 八字命盘 ---");
        BaziNatalQry qry = new BaziNatalQry();
        qry.setBirthDt("1990-08-14 12:00:00");
        qry.setTz(8);
        qry.setGender("male");
        try {
            ApiResp<BaziNatalVO> resp = client.baziNatal(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                BaziNatalVO data = resp.getData();
                System.out.println("出生: " + data.getBirthDt() + ", 四柱数: " + (data.getPillars() != null ? data.getPillars().size() : 0));
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("baziNatal error: " + e.getMessage());
        }
    }

    static void exampleScopeDay(AstroCloudClient client) {
        System.out.println("--- 日运势 ---");
        TimeAndLocation birth = new TimeAndLocation("1990-01-01 12:00:00", 8, 116.4, 39.9);
        TimeAndLocation transit = new TimeAndLocation("2025-02-26 12:00:00", 8, 116.4, 39.9);
        ScopeQryReq qry = new ScopeQryReq(birth, transit);
        try {
            ApiResp<ScopeRespVo> resp = client.scopeDay("user-sync-demo", qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                ScopeRespVo data = resp.getData();
                if (data.getScopeTotal() != null) {
                    System.out.println("运势总分: " + data.getScopeTotal().getVal());
                }
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("scopeDay error: " + e.getMessage());
        }
    }

    static void exampleZiweiNatal(AstroCloudClient client) {
        System.out.println("--- 紫微本命盘 ---");
        ZiweiNatalQry qry = new ZiweiNatalQry();
        qry.setBirthDt("1999-10-17 21:00:00");
        qry.setTz(8);
        qry.setGender("female");
        try {
            ApiResp<ZiweiNatalVo> resp = client.ziweiNatal(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                ZiweiNatalVo data = resp.getData();
                System.out.println("命主: " + data.getSoulLord() + ", 身主: " + data.getBodyLord());
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("ziweiNatal error: " + e.getMessage());
        }
    }

    static void exampleNaksRelations(AstroCloudClient client) {
        System.out.println("--- 星宿关系 ---");
        NaksBirthInfo self = new NaksBirthInfo();
        self.setBirthDt("1990-01-15 00:00:00");
        self.setTz(8);
        NaksBirthInfo other = new NaksBirthInfo();
        other.setBirthDt("1992-03-20 00:00:00");
        other.setTz(8);
        NaksQry qry = new NaksQry();
        qry.setBirthInfo(self);
        qry.setOthersBirthInfo(Collections.singletonList(other));
        try {
            ApiResp<NaksVo> resp = client.naksRelations(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                System.out.println("星宿关系获取成功");
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("naksRelations error: " + e.getMessage());
        }
    }

    static void exampleZhengyuNatal(AstroCloudClient client) {
        System.out.println("--- 七政四余本命盘 ---");
        QizhengNatalQry qry = new QizhengNatalQry();
        qry.setBirthDt("1990-08-14 12:00:00");
        qry.setTz(8);
        qry.setGender("male");
        try {
            ApiResp<QizhengNatalVo> resp = client.zhengyuNatal(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                QizhengNatalVo data = resp.getData();
                System.out.println("星曜数: " + (data.getStars() != null ? data.getStars().size() : 0)
                        + ", 宫位数: " + (data.getPalaces() != null ? data.getPalaces().size() : 0));
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("zhengyuNatal error: " + e.getMessage());
        }
    }

    static void exampleZhengyuChart(AstroCloudClient client) {
        System.out.println("--- 七政四余排盘 ---");
        QizhengQry qry = new QizhengQry();
        qry.setBirthDt("1990-08-14 12:00:00");
        qry.setTz(8);
        qry.setGender("male");
        qry.setTargetDt("2026-10-29 12:00:00");
        try {
            ApiResp<QizhengChartVo> resp = client.zhengyuChart(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                QizhengChartVo data = resp.getData();
                System.out.println("target: " + data.getTargetDt()
                        + ", 流行星数: " + (data.getFlowStars() != null ? data.getFlowStars().size() : 0));
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("zhengyuChart error: " + e.getMessage());
        }
    }

    static void exampleZhengyuComparison(AstroCloudClient client) {
        System.out.println("--- 七政四余比较盘 ---");
        QizhengPersonQry a = new QizhengPersonQry();
        a.setBirthDt("1990-08-14 12:00:00");
        a.setTz(8);
        a.setGender("male");
        QizhengPersonQry b = new QizhengPersonQry();
        b.setBirthDt("1992-03-20 08:00:00");
        b.setTz(8);
        b.setGender("female");
        QizhengComparisonQry qry = new QizhengComparisonQry(List.of(a, b));
        try {
            ApiResp<QizhengComparisonVo> resp = client.zhengyuComparison(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                QizhengComparisonVo data = resp.getData();
                System.out.println("A: " + data.getBirthDt() + ", B: " + data.getOtherBirthDt());
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("zhengyuComparison error: " + e.getMessage());
        }
    }

    static void exampleQimen(AstroCloudClient client) {
        System.out.println("--- 奇门遁甲 ---");
        QimenQry qry = new QimenQry();
        qry.setQryDt("1999-10-17 21:00:00");
        qry.setTz(8);
        qry.setType("shijia");
        qry.setPaiMethod("zhuanpan");
        qry.setJuMethod("chaibu");
        try {
            ApiResp<QimenResultVo> resp = client.qimen(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                QimenResultVo data = resp.getData();
                System.out.println("局: " + data.getJuDisplay()
                        + ", 九宫数: " + (data.getJiuGong() != null ? data.getJiuGong().size() : 0));
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("qimen error: " + e.getMessage());
        }
    }

    static void exampleLiuren(AstroCloudClient client) {
        System.out.println("--- 大六壬 ---");
        LiurenQry qry = new LiurenQry();
        qry.setQryDt("1999-10-17 21:00:00");
        qry.setTz(8);
        qry.setType("daliuren");
        qry.setGuiMethod("tian");
        try {
            ApiResp<LiurenResultVo> resp = client.liuren(qry);
            if (resp.getCode() == 0 && resp.getData() != null) {
                LiurenResultVo data = resp.getData();
                System.out.println("月将: " + data.getYueJiangName()
                        + ", 四课数: " + (data.getSiKe() != null ? data.getSiKe().size() : 0));
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("liuren error: " + e.getMessage());
        }
    }

    static void exampleReportRomantic(AstroCloudClient client) {
        System.out.println("--- 桃花报告 ---");
        RomanticCreateQry qry = new RomanticCreateQry();
        qry.setUserBirthPoint(new TimeAndLocation("1990-01-01 13:14:15", 8, 116.4, 39.9));
        qry.setUserCurrentPoint(new TimeAndLocation("2025-11-26 13:14:15", 8, 116.4, 39.9));
        qry.setUserId("user-sync-demo");
        try {
            ApiResp<AstroReportVo> resp = client.reportRomantic(qry);
            if (resp.getCode() == 0 && resp.getData() != null && resp.getData().getSerialNo() != null) {
                String serialNo = resp.getData().getSerialNo();
                System.out.println("报告任务已创建, serialNo: " + serialNo + " (可用 reportGet/reportGetHtml 拉取)");
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        } catch (Exception e) {
            System.err.println("reportRomantic error: " + e.getMessage());
        }
    }
}
