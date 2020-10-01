package com.br.soapwebservice.config;

import com.br.soapwebservice.client.SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.br.soapwebservice.soap");
        return marshaller;
    }

    @Bean
    public SoapClient soapConnector(Jaxb2Marshaller marshaller) {
        SoapClient client = new SoapClient();
        client.setDefaultUri("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
