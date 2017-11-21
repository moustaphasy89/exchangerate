package com.makeba.currencyexchange.service;
import java.util.List;

import com.makeba.currencyexchange.model.ExchangeRate;

public interface RateParser {

  List<ExchangeRate> parse(String json);

}