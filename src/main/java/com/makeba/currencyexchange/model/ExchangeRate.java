package com.makeba.currencyexchange.model;
import java.util.Date;

public class ExchangeRate {

  private String from;

  private String to;

  private double rate;

  private String source;

  private Date timestamp;

  public String getFrom() {
    return from;
  }

  public void setFrom(final String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(final String to) {
    this.to = to;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(final double rate) {
    this.rate = rate;
  }

  public String getSource() {
    return source;
  }

  public void setSource(final String source) {
    this.source = source;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
  }

}
