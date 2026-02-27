package com.apiworks.astro.examples;

import com.apiworks.astro.AstroCloudClient;
import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.common.TimeAndLocation;
import com.apiworks.astro.model.requests.bazi.BaziNatalQry;
import com.apiworks.astro.model.requests.naks.NaksBirthInfo;
import com.apiworks.astro.model.requests.naks.NaksQry;
import com.apiworks.astro.model.requests.report.RomanticCreateQry;
import com.apiworks.astro.model.requests.scope.ScopeQryReq;
import com.apiworks.astro.model.requests.ziwei.ZiweiNatalQry;
import com.apiworks.astro.model.requests.chart.DoublePointQry;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;
import com.apiworks.astro.model.responses.bazi.BaziNatalVO;
import com.apiworks.astro.model.responses.naks.NaksVo;
import com.apiworks.astro.model.responses.report.AstroReportVo;
import com.apiworks.astro.model.responses.scope.ScopeRespVo;
import com.apiworks.astro.model.responses.ziwei.ZiweiNatalVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 使用真实后端地址验证 {@link SyncExample} 中各接口调用是否正常。
 * 仅当环境变量 APIWORKS_APP_ID、APIWORKS_APP_KEY 均已设置时执行。
 */
@EnabledIfEnvironmentVariable(named = "APIWORKS_APP_ID", matches = ".+")
@EnabledIfEnvironmentVariable(named = "APIWORKS_APP_KEY", matches = ".+")
class SyncExampleRealBackendIT {

    private AstroCloudClient client;

    @BeforeEach
    void setUp() {
        String appId = System.getenv("APIWORKS_APP_ID");
        String appKey = System.getenv("APIWORKS_APP_KEY");
        client = new AstroCloudClient(appId, appKey);
    }

    @Test
    void exampleChartNatal() throws Exception {
        TimeAndLocation tl = new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4074, 39.9042);
        SinglePointQry qry = new SinglePointQry(tl);
        ApiResp<AstroDataVo> resp = client.chartNatal(qry);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
        assertNotNull(resp.getData().getPlanet());
        assertNotNull(resp.getData().getHouse());
    }

    @Test
    void exampleChartTransit() throws Exception {
        TimeAndLocation birth = new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4, 39.9);
        TimeAndLocation transit = new TimeAndLocation("2025-02-26 12:00:00", 8, 116.4, 39.9);
        DoublePointQry qry = new DoublePointQry(List.of(birth, transit));
        ApiResp<AstroDataVo> resp = client.chartTransit(qry);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
    }

    @Test
    void exampleBaziNatal() throws Exception {
        BaziNatalQry qry = new BaziNatalQry();
        qry.setBirthDt("1990-08-14 12:00:00");
        qry.setTz(8);
        qry.setGender("male");
        ApiResp<BaziNatalVO> resp = client.baziNatal(qry);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
        assertNotNull(resp.getData().getPillars());
    }

    @Test
    void exampleScopeDay() throws Exception {
        TimeAndLocation birth = new TimeAndLocation("1990-01-01 12:00:00", 8, 116.4, 39.9);
        TimeAndLocation transit = new TimeAndLocation("2025-02-26 12:00:00", 8, 116.4, 39.9);
        ScopeQryReq qry = new ScopeQryReq(birth, transit);
        ApiResp<ScopeRespVo> resp = client.scopeDay("user-sync-demo", qry);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
    }

    @Test
    void exampleZiweiNatal() throws Exception {
        ZiweiNatalQry qry = new ZiweiNatalQry();
        qry.setBirthDt("1999-10-17 21:00:00");
        qry.setTz(8);
        qry.setGender("female");
        ApiResp<ZiweiNatalVo> resp = client.ziweiNatal(qry);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
        assertNotNull(resp.getData().getSoulLord());
    }

    @Test
    void exampleNaksRelations() throws Exception {
        NaksBirthInfo self = new NaksBirthInfo();
        self.setBirthDt("1990-01-15 00:00:00");
        self.setTz(8);
        NaksBirthInfo other = new NaksBirthInfo();
        other.setBirthDt("1992-03-20 00:00:00");
        other.setTz(8);
        NaksQry qry = new NaksQry();
        qry.setBirthInfo(self);
        qry.setOthersBirthInfo(Collections.singletonList(other));
        ApiResp<NaksVo> resp = client.naksRelations(qry);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
    }

    @Test
    void exampleReportRomantic() throws Exception {
        RomanticCreateQry qry = new RomanticCreateQry();
        qry.setUserBirthPoint(new TimeAndLocation("1990-01-01 13:14:15", 8, 116.4, 39.9));
        qry.setUserCurrentPoint(new TimeAndLocation("2025-11-26 13:14:15", 8, 116.4, 39.9));
        qry.setUserId("user-sync-demo");
        ApiResp<AstroReportVo> resp = client.reportRomantic(qry);
        assertEquals(0, resp.getCode(), "msg: " + resp.getMsg());
        assertNotNull(resp.getData());
        assertNotNull(resp.getData().getSerialNo());
    }
}
