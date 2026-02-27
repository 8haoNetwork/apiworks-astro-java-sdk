package com.apiworks.astro.model.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 验证 {@link ApiResp} 的 JSON 序列化/反序列化与 API 约定一致。
 */
class ApiRespTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void roundTrip_primitiveData() throws Exception {
        String json = "{\"code\":0,\"msg\":\"ok\",\"data\":\"hello\",\"exe_time\":0.12}";
        ApiResp<String> parsed = mapper.readValue(json, new TypeReference<ApiResp<String>>() {});
        assertEquals(0, parsed.getCode());
        assertEquals("ok", parsed.getMsg());
        assertEquals("hello", parsed.getData());
        assertEquals(0.12, parsed.getExeTime(), 1e-9);

        String serialized = mapper.writeValueAsString(parsed);
        ApiResp<String> again = mapper.readValue(serialized, new TypeReference<ApiResp<String>>() {});
        assertEquals(parsed.getCode(), again.getCode());
        assertEquals(parsed.getMsg(), again.getMsg());
        assertEquals(parsed.getData(), again.getData());
    }

    @Test
    void roundTrip_objectData() throws Exception {
        String json = "{\"code\":0,\"msg\":\"\",\"data\":{\"a\":1,\"b\":\"x\"},\"exe_time\":0}";
        ApiResp<java.util.Map<String, Object>> parsed = mapper.readValue(json,
                new TypeReference<ApiResp<java.util.Map<String, Object>>>() {});
        assertEquals(0, parsed.getCode());
        assertNotNull(parsed.getData());
        assertEquals(1, parsed.getData().get("a"));
        assertEquals("x", parsed.getData().get("b"));
    }

    @Test
    void deserialize_usesSnakeCase_exeTime() throws Exception {
        String json = "{\"code\":1,\"msg\":\"error\",\"data\":null,\"exe_time\":1.5}";
        ApiResp<Object> parsed = mapper.readValue(json, new TypeReference<ApiResp<Object>>() {});
        assertEquals(1, parsed.getCode());
        assertEquals(1.5, parsed.getExeTime(), 1e-9);
    }
}
