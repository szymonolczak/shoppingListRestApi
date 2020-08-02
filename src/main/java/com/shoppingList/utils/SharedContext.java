package com.shoppingList.utils;

import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import org.springframework.stereotype.Component;


@Component
public class SharedContext {

    private CurrencyCode currencyCode;

    private SharedContext(){

    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }
}
