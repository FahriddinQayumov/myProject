package com.example.repositoryy;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

public interface ControllerExceptionHandlerr {
    ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                        HttpHeaders headers, HttpStatusCodeException status,
                                                        WebRequest request);
}
