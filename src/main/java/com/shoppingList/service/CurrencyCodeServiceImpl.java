package com.shoppingList.service;

import com.shoppingList.model.ErrorCode;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.shoppingList.utils.XmlUtils.createJaxbContextWithUnmarshaller;

import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.Optional;

@Service
public class CurrencyCodeServiceImpl implements CurrencyCodeService {

    RestTemplate restTemplate;

    HttpEntity httpEntity;

    @Cacheable(cacheNames = "currencies_codes")
    @Scheduled(fixedDelay = 10000)
    public CurrencyCode getCurrenciesCode() throws JAXBException {
        CurrencyCode currencyCode = new CurrencyCode();
        Optional<String> xmlDocument = Optional.ofNullable(restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class)).map(HttpEntity::getBody);
        if (xmlDocument.isPresent()) {
            currencyCode = ((CurrencyCode) createJaxbContextWithUnmarshaller(CurrencyCode.class)
                    .unmarshal(new StringReader(xmlDocument.get())));
            return currencyCode;
        }
        currencyCode.getConstraintViolation()
                .getViolations()
                .add(ErrorCode.CANNOT_DOWNLOAD_ACTUAL_CURRENCIES);
        return currencyCode;
    }

    @Autowired
    public CurrencyCodeServiceImpl(HttpEntity httpEntity, RestTemplate restTemplate) {
        this.httpEntity = httpEntity;
        this.restTemplate = restTemplate;
    }
}
