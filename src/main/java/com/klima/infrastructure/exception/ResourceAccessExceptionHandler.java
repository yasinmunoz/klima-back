package com.klima.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class ResourceAccessExceptionHandler {

    @ExceptionHandler({ResourceAccessException.class})
    public ProblemDetail handleResourceAccessException(ResourceAccessException ex) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage());
        problemDetail.setType(java.net.URI.create("https://www.rfc-editor.org/rfc/rfc9110#name-503-service-unavailable"));

        return problemDetail;
    }
}
