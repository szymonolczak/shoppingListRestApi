package com.shoppingList.model.currency.currency_code_mapping;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CcyTbl")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyTable {

    @XmlElement(name = "CcyNtry")
    public List<CurrencyCodeDetails> currencyCodeDetails;

    public List<CurrencyCodeDetails> getCurrencyCodeDetails() {
        return currencyCodeDetails;
    }

    public void setCurrencyCodeDetails(List<CurrencyCodeDetails> currencyCodeDetails) {
        this.currencyCodeDetails = currencyCodeDetails;
    }
}
