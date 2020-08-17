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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class CurrencyCodeValidatorTest {

    @InjectMocks
    CurrencyCodeValidator currencyCodeValidator;

    @Mock
    CurrencyCodeService currencyCodeService;

    CurrencyCode currencyCode;

    @BeforeEach
    public void codeSetup() throws Exception {

        currencyCode = ((CurrencyCode) createJaxbContextWithUnmarshaller(CurrencyCode.class)
                .unmarshal(new StringReader(StaticStubData.avaibleCurrenciesSampleXml)));
    }

    @Test
    public void should_Validate_Null_Currency() throws JAXBException {
        //when
        Optional<ConstraintViolation> result = currencyCodeValidator.validate(null);

        //then
        Assert.assertEquals(ErrorCode.NULL_CURRENCY_CODE, result.get().getViolations().get(0));
    }

    @Test
    public void should_Validate_Existing_Currency() throws Exception {
        //given
        when(currencyCodeService.getCurrenciesCode()).thenReturn(currencyCode);

        //when
        Optional<ConstraintViolation> constraintViolation = currencyCodeValidator.validate("AFN");

        //then
         Assert.assertTrue(constraintViolation.get().getViolations().isEmpty());
    }

    @Test
    public void should_Return_Unsupported_Currency_Violation() throws Exception {
        //given
        when(currencyCodeService.getCurrenciesCode()).thenReturn(currencyCode);

        //when
        Optional<ConstraintViolation> constraintViolation = currencyCodeValidator.validate("XXX");

        //then
        Assert.assertEquals(ErrorCode.UNSUPPORTED_CURRENCY_CODE, constraintViolation.get().getViolations().get(0));
    }


}
