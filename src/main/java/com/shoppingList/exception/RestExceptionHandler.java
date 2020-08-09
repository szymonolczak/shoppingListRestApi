package com.shoppingList.exception;


import com.shoppingList.model.exceptions.CurrencyViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({CurrencyViolationException.class})
    public ResponseEntity<?> handleCurrencyViolationException(CurrencyViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getConstraintViolation());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<?> handleNotFoundException(HttpClientErrorException.NotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }




}
