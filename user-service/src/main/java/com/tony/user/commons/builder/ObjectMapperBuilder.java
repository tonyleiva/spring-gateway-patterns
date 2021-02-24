package com.tony.user.commons.builder;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class ObjectMapperBuilder {
	private final ObjectMapper mapper = new ObjectMapper();

	public static ObjectMapperBuilder create() {
		return new ObjectMapperBuilder();
	}

	public ObjectMapperBuilder() {
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		this.mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

//	public ObjectMapperBuilder withDateModule() {
//		SimpleModule dateModule = new SimpleModule("JSONDateModule", new Version(2, 0, 0, (String)null, (String)null, (String)null));
//		dateModule.addSerializer(LocalDate.class, new DateSerializer());
//		dateModule.addDeserializer(LocalDate.class, new DateDeserializer());
//		this.mapper.registerModule(dateModule);
//		return this;
//	}

//	public ObjectMapperBuilder withDateTimeModule() {
//		SimpleModule dateTimeModule = new SimpleModule("JSONDateTimeModule", new Version(2, 0, 0, (String)null, (String)null, (String)null));
//		dateTimeModule.addSerializer(ZonedDateTime.class, new DateTimeSerializer());
//		dateTimeModule.addDeserializer(ZonedDateTime.class, new DateTimeDeserializer());
//		this.mapper.registerModule(dateTimeModule);
//		return this;
//	}

	public ObjectMapper build() {
		return this.mapper;
	}
}
