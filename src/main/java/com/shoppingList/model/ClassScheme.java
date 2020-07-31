package com.shoppingList.model;

public class ClassScheme {

    protected ConstraintViolation constraintViolation;

    public ClassScheme() {
    }

    public ClassScheme(ConstraintViolation constraintViolation) {
        this.constraintViolation = constraintViolation;
    }

    public ConstraintViolation getConstraintViolation() {
        return constraintViolation;
    }

    public void setConstraintViolation(ConstraintViolation constraintViolation) {
        this.constraintViolation = constraintViolation;
    }
}
