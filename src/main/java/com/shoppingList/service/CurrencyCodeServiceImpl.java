package com.shoppingList.service;

import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCodeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.shoppingList.utils.XmlUtils.createJaxbContextWithUnmarshaller;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CurrencyCodeServiceImpl implements CurrencyCodeService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpEntity httpEntity;


    @Override
    public boolean validateCurrencyCode(String currencyCode) throws JAXBException {
        Objects.requireNonNull(currencyCode,"Currency code cannot be null");
        List<String> currencyCodes = getCurrenciesCode().getCurrencyTable().getCurrencyCodeDetails()
                .stream()
                .filter(x -> Objects.nonNull(x.getCcy()))
                .map(CurrencyCodeDetails::getCcy)
                .collect(Collectors.toList());

       return currencyCodes.stream().anyMatch(currencyCode.toUpperCase()::equals);

    }

    private CurrencyCode getCurrenciesCode() throws JAXBException {
        String xmlDocument =  restTemplate.exchange(URL, HttpMethod.GET,httpEntity, String.class).getBody();
        CurrencyCode currencyCode = (CurrencyCode) createJaxbContextWithUnmarshaller(CurrencyCode.class).unmarshal(new StringReader(xmlDocument));
        return currencyCode;
    }
}
