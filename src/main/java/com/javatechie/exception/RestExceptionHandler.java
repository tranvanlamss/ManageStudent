package com.javatechie.exception;

import com.javatechie.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(InputInvalidException.class)
    public ResponseEntity<Object> handlerInput(Exception ex){
        InputInvalidException inputInvalidException = (InputInvalidException) ex;
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setResponseDesc(inputInvalidException.getResponseDesc());
        messageResponse.setResponseCode("Input value exception");
        return ResponseEntity.badRequest().body(messageResponse);
    }
}
