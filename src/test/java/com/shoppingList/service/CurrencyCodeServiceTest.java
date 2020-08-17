package com.shoppingList.service;

import static com.shoppingList.service.CurrencyCodeService.URL;
import static org.mockito.Mockito.when;

import com.shoppingList.model.ErrorCode;
import com.shoppingList.model.StaticStubData;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
public class CurrencyCodeServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Mock
    HttpEntity httpEntity;

    @InjectMocks
    CurrencyCodeServiceImpl currencyCodeService;

    @Test
    public void should_Return_Cannot_Download_Currency() throws Exception {
        //given
        when(restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class)).thenReturn(null);

        //when
        CurrencyCode currencyCode = currencyCodeService.getCurrenciesCode();

        //then
        Assert.assertEquals(ErrorCode.CANNOT_DOWNLOAD_ACTUAL_CURRENCIES, currencyCode.constraintViolation.getViolations().get(0));
    }

    @Test
    public void should_Return_Currencies() throws Exception {
        //given
        when(restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class)).thenReturn(ResponseEntity.ok(StaticStubData.avaibleCurrenciesSampleXml));

        //when
        CurrencyCode currencyCode = currencyCodeService.getCurrenciesCode();

        //then
        Assert.assertEquals("AFN", currencyCode.getCurrencyTable().getCurrencyCodeDetails().get(0).getCcy());
    }


}
