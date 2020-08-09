package com.shoppingList.validator;


import com.shoppingList.model.ConstraintViolation;
import com.shoppingList.model.ErrorCode;
import com.shoppingList.model.StaticStubData;
import com.shoppingList.model.currency.currency_code_mapping.CurrencyCode;
import com.shoppingList.service.CurrencyCodeService;
import static com.shoppingList.utils.XmlUtils.createJaxbContextWithUnmarshaller;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;


import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.Optional;

public class CurrencyCodeValidatorTest {

    CurrencyCodeValidator currencyCodeValidator;


    @Mock
    CurrencyCodeService currencyCodeService = mock(CurrencyCodeService.class);

    CurrencyCode currencyCode;

    @BeforeEach
    public void codeSetup() throws Exception {
        currencyCodeValidator = new CurrencyCodeValidator();

        currencyCode = ((CurrencyCode) createJaxbContextWithUnmarshaller(CurrencyCode.class)
                .unmarshal(new StringReader(StaticStubData.avaibleCurrenciesSampleXml)));
    }

    @Test
    public void should_Validate_Null_Currency() throws JAXBException {
        //when
        Optional<ConstraintViolation> result = currencyCodeValidator.validate(null);

        //then
        result.ifPresent(x -> Assert.assertEquals(ErrorCode.NULL_CURRENCY_CODE, x.getViolations().get(0)));
    }

    @Test
    public void should_Validate_Existing_Currency() throws Exception {
        //given
        when(currencyCodeService.getCurrenciesCode()).thenReturn(currencyCode);
        ReflectionTestUtils.setField(currencyCodeValidator, "currencyCodeService", currencyCodeService);

        //when
        Optional<ConstraintViolation> constraintViolation = currencyCodeValidator.validate("AFN");

        //then
        constraintViolation.ifPresent(violation -> Assert.assertTrue(violation.getViolations().isEmpty()));
    }

    @Test
    public void should_Return_Unsupported_Currency_Violation() throws Exception {
        //given
        when(currencyCodeService.getCurrenciesCode()).thenReturn(currencyCode);
        ReflectionTestUtils.setField(currencyCodeValidator, "currencyCodeService", currencyCodeService);

        //when
        Optional<ConstraintViolation> constraintViolation = currencyCodeValidator.validate("XXX");

        //then
        constraintViolation.ifPresent(violations -> Assert.assertEquals(ErrorCode.UNSUPPORTED_CURRENCY_CODE, violations.getViolations().get(0)));
    }


}
