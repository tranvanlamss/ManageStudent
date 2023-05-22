package com.javatechie.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;

public class GsonMultipartFileRegister implements JsonSerializer<MultipartFile> {

    public JsonElement serialize(MultipartFile file, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(file.getName()
                + "|" + file.getOriginalFilename()
                + "|" + file.getContentType()
                + "|" + file.getSize());
    }

}
