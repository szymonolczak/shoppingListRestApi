package com.shoppingList.service;

import com.shoppingList.model.ConstraintViolation;
import com.shoppingList.model.currency.CurrencyRate;
import com.shoppingList.model.exceptions.CurrencyViolationException;
import com.shoppingList.validator.CurrencyCodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyControllerServiceImpl implements CurrencyControllerService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpEntity httpEntity;

    @Autowired
    CurrencyCodeService currencyCodeService;

    @Autowired
    CurrencyCodeValidator currencyCodeValidator;

    @Override
    public CurrencyRate getCurrency(String currencyName) throws JAXBException, CurrencyViolationException {

        List<String> error = new ArrayList<>();

        Optional<ConstraintViolation> errors = currencyCodeValidator.validate(currencyName);
        errors.ifPresent(constraintViolation -> error.addAll(constraintViolation.getViolations()));

        if(!error.isEmpty()){
            throw new CurrencyViolationException(error);
        }

        ResponseEntity<CurrencyRate> responseEntity = restTemplate.exchange(BASE_URL+"exchangerates/rates/a/"+currencyName,HttpMethod.GET, httpEntity, CurrencyRate.class);

        return responseEntity.getBody();
    }
}
