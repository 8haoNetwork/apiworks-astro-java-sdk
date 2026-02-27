package com.apiworks.astro.model.requests.chart;

import com.apiworks.astro.model.common.TimeAndLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 验证单点星盘请求 DTO 的 JSON 序列化与 API 约定一致。
 */
class SinglePointQryTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void serialization_usesSnakeCase() throws Exception {
        SinglePointQry qry = new SinglePointQry(new TimeAndLocation("1999-10-17 21:00:00", 8, 116.4, 39.9));
        qry.setZodiac("tropical");
        String json = mapper.writeValueAsString(qry);
        assertTrue(json.contains("birth_dt"));
        assertTrue(json.contains("tz"));
        assertTrue(json.contains("longitude"));
        assertTrue(json.contains("latitude"));
        assertTrue(json.contains("dst_auto"));
        assertTrue(json.contains("zodiac"));
        assertTrue(json.contains("bodies"));
    }

    @Test
    void deserialization_fromSnakeCase() throws Exception {
        String json = "{\"birth_dt\":\"2000-01-01 12:00:00\",\"tz\":8,\"longitude\":120.0,\"latitude\":30.0,\"dst_auto\":true,\"zodiac\":\"sidereal\"}";
        SinglePointQry qry = mapper.readValue(json, SinglePointQry.class);
        assertEquals("2000-01-01 12:00:00", qry.getBirthDt());
        assertEquals(8, qry.getTz());
        assertEquals(120.0, qry.getLongitude(), 1e-9);
        assertEquals(30.0, qry.getLatitude(), 1e-9);
        assertTrue(qry.isDstAuto());
        assertEquals("sidereal", qry.getZodiac());
    }

    @Test
    void constructorFromTimeAndLocation() {
        TimeAndLocation tl = new TimeAndLocation("1990-05-15 08:30:00", -5, -73.99, 40.71);
        SinglePointQry qry = new SinglePointQry(tl);
        assertEquals(tl.getBirthDt(), qry.getBirthDt());
        assertEquals(tl.getTz(), qry.getTz());
        assertEquals(tl.getLongitude(), qry.getLongitude(), 1e-9);
        assertEquals(tl.getLatitude(), qry.getLatitude(), 1e-9);
        assertEquals(tl.isDstAuto(), qry.isDstAuto());
    }
}
