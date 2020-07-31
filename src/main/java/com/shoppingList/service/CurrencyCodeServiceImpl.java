package com.shoppingList.service;

import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.shoppingList.utils.XmlUtils.createJaxbContextWithUnmarshaller;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

@Service
public class CurrencyCodeServiceImpl implements CurrencyCodeService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpEntity httpEntity;

    public CurrencyCode getCurrenciesCode() throws JAXBException {
        String xmlDocument =  restTemplate.exchange(URL, HttpMethod.GET,httpEntity, String.class).getBody();
        return (CurrencyCode) createJaxbContextWithUnmarshaller(CurrencyCode.class).unmarshal(new StringReader(xmlDocument));
    }
}
