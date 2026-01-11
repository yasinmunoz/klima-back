package com.klima.infrastructure.exception;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URI;

@RestControllerAdvice
public class HttpClientErrorExceptionHandler {

    @ExceptionHandler({HttpClientErrorException.class})
    public ProblemDetail handleHttpClientError(HttpServletRequest request, HttpClientErrorException ex) {

        return switch (ex.getStatusCode()) {
            case HttpStatus.TOO_MANY_REQUESTS ->
                    createProblemDetail(
                            ex.getStatusCode(),
                            ex.getStatusText(),
                            "https://datatracker.ietf.org/doc/html/rfc6585#section-4"
                    );

            case HttpStatus.BAD_REQUEST ->
                    createProblemDetail(
                            ex.getStatusCode(),
                            ex.getStatusText(),
                            "https://www.rfc-editor.org/rfc/rfc9110#name-400-bad-request"
                    );

            case HttpStatus.FORBIDDEN ->
                 createProblemDetail(
                         ex.getStatusCode(),
                         ex.getStatusText(),
                         "https://www.rfc-editor.org/rfc/rfc9110#name-403-forbidden"
                 );

            case HttpStatus.UNAUTHORIZED ->
                    createProblemDetail(
                            ex.getStatusCode(),
                            ex.getStatusText(),
                            "https://www.rfc-editor.org/rfc/rfc9110#name-401-unauthorized"
                    );

            case HttpStatus.NOT_FOUND ->
                createProblemDetail(
                        ex.getStatusCode(),
                        ex.getStatusText(),
                        "https://www.rfc-editor.org/rfc/rfc9110#name-404-not-found"
                );

            default -> ProblemDetail.forStatusAndDetail(ex.getStatusCode(), ex.getStatusText());
        };
    }

    private ProblemDetail createProblemDetail(HttpStatusCode status, String detail, String typeUri) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, detail);
        problemDetail.setType(URI.create(typeUri));
        return problemDetail;
    }
}