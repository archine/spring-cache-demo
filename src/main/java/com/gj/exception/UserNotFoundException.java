package com.gj.exception;

import cn.gjing.result.ErrorResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Gjing
 **/
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}

/**
 * @author Gjing
 **/
@RestControllerAdvice
class DemoExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNot(UserNotFoundException e) {
        return ResponseEntity.badRequest().body(ErrorResult.error(e.getMessage()));
    }
}
