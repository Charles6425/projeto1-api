package com.api.projeto1.controller.exception;

import com.api.projeto1.service.exception.DataIntegrityViolationException;
import com.api.projeto1.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ExceptonHandlerController {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException exception,
                                                                 ServletRequest request){
        StandartError error = new StandartError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandartError> dataIntegrityViolationException(DataIntegrityViolationException exception,
                                                                 ServletRequest request){
        StandartError error = new StandartError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
