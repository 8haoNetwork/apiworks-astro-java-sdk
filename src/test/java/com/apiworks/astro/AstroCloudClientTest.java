package com.apiworks.astro;

import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;
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
}
