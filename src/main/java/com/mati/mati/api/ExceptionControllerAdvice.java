package com.mati.mati.api;

import com.mati.mati.exception.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var result = ex.getBindingResult();
        List<String> errorList = new ArrayList<>();
        result.getFieldErrors()
                .forEach(fieldError -> errorList.add(fieldError.getField() + " [" + fieldError.getRejectedValue() + "] " + fieldError.getDefaultMessage()));
        result.getGlobalErrors()
                .forEach(fieldError -> errorList.add(fieldError.getObjectName() + " : " + fieldError.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(ApiErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).error(errorList.stream().sorted().toList().toString()).message("Coś").build());
    }
}
