package me.brendler.business;

import me.brendler.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 28.10.2016.
 */
@Service
public class CurrencyConverterService {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public CurrencyConverterService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        ExchangeRates rates = exchangeRateService.getExchangeRates(fromCurrency);
        Float conversionRate = rates.getRates().get(toCurrency);
        return conversionRate * amount;
    }
}
