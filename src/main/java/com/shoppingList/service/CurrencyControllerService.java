package com.shoppingList.service;

import com.shoppingList.model.currency.CurrencyRate;
import com.shoppingList.model.exceptions.CurrencyViolationException;

import javax.xml.bind.JAXBException;

public interface CurrencyControllerService {

    final String BASE_URL = "http://api.nbp.pl/api/";

    public CurrencyRate getCurrency(String currencyName) throws JAXBException, CurrencyViolationException;
}
