package com.nsv.jsmbaba.controller;

import com.nsv.jsmbaba.domain.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(assignableTypes = {PersonController.class})
public class PersonControllerAdvice  {

    @ExceptionHandler(value={IllegalArgumentException.class})
    @ResponseBody
    public ResponseEntity<Object> handleError(RuntimeException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(HttpStatus.CONFLICT.toString());
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(200).body(errorResponse);
    }
}
