package com.shoppingList.utils;

import com.shoppingList.model.StaticStubData;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static com.shoppingList.utils.XmlUtils.createJaxbContextWithUnmarshaller;

public class UtilsTest {


    @Test
    public void xml_Utils_Should_Return_XML() throws Exception {
        CurrencyCode currencyCode = ((CurrencyCode) createJaxbContextWithUnmarshaller(CurrencyCode.class)
                .unmarshal(new StringReader(StaticStubData.avaibleCurrenciesSampleXml)));

        Assert.assertEquals("AFN", currencyCode.getCurrencyTable().getCurrencyCodeDetails().get(0).getCcy());
    }
}
