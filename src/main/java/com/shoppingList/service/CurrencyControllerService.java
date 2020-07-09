package com.shoppingList.service;

import com.shoppingList.model.currency.CurrencyRate;

public interface CurrencyControllerService {

    final String BASE_URL = "http://api.nbp.pl/api/";

    public CurrencyRate getCurrency(String currencyName);
}
