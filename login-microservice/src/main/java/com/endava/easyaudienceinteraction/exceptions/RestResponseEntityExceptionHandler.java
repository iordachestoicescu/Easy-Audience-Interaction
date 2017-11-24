package com.endava.easyaudienceinteraction.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Laurentiu Iordache
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AdminNotFoundException.class)
    protected ResponseEntity<Object> adminNotFound(AdminNotFoundException ex, WebRequest request){
        String bodyOfResponse = "Specified admin does not exist!";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(value = WrongPasswordException.class)
    protected ResponseEntity<Object> wrongPassword(WrongPasswordException ex, WebRequest request){
        String bodyOfResponse = "Wrong password!";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
