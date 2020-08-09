package com.shoppingList.validator;

import com.shoppingList.model.ConstraintViolation;
import com.shoppingList.model.ErrorCode;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCodeDetails;
import com.shoppingList.service.CurrencyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CurrencyCodeValidator implements ValidatorCondition<String> {

    @Autowired
    CurrencyCodeService currencyCodeService;

    @Override
    public Optional<ConstraintViolation> validate(String validateValue) throws JAXBException {

        ConstraintViolation constraintViolation = new ConstraintViolation();

            if(Objects.isNull(validateValue)) {
                constraintViolation.getViolations().add(ErrorCode.NULL_CURRENCY_CODE);
                return Optional.of(constraintViolation);
            }
             CurrencyCode currencyCodes = currencyCodeService.getCurrenciesCode();
        List<String> codes = currencyCodes.getCurrencyTable()
                    .getCurrencyCodeDetails()
                    .stream()
                    .filter(x -> Objects.nonNull(x.getCcy()))
                    .map(CurrencyCodeDetails::getCcy)
                    .collect(Collectors.toList());

        if(codes.stream().noneMatch(validateValue.toUpperCase()::equals)){
            constraintViolation.getViolations()
                               .add(ErrorCode.UNSUPPORTED_CURRENCY_CODE);
        }
        return Optional.of(constraintViolation);
    }
}
