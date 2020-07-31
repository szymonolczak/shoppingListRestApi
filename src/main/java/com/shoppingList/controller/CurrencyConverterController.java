package com.shoppingList.controller;

import com.shoppingList.model.exceptions.CurrencyViolationException;
import com.shoppingList.service.CurrencyControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/currency")
public class CurrencyConverterController {

    @Autowired
    CurrencyControllerService currencyControllerService;

    @GetMapping("/getCurrency/{currencyName}")
    public ResponseEntity<?> getCurrency(@PathVariable String currencyName) throws JAXBException, CurrencyViolationException {
        final List<String> error = new ArrayList<>();

        return ResponseEntity.ok(currencyControllerService.getCurrency(currencyName));
    }

}
