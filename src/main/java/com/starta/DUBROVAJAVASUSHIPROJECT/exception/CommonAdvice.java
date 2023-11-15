package com.starta.DUBROVAJAVASUSHIPROJECT.exception;

import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.EntityValidationException;
import com.starta.DUBROVAJAVASUSHIPROJECT.exception.exceptions.EmptyListException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<Response> handleException(EmptyListException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityValidationException.class)
    public ResponseEntity<Response> handleException(EntityValidationException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

