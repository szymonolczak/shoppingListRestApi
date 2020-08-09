package com.shoppingList.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingList.model.StaticStubData;
import com.shoppingList.model.currency.CurrencyRate;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyConverterControllerTest {


    @Test
    public void should_Return_Chf_Currency() throws Exception {
        //given
        CurrencyConverterController currencyConverterController = mock(CurrencyConverterController.class);
        when(currencyConverterController.getCurrency("chf")).thenReturn(prepareCurrencyMockData());

        //when
        String currencyCode = currencyConverterController.getCurrency("chf").getCurrencyCode();

        //then
        Assert.assertThat(currencyCode, Matchers.is("CHF"));
    }

    private CurrencyRate prepareCurrencyMockData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(StaticStubData.currencyConvertedSampleJson, CurrencyRate.class);

    }
}
