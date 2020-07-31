package com.shoppingList.service;

import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;

import javax.xml.bind.JAXBException;

public interface CurrencyCodeService {

    String URL = "https://www.currency-iso.org/dam/downloads/lists/list_one.xml";

    CurrencyCode getCurrenciesCode() throws JAXBException;
}
