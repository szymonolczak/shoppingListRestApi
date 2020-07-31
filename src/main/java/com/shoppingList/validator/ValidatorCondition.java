package com.shoppingList.validator;

import com.shoppingList.model.ConstraintViolation;

import javax.xml.bind.JAXBException;
import java.util.Optional;

@FunctionalInterface
public interface ValidatorCondition<T> {

   Optional<ConstraintViolation> validate(T validateValue) throws JAXBException;
}
