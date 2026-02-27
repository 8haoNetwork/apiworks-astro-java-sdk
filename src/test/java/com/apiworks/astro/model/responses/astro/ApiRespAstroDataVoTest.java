package com.apiworks.astro.model.responses.astro;

import com.apiworks.astro.model.common.ApiResp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 验证本命盘等接口返回的 {@code ApiResp<AstroDataVo>} 能正确反序列化。
 */
class ApiRespAstroDataVoTest {

    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Test
    void deserialize_chartNatalLikeResponse() throws Exception {
        String json = "{\"code\":0,\"msg\":\"ok\",\"exe_time\":0.15,\"data\":{"
                + "\"sign\":[],\"planet\":[],\"house\":[],\"svg\":\"<svg/>\"}}";
        ApiResp<AstroDataVo> resp = mapper.readValue(json, new TypeReference<ApiResp<AstroDataVo>>() {});
        assertEquals(0, resp.getCode());
        assertEquals(0.15, resp.getExeTime(), 1e-9);
        AstroDataVo data = resp.getData();
        assertNotNull(data);
        assertNotNull(data.getSign());
        assertNotNull(data.getPlanet());
        assertNotNull(data.getHouse());
        assertEquals("<svg/>", data.getSvg());
    }

    @Test
    void deserialize_ignoresUnknownFields() throws Exception {
        String json = "{\"code\":0,\"msg\":\"\",\"data\":{\"planet\":[],\"extra_field\":123},\"exe_time\":0}";
        ApiResp<AstroDataVo> resp = mapper.readValue(json, new TypeReference<ApiResp<AstroDataVo>>() {});
        assertEquals(0, resp.getCode());
        assertNotNull(resp.getData());
    }
}
