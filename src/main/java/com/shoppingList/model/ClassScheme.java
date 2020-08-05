package com.shoppingList.model;

import javax.xml.bind.annotation.XmlTransient;

public class ClassScheme {

    @XmlTransient
    public ConstraintViolation constraintViolation;

    public ClassScheme() {
    }

    public ClassScheme(ConstraintViolation constraintViolation) {
        this.constraintViolation = constraintViolation;
    }

    public ConstraintViolation getConstraintViolation() {
        return this.constraintViolation;
    }

    public void setConstraintViolation(ConstraintViolation constraintViolation) {
        this.constraintViolation = constraintViolation;
    }
}
