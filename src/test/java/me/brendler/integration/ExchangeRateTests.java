package me.brendler.integration;

import me.brendler.business.ExchangeRateService;
import me.brendler.business.ExchangeRates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    public void testGetOk() throws Exception {
        ExchangeRates rates = exchangeRateService.getExchangeRates("EUR");
        assertThat(rates, is(notNullValue()));
    }

}
