package me.brendler.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 28.10.2016.
 */
@Service
public class CurrencyConverterService {

    @Autowired
    ExchangeRateService exchangeRateService;

    public Double convert(String fromCurrency, String toCurrency, Double amount) {
        ExchangeRates rates = exchangeRateService.getExchangeRates(fromCurrency);
        Double convertedAmount = rates.getRates().get(toCurrency) * amount;
        return convertedAmount;
    }
}
