package com.apiworks.astro.model.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 验证 {@link TimeAndLocation} 的 JSON 与 API 约定一致（snake_case 等）。
 */
class TimeAndLocationTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void serialization_usesSnakeCase() throws Exception {
        TimeAndLocation tl = new TimeAndLocation("1999-10-17 21:00:00", 8, 116.4, 39.9);
        tl.setDstAuto(true);
        String json = mapper.writeValueAsString(tl);
        assertEquals(-1, json.indexOf("birthDt"));
        assertTrue(json.contains("birth_dt"));
        assertTrue(json.contains("tz"));
        assertTrue(json.contains("longitude"));
        assertTrue(json.contains("latitude"));
        assertTrue(json.contains("dst_auto"));
    }

    @Test
    void deserialization_fromSnakeCase() throws Exception {
        String json = "{\"birth_dt\":\"2000-01-01 12:00:00\",\"tz\":8,\"longitude\":120.0,\"latitude\":30.0,\"dst_auto\":true}";
        TimeAndLocation tl = mapper.readValue(json, TimeAndLocation.class);
        assertEquals("2000-01-01 12:00:00", tl.getBirthDt());
        assertEquals(8, tl.getTz());
        assertEquals(120.0, tl.getLongitude(), 1e-9);
        assertEquals(30.0, tl.getLatitude(), 1e-9);
        assertTrue(tl.isDstAuto());
    }

    @Test
    void roundTrip() throws Exception {
        TimeAndLocation tl = new TimeAndLocation("1990-05-15 08:30:00", -5, -73.99, 40.71);
        String json = mapper.writeValueAsString(tl);
        TimeAndLocation restored = mapper.readValue(json, TimeAndLocation.class);
        assertEquals(tl.getBirthDt(), restored.getBirthDt());
        assertEquals(tl.getTz(), restored.getTz());
        assertEquals(tl.getLongitude(), restored.getLongitude(), 1e-9);
        assertEquals(tl.getLatitude(), restored.getLatitude(), 1e-9);
        assertEquals(tl.isDstAuto(), restored.isDstAuto());
    }
}
