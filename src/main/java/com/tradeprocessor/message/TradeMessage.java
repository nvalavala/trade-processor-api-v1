package com.tradeprocessor.message;

public class TradeMessage {
	public enum IdSource { ISIN, CUSIP, SEDOL, RIC };
	public String tradeId;
	public String account;
	public String securityId;
	public IdSource idSource;
	public String isin;
	public String sedol;
	public String cusip;
	public String ric;
	public String ticker;
	public Integer qty;
	public Double price;
}
