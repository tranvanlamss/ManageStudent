package com.javatechie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputInvalidException extends RuntimeException {
    String responseDesc;

    public InputInvalidException(String responseDesc) {
        this.responseDesc = responseDesc;
    }
    public String getResponseDesc() {
        return responseDesc;
    }

}
