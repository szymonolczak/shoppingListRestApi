package com.shoppingList.controller;


import com.shoppingList.model.currency.CurrencyRate;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCodeDetails;
import com.shoppingList.service.CurrencyCodeService;
import com.shoppingList.service.CurrencyControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController("/currency")
public class CurrencyConverterController {

    @Autowired
    CurrencyControllerService currencyControllerService;

    @Autowired
    CurrencyCodeService currencyCodeService;

    @GetMapping("/getCurrency/{currencyName}")
    public ResponseEntity<?> getCurrency(@PathVariable String currencyName) throws JAXBException {

        if(currencyCodeService.validateCurrencyCode(currencyName))
        {
            return ResponseEntity.ok(currencyControllerService.getCurrency(currencyName));
        }

        return ResponseEntity.badRequest().body("Validation error");
    }
}
