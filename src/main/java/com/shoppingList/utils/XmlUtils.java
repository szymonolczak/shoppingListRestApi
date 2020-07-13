package com.shoppingList.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlUtils {

    public static <T> Unmarshaller createJaxbContextWithUnmarshaller(Class<T> className) throws JAXBException {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(className);
        return jaxbContext.createUnmarshaller();
    }
}
