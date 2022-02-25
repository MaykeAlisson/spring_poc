package br.com.mayke.studyspring.controller;

import br.com.mayke.studyspring.exceptions.BadRequestException;
import br.com.mayke.studyspring.exceptions.BussinesException;
import br.com.mayke.studyspring.exceptions.ResourceNotFoundException;
import br.com.mayke.studyspring.exceptions.StandardError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResoucerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource nou found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(BussinesException.class)
    public ResponseEntity<StandardError> resourceBussinesException(BussinesException e, HttpServletRequest request) {
        String error = "Bussines exception";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> resourceBussinesException(BadRequestException e, HttpServletRequest request) {
        String error = "BadRequest exception";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
