package com.example.managestudent.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
