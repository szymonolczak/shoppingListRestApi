package com.shoppingList.exception;


import com.shoppingList.model.exceptions.CurrencyViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({CurrencyViolationException.class})
    public ResponseEntity<?> handleCurrencyViolationException(CurrencyViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getConstraintViolation());
    }



}
