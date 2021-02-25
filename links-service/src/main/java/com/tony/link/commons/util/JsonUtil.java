package com.tony.link.commons.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import com.tony.link.commons.builder.ObjectMapperBuilder;

public class JsonUtil {
	private static final ObjectMapper OBJECT_MAPPER = ObjectMapperBuilder.create().build();
//	private static final ObjectMapper OBJECT_MAPPER = ObjectMapperBuilder.create().withDateModule().withDateTimeModule().build();

	public JsonUtil() {
	}

	public static String toJson(final Object data) {
		try {
			return OBJECT_MAPPER.writeValueAsString(data);
		} catch (JsonProcessingException var2) {
			return "";
		}
	}

	public static Map<String, Object> fromJson(final String json) {
		return (Map)fromJson(json, Map.class);
	}

	public static <T> T fromJson(final String json, final Class<T> returnType) {
		try {
			return OBJECT_MAPPER.readValue(json, returnType);
		} catch (JsonProcessingException var3) {
			return null;
		}
	}
}
