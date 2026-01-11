package com.klima.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ProblemDetail handleRuntimeException(RuntimeException ex) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        problemDetail.setType(java.net.URI.create("https://www.rfc-editor.org/rfc/rfc9110#name-500-internal-server-error"));

        return problemDetail;
    }
}
