package com.kodilla.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Object> handleClientNotFoundException() {
        return new ResponseEntity<>("Client with given phone number doesn't exist",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientFoundInDatabaseException.class)
    public ResponseEntity<Object> handleClientFoundInDatabaseException() {
        return new ResponseEntity<>("Client with given phone number exists in database",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceTechnicianNotFoundException.class)
    public ResponseEntity<Object> handleServiceTechnicianNotFoundException() {
        return new ResponseEntity<>("Service technician with given id doesn't exist",
                HttpStatus.BAD_REQUEST);
    }
}
