package com.report.demo.utils;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.report.demo.exceptions.WeatherAppException;

public class ServiceUtils {

	private static ObjectMapper mapper = new ObjectMapper();

	public static <T> T convertJsonToObj(String json, Class<T> objType) throws WeatherAppException {
		try {
			return mapper.readValue(json, objType);
		} catch (IOException e) {
			throw new WeatherAppException(503,"Illegal request paramaters are passed: " + e.getMessage());
		}
	}

	public static String convertObjToJson(Object obj) throws WeatherAppException {
		if (obj instanceof String) {
			return (String) obj;
		}

		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new WeatherAppException(503,"Illegal request paramaters are passed: " + e.getMessage());
		}
	}

}
