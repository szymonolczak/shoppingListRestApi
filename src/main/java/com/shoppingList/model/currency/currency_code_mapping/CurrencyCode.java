package com.shoppingList.model.currency.currency_code_mapping;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "ISO_4217")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyCode {

    @XmlElement(name = "CcyTbl")
    public CurrencyTable currencyTable;

    public CurrencyTable getCurrencyTable() {
        return currencyTable;
    }

    public void setCurrencyTable(CurrencyTable currencyTable) {
        this.currencyTable = currencyTable;
    }
}
