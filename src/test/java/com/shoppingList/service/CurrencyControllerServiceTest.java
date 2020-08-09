package com.shoppingList.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingList.model.StaticStubData;
import com.shoppingList.model.currency.CurrencyRate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyControllerServiceTest {

    @Mock
    CurrencyControllerService currencyControllerService = mock(CurrencyControllerService.class);

    @Test
    public void should_Return_Currency_Rate() throws Exception {
        //given
        when(currencyControllerService.getCurrency("CHF")).thenReturn(prepareCurrencyMockData());

        //when
        CurrencyRate currencyRate = currencyControllerService.getCurrency("CHF");

        //then
        Assert.assertEquals("CHF", currencyRate.getCurrencyCode());

    }

    private CurrencyRate prepareCurrencyMockData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(StaticStubData.currencyConvertedSampleJson, CurrencyRate.class);

    }
}
