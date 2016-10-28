package me.brendler.integration;

import me.brendler.business.ExchangeRateService;
import me.brendler.business.ExchangeRates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ExchangeRateTests {

    @Autowired
    ExchangeRateService exchangeRateService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetExchangeRatesEUR() throws Exception {
        ExchangeRates rates = exchangeRateService.getExchangeRates("EUR");
        assertThat(rates, is(notNullValue()));
        assertThat(rates.getBase(), is("EUR"));
        assertThat(rates.getRates().get("USD"), is(notNullValue()));
        assertThat(rates.getRates().get("USD"), is(greaterThan(0.0f)));
        assertThat(rates.getRates().get("JPY"), is(notNullValue()));
        assertThat(rates.getRates().get("JPY"), is(greaterThan(0.0f)));
    }

    @Test
    public void testGetExchangeRatesUSD() throws Exception {
        ExchangeRates rates = exchangeRateService.getExchangeRates("USD");
        assertThat(rates, is(notNullValue()));
        assertThat(rates.getBase(), is("USD"));
        assertThat(rates.getRates().get("EUR"), is(notNullValue()));
        assertThat(rates.getRates().get("EUR"), is(greaterThan(0.0f)));
        assertThat(rates.getRates().get("JPY"), is(notNullValue()));
        assertThat(rates.getRates().get("JPY"), is(greaterThan(0.0f)));
    }

    @Test
    public void testGetExchangeRatesJPY() throws Exception {
        ExchangeRates rates = exchangeRateService.getExchangeRates("JPY");
        assertThat(rates, is(notNullValue()));
        assertThat(rates.getBase(), is("JPY"));
        assertThat(rates.getRates().get("USD"), is(notNullValue()));
        assertThat(rates.getRates().get("USD"), is(greaterThan(0.0f)));
        assertThat(rates.getRates().get("EUR"), is(notNullValue()));
        assertThat(rates.getRates().get("EUR"), is(greaterThan(0.0f)));
    }

}
