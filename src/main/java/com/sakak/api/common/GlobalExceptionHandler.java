package com.sakak.api.common;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.sakak.api.common.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handle(
        IllegalArgumentException exception,
        HttpServletRequest request
    ) {
        log.warn(
            "{} = {} \n message = {}",
            request.getMethod(), request.getRequestURI(),
            exception.getMessage()
        );

        return ResponseEntity.status(BAD_REQUEST)
            .body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleServerException(Exception exception,
        HttpServletRequest request) {
        log.error(
            "Error {} = {} \n",
            request.getMethod(),
            request.getRequestURI(),
            exception
        );

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
    }

}
