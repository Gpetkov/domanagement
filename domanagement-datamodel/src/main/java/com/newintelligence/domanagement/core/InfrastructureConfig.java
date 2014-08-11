package com.newintelligence.domanagement.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class InfrastructureConfig {
    /**
     * Defines current date format that conforms to ISO-8601 date formatting
     * standard, when it includes basic undecorated timezone definition without
     * ms
     */
    public final static String DATE_FORMAT_STR_ISO8601 = "yyyy-MM-dd'T'HH:mm:ssZ";

    /**
     * Default timezone - GMT
     */
    private final static TimeZone DEFAULT_TIMEZONE;
    static {
	DEFAULT_TIMEZONE = TimeZone.getTimeZone("GMT");
    }

    /**
     * Default date formatter
     */
    protected final static DateFormat DATE_FORMAT_ISO8601;
    static {
	DATE_FORMAT_ISO8601 = new SimpleDateFormat(DATE_FORMAT_STR_ISO8601);
	DATE_FORMAT_ISO8601.setTimeZone(DEFAULT_TIMEZONE);
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
	MethodInvokingFactoryBean mifb = new MethodInvokingFactoryBean();
	return mifb;
    }

    @Bean
    public ObjectMapper objectMapper() {
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.setDateFormat(DATE_FORMAT_ISO8601);

	return objectMapper;
    }

}
