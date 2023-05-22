package com.javatechie.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

public final class JsonUtil {

	public static String toString(Object object) {
		if(object == null){
			return null;
		}
		try {
			Gson gson = new GsonBuilder()
					.setPrettyPrinting()
					.registerTypeAdapter(LocalDate.class, new GsonLocalDateRegister())
					.registerTypeAdapter(MultipartFile.class, new GsonMultipartFileRegister())
					.create();
			return gson.toJson(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cant not convert object to json string";
	}

	public static <S extends Object> S from(byte[] json, final Class<S> clazz) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		S obj = null;
		try {
			obj = objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			return new Gson().fromJson(String.valueOf(json), clazz);
		} catch (Exception e) {
			return null;
		}
		return obj;
	}

	public static <S extends Object> S from(String json, final Class<S> clazz) {
		try {
			return new Gson().fromJson(json, clazz);
		} catch (Exception e) {
			return null;
		}
	}
}
