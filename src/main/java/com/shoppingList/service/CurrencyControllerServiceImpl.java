package com.shoppingList.service;

import com.shoppingList.model.currency.CurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyControllerServiceImpl implements CurrencyControllerService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpEntity httpEntity;

    @Override
    public CurrencyRate getCurrency(String currencyName) {
        ResponseEntity<CurrencyRate> responseEntity = restTemplate.exchange(BASE_URL+"exchangerates/rates/a/"+currencyName,HttpMethod.GET, httpEntity, CurrencyRate.class);

        return responseEntity.getBody();
    }
}
