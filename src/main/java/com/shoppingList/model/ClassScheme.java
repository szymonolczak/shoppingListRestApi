package com.shoppingList.model;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Objects;

public class ClassScheme {

    @XmlTransient
    public ConstraintViolation constraintViolation;

    public ClassScheme() {
    }

    public ClassScheme(ConstraintViolation constraintViolation) {
        this.constraintViolation = constraintViolation;
    }

    public ConstraintViolation getConstraintViolation() {
        if(Objects.isNull(this.constraintViolation)) {
            this.constraintViolation = new ConstraintViolation();
            return this.constraintViolation;
        }
        return this.constraintViolation;
    }

    public void setConstraintViolation(ConstraintViolation constraintViolation) {
        this.constraintViolation = constraintViolation;
    }
}
