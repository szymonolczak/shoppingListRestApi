package com.shoppingList.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConstraintViolation {

    public List<String> violations;

    public ConstraintViolation(){

    }

    public List<String> getViolations() {
        if(Objects.isNull(violations)) {
            this.violations = new ArrayList<>();
            return this.violations;
        }
        return this.violations;
    }

    public void setViolations(List<String> violations) {
        this.violations = violations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstraintViolation that = (ConstraintViolation) o;
        return Objects.equals(violations, that.violations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(violations);
    }
}
