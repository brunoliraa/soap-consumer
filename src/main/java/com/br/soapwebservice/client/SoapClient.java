package com.br.soapwebservice.client;

import com.br.soapwebservice.soap.CalcPrecoPrazo;
import com.br.soapwebservice.soap.CalcPrecoPrazoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class SoapClient extends WebServiceGatewaySupport {

    @Autowired
    private Jaxb2Marshaller marshaller;

//    public CalcPrecoPrazoResponse callWebService(CalcPrecoPrazo calcPrecoPrazo) {
//        template = new WebServiceTemplate(marshaller);
//        CalcPrecoPrazoResponse precoPrazoResponse = (CalcPrecoPrazoResponse)
//                template.marshalSendAndReceive( "http://tempuri.org/CalcPrecoPrazo", calcPrecoPrazo);
//        return precoPrazoResponse;
//    }

    public CalcPrecoPrazoResponse callWebService(CalcPrecoPrazo calcPrecoPrazo) {
        return (CalcPrecoPrazoResponse) getWebServiceTemplate()
                .marshalSendAndReceive(calcPrecoPrazo,
                        new SoapActionCallback("http://tempuri.org/CalcPrecoPrazo"));
    }
}
