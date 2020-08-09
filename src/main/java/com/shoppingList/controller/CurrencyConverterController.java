package com.shoppingList.controller;

import com.shoppingList.model.currency.CurrencyRate;
import com.shoppingList.model.exceptions.CurrencyViolationException;
import com.shoppingList.service.CurrencyControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;

@RestController("/currency")
public class CurrencyConverterController {

    @Autowired
    CurrencyControllerService currencyControllerService;

    @GetMapping("/getCurrency/{currencyName}")
    public CurrencyRate getCurrency(@PathVariable String currencyName) throws JAXBException, CurrencyViolationException {
        return currencyControllerService.getCurrency(currencyName);
    }

}
