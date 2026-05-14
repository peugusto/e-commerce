package io.github.peugusto.despapelar.infra;

import io.github.peugusto.despapelar.exception.BusinessException;
import io.github.peugusto.despapelar.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<RestErrorMessage> resourceNotFoundHandler(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RestErrorMessage(e.getMessage(), OffsetDateTime.now()));
    }
    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<RestErrorMessage> businessException(BusinessException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new RestErrorMessage(e.getMessage(), OffsetDateTime.now()));
    }
}
