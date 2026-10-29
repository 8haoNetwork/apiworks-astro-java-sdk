package com.apiworks.astro;

import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.common.TimeAndLocation;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.requests.qizheng.QizhengNatalQry;
import com.apiworks.astro.model.requests.sanshi.QimenQry;
import com.apiworks.astro.model.requests.sign.SignQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;
import com.apiworks.astro.model.responses.qizheng.QizhengNatalVo;
import com.apiworks.astro.model.responses.sanshi.QimenResultVo;
import com.apiworks.astro.model.responses.sign.MySignRespVo;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 使用 MockWebServer 验证客户端请求路径、请求头、请求体及响应解析是否正确。
 * 不依赖真实 API 与密钥。
 */
class AstroCloudClientTest {

    private MockWebServer server;
    private AstroCloudClient client;
    private String baseUrl;

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
        baseUrl = server.url("").toString();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }
        client = new AstroCloudClient("test-app-id", "test-app-key", baseUrl, 5_000);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (server != null) {
            server.shutdown();
        }
    }

    @Test
    void chartNatal_sendsCorrectPathAndHeaders() throws Exception {
        server.enqueue(new MockResponse()
                .setBody("{\"code\":0,\"msg\":\"ok\",\"data\":{\"sign\":[],\"planet\":[],\"house\":[]},\"exe_time\":0.1}")
                .addHeader("Content-Type", "application/json"));

        SinglePointQry qry = new SinglePointQry();
        qry.setBirthDt("1999-10-17 21:00:00");
        qry.setTz(8);
        qry.setLongitude(116.4);
        qry.setLatitude(39.9);

        ApiResp<AstroDataVo> resp = client.chartNatal(qry);

        RecordedRequest request = server.takeRequest(2, TimeUnit.SECONDS);
        assertNotNull(request);
        assertEquals("POST", request.getMethod());
        assertEquals("/chart/natal", request.getPath());
        assertEquals("test-app-id", request.getHeader("X-App-Id"));
        assertEquals("test-app-key", request.getHeader("X-App-Key"));
        String bodyStr = request.getBody().readUtf8();
        assertTrue(bodyStr.contains("birth_dt"));
        assertTrue(bodyStr.contains("1999-10-17 21:00:00"));
    }

    @Test
    void chartNatal_parsesResponseCorrectly() throws Exception {
        server.enqueue(new MockResponse()
                .setBody("{\"code\":0,\"msg\":\"success\",\"data\":{\"sign\":[],\"planet\":[],\"house\":[],\"svg\":\"<svg />\"},\"exe_time\":0.2}")
                .addHeader("Content-Type", "application/json"));

        SinglePointQry qry = new SinglePointQry();
        qry.setBirthDt("2000-01-01 12:00:00");
        qry.setTz(8);
        qry.setLongitude(120);
        qry.setLatitude(30);

        ApiResp<AstroDataVo> resp = client.chartNatal(qry);

        assertEquals(0, resp.getCode());
        assertEquals("success", resp.getMsg());
        assertEquals(0.2, resp.getExeTime(), 1e-9);
        assertNotNull(resp.getData());
        assertEquals("<svg />", resp.getData().getSvg());
    }

    @Test
    void chartNatal_includesLangInBody() throws Exception {
        server.enqueue(new MockResponse()
                .setBody("{\"code\":0,\"msg\":\"ok\",\"data\":{},\"exe_time\":0.1}")
                .addHeader("Content-Type", "application/json"));

        SinglePointQry qry = new SinglePointQry();
        qry.setBirthDt("1999-10-17 21:00:00");
        qry.setLang("en");

        client.chartNatal(qry);

        RecordedRequest request = server.takeRequest(2, TimeUnit.SECONDS);
        assertNotNull(request);
        String bodyStr = request.getBody().readUtf8();
        assertTrue(bodyStr.contains("\"lang\""));
        assertTrue(bodyStr.contains("en"));
    }

    @Test
    void mySign_sendsBodyAndSignsList_passesLangQuery() throws Exception {
        server.enqueue(new MockResponse()
                .setBody("{\"code\":0,\"msg\":\"ok\",\"data\":{},\"exe_time\":0.1}")
                .addHeader("Content-Type", "application/json"));
        server.enqueue(new MockResponse()
                .setBody("{\"code\":0,\"msg\":\"ok\",\"data\":[],\"exe_time\":0.1}")
                .addHeader("Content-Type", "application/json"));

        SignQry signQry = new SignQry(new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4, 39.9), "zh-Hant");
        ApiResp<MySignRespVo> mySignResp = client.mySign("u1", signQry);
        assertEquals(0, mySignResp.getCode());

        RecordedRequest mySignReq = server.takeRequest(2, TimeUnit.SECONDS);
        assertNotNull(mySignReq);
        assertEquals("POST", mySignReq.getMethod());
        assertEquals("/mySign/u1", mySignReq.getPath());
        assertTrue(mySignReq.getBody().readUtf8().contains("zh-Hant"));

        client.signsList("en");
        RecordedRequest signsReq = server.takeRequest(2, TimeUnit.SECONDS);
        assertNotNull(signsReq);
        assertEquals("GET", signsReq.getMethod());
        assertEquals("/signs?lang=en", signsReq.getPath());
    }

    @Test
    void qimen_sendsCorrectPathAndParsesResponse() throws Exception {
        server.enqueue(new MockResponse()
                .setBody("{\"code\":0,\"msg\":\"ok\",\"data\":{\"input_time\":\"1999-10-17 21:00:00\",\"lunar\":\"己卯\",\"pai_fa\":{\"digest\":\"d\",\"qiju_type\":\"时家\",\"pai_method\":\"转盘\"},\"type\":\"shijia\",\"pai_method\":\"zhuanpan\",\"jie_qi_prev\":{\"name\":\"寒露\",\"jiaojie_local\":\"1999-10-08\"},\"jie_qi_next\":{\"name\":\"霜降\",\"jiaojie_local\":\"1999-10-24\"},\"year_pillar\":{\"label\":\"己卯年\",\"kong_wang\":\"申酉\"},\"month_pillar\":{\"label\":\"甲戌月\",\"kong_wang\":\"申酉\"},\"day_pillar\":{\"label\":\"乙酉日\",\"kong_wang\":\"午未\"},\"year_gan_zhi\":\"己卯\",\"month_gan_zhi\":\"甲戌\",\"day_gan_zhi\":\"乙酉\",\"pan_variant\":\"shijia_chaibu\",\"yin_yang\":\"yang\",\"ju_display\":\"阳遁一局\",\"solar_term\":\"寒露\",\"special_patterns\":[],\"jiu_gong\":{}},\"exe_time\":0.1}")
                .addHeader("Content-Type", "application/json"));

        QimenQry qry = new QimenQry();
        qry.setQryDt("1999-10-17 21:00:00");
        qry.setType("shijia");
        qry.setPaiMethod("zhuanpan");
        qry.setJuMethod("chaibu");

        ApiResp<QimenResultVo> resp = client.qimen(qry);

        RecordedRequest request = server.takeRequest(2, TimeUnit.SECONDS);
        assertNotNull(request);
        assertEquals("POST", request.getMethod());
        assertEquals("/qimen", request.getPath());
        assertEquals(0, resp.getCode());
        assertNotNull(resp.getData());
        assertEquals("阳遁一局", resp.getData().getJuDisplay());
        assertEquals("shijia", resp.getData().getType());
    }

    @Test
    void zhengyuNatal_sendsCorrectPathAndParsesResponse() throws Exception {
        server.enqueue(new MockResponse()
                .setBody("{\"code\":0,\"msg\":\"ok\",\"data\":{\"gender\":\"male\",\"birth_dt\":\"1990-08-14 12:00:00\",\"solar_dt\":\"1990-08-14 12:00:00\",\"basic\":{\"pillars\":{\"year\":{\"stem\":\"geng\",\"branch\":\"wu\",\"gan_zhi\":\"庚午\"},\"month\":{\"stem\":\"jia\",\"branch\":\"shen\",\"gan_zhi\":\"甲申\"},\"day\":{\"stem\":\"bing\",\"branch\":\"yin\",\"gan_zhi\":\"丙寅\"},\"hour\":{\"stem\":\"yi\",\"branch\":\"wei\",\"gan_zhi\":\"乙未\"}},\"is_day\":true,\"grace\":{\"degree\":{\"self_wx\":\"fire\",\"grace\":\"wood\",\"useful\":\"earth\",\"foe\":\"water\",\"hardship\":\"metal\"},\"palace\":{\"self_wx\":\"fire\",\"grace\":\"wood\",\"useful\":\"earth\",\"foe\":\"water\",\"hardship\":\"metal\"}},\"shen\":{\"palace_degree\":10.0,\"xiu\":\"jiao\",\"xiu_degree\":1.0,\"earthly_branch\":\"zi\"},\"tong_xian_span\":{\"years\":1,\"months\":0,\"days\":0,\"exit_date\":\"1991-08-14\"}},\"ming\":{\"palace_degree\":10.0,\"xiu\":\"jiao\",\"xiu_degree\":1.0,\"lord\":\"sun\"},\"stars\":[],\"palaces\":[]},\"exe_time\":0.1}")
                .addHeader("Content-Type", "application/json"));

        QizhengNatalQry qry = new QizhengNatalQry();
        qry.setBirthDt("1990-08-14 12:00:00");
        qry.setGender("male");

        ApiResp<QizhengNatalVo> resp = client.zhengyuNatal(qry);

        RecordedRequest request = server.takeRequest(2, TimeUnit.SECONDS);
        assertNotNull(request);
        assertEquals("POST", request.getMethod());
        assertEquals("/zhengyu/natal", request.getPath());
        assertTrue(request.getBody().readUtf8().contains("birth_dt"));
        assertEquals(0, resp.getCode());
        assertNotNull(resp.getData());
        assertEquals("male", resp.getData().getGender());
        assertEquals("1990-08-14 12:00:00", resp.getData().getBirthDt());
    }
}
