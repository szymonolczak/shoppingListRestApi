package com.shoppingList.model.currency.currency_code_mapping;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CcyNtr")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyCodeDetails {

    @XmlElement(name = "CtryNm")
    String CtryNm;

    @XmlElement(name = "CcyNm")
    String CcyNm;

    @XmlElement(name = "Ccy")
    String Ccy;

    @XmlElement(name = "CcyNbr")
    String CcyNbr;

    @XmlElement(name = "CcyMnrUnts")
    String CcyMnrUnts;


    public String getCtryNm() {
        return CtryNm;
    }

    public void setCtryNm(String ctryNm) {
        CtryNm = ctryNm;
    }


    public String getCcyNm() {
        return CcyNm;
    }

    public void setCcyNm(String ccyNm) {
        CcyNm = ccyNm;
    }


    public String getCcy() {
        return Ccy;
    }

    public void setCcy(String ccy) {
        Ccy = ccy;
    }


    public String getCcyNbr() {
        return CcyNbr;
    }

    public void setCcyNbr(String ccyNbr) {
        CcyNbr = ccyNbr;
    }


    public String getCcyMnrUnts() {
        return CcyMnrUnts;
    }

    public void setCcyMnrUnts(String ccyMnrUnts) {
        CcyMnrUnts = ccyMnrUnts;
    }

    @Override
    public String toString() {
        return "CurrencyCodeDetails{" +
                "CtryNm='" + CtryNm + '\'' +
                ", CcyNm='" + CcyNm + '\'' +
                ", Ccy='" + Ccy + '\'' +
                ", CcyNbr='" + CcyNbr + '\'' +
                ", CcyMnrUnts='" + CcyMnrUnts + '\'' +
                '}';
    }
}
