package com.shoppingList.model.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoppingList.model.ClassScheme;

import java.io.Serializable;
import java.util.List;

public class CurrencyRate extends ClassScheme implements Serializable {

    String table;

    @JsonProperty("currency")
    String currencyName;

    @JsonProperty("code")
    String currencyCode;

    List<Rate> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
