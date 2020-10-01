package com.br.soapwebservice.controller;

import com.br.soapwebservice.client.SoapClient;
import com.br.soapwebservice.soap.CalcPrecoPrazo;
import com.br.soapwebservice.soap.CalcPrecoPrazoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class CorreiosController {

    private final SoapClient soapClient;

    @PostConstruct
    public void getCalcPrecoPrazoResponse(){
        CalcPrecoPrazo c = new CalcPrecoPrazo();
        c.setSCepOrigem("04849529");
        c.setSCepDestino("58900000");
        c.setNCdServico("04510");
        c.setNCdEmpresa("");
        c.setSDsSenha("");
        c.setNVlPeso("1");
        c.setNCdFormato(1);
        c.setNVlComprimento(new BigDecimal(55));
        c.setNVlAltura(new BigDecimal(30));
        c.setNVlDiametro(new BigDecimal(60));
        c.setNVlLargura(new BigDecimal(20));
        c.setSCdMaoPropria("S");
        c.setNVlValorDeclarado(new BigDecimal(0));
        c.setSCdAvisoRecebimento("N");

        try {
            CalcPrecoPrazoResponse response = soapClient.callWebService(c);
            System.out.println(response.getCalcPrecoPrazoResult().getServicos().getCServico().get(0).getPrazoEntrega());

        }catch (SoapFaultClientException ex){
            ex.printStackTrace();
        }

    }
}
