package me.brendler.business;

import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created on 28.10.2016.
 */
@Service
public class ExchangeRateService {

    public ExchangeRates getExchangeRates(String base) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target("http://api.fixer.io");
        target = target
                .path("/latest")
                .queryParam("base", base);
        // .queryParam("symbols", "USD,EUR,JPY");

        Invocation.Builder builder = target.request();
        Response response = builder.get();
        ExchangeRates exchangeRates = builder.get(ExchangeRates.class);
        return exchangeRates;
    }
}
