package com.shoppingList.service;

import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

public interface CurrencyCodeService {

    public final String URL = "https://www.currency-iso.org/dam/downloads/lists/list_one.xml";

    public boolean validateCurrencyCode(String currencyCode) throws JAXBException;
}
