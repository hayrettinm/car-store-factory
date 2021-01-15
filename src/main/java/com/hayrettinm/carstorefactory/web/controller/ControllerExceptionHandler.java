package com.hayrettinm.carstorefactory.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException ex){
        List<String> errors = new ArrayList<>(ex.getConstraintViolations().size());
        ex.getConstraintViolations().forEach(cv -> {
            errors.add(cv.getPropertyPath() + " : " + cv.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List>  handleBindException(BindException bex){
        return new ResponseEntity(bex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
