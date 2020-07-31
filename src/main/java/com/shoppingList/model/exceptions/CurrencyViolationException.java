package com.shoppingList.model.exceptions;

import com.shoppingList.model.ConstraintViolation;

import java.util.List;

public class CurrencyViolationException extends Exception {
    private List<String> constraintViolations;

    public CurrencyViolationException(List<String> constraintViolations){
        this.constraintViolations = constraintViolations;
    }

    public List<String> getConstraintViolation() {
        return constraintViolations;
    }

    public void setConstraintViolation(List<String> constraintViolation) {
        this.constraintViolations = constraintViolation;
    }
}
