package com.javatechie.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javatechie.enumerate.ErrorCodesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {
    static final String SUCCESS = "SUCCESS";

    String responseCode;

    String responseDesc;

    Object result = null;

    Long totalElement = null;

    Integer size = null;

    Integer page = null;

    Long totalPage = null;
    LocalDateTime timestamp = LocalDateTime.now();


    public static MessageResponse ok(Object result) {
        MessageResponse res = new MessageResponse();
        res.setResponseCode(SUCCESS);
        res.setResult(result);
        return res;
    }


    public static MessageResponse empty() {
        MessageResponse res = new MessageResponse();
        res.setResponseCode(SUCCESS);
        res.setResult(new ArrayList<>());
        res.setResponseDesc("NO CONTENT");
        return res;
    }
    public static MessageResponse error(ErrorCodesEnum error) {
        MessageResponse res = new MessageResponse();
        res.setResponseCode(error.name());
        res.setResponseDesc(error.toString());
        return res;
    }
}
