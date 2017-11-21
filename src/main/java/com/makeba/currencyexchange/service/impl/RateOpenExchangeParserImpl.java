package com.makeba.currencyexchange.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.makeba.currencyexchange.model.ExchangeRate;
import com.makeba.currencyexchange.service.RateParser;

public class RateOpenExchangeParserImpl implements RateParser {

  /**
   * Méthode héritée et réécrite : parse
   *
   * @param json
   * @return
   * @see RateParser#parse(java.lang.String)
   */
  public List<ExchangeRate> parse(final String jsonLine) {

    final JsonObject jobj = new JsonParser().parse(jsonLine).getAsJsonObject();
    final String from = jobj.get("base").getAsString();
    final Integer callTime = jobj.get("timestamp").getAsInt();
    final String source = "OPENEXCHANGE";
    final JsonObject ratesJo = jobj.get("rates").getAsJsonObject();
    final Set<Map.Entry<String, JsonElement>> entries = ratesJo.entrySet();//will return members of your object
    final List<ExchangeRate> rates = new ArrayList<ExchangeRate>();
    for (final Map.Entry<String, JsonElement> entry : entries) {
      final ExchangeRate e = new ExchangeRate();
      e.setFrom(from);
      e.setTimestamp(new Date(callTime));
      e.setSource(source);
      e.setTo(entry.getKey());
      e.setRate(entry.getValue().getAsDouble());

      rates.add(e);
    }
    return rates;

  }
}
