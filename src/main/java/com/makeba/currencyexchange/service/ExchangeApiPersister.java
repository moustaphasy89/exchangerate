package com.makeba.currencyexchange.service;

public interface ExchangeApiPersister {
  public void persist(final String apiName);

  public String read(final String apiName);
}