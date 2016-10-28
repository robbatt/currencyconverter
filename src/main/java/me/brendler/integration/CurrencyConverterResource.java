package me.brendler.integration;

import me.brendler.business.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created on 28.10.2016.
 */
@RestController
@RequestMapping(value = "/convert")
public class CurrencyConverterResource {

    @Autowired
    CurrencyConverterService currencyConverterService;

    @RequestMapping(method = GET)
    public Double convert(HttpServletResponse response,
                          @RequestParam("from") String fromCurrency,
                          @RequestParam("to") String toCurrency,
                          @RequestParam("amount") Double amount) {
        return currencyConverterService.convert(fromCurrency, toCurrency, amount);
    }

}
