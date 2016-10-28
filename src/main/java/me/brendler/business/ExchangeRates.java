package me.brendler.business;

import java.util.Date;
import java.util.Map;

/**
 * Created on 28.10.2016.
 */
public class ExchangeRates {
    String base;
    Date date;
    Map<String, Float> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Float> getRates() {
        return rates;
    }

    public void setRates(Map<String, Float> rates) {
        this.rates = rates;
    }
}
