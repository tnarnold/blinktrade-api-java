package br.eti.claudiney.blinktrade.api.beans;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class SimpleOrder implements Serializable {
	
	private BigDecimal currencyPrice;
	private BigDecimal bitcoins;
	private String clientID;
	
	public SimpleOrder() {
	}
	
	SimpleOrder(BigDecimal currencyPrice, BigDecimal bitcoins) {
		this.currencyPrice = currencyPrice;
		this.bitcoins = bitcoins;
	}
	
	public BigDecimal getCurrencyPrice() {
		return currencyPrice;
	}
	
	public BigDecimal getBitcoins() {
		return bitcoins;
	}
	
	@SuppressWarnings("unchecked")
	<T> T setClientID(String clientID) {
		this.clientID = clientID;
		return (T) this;
	}
	
	public String getClientID() {
		return clientID;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(getClass().getSimpleName());
		sb.append('{');
		sb.append("currencyPrice=").append(currencyPrice);
		sb.append(", bitcoins=").append(bitcoins);
		sb.append(", clientID=").append(clientID);
		sb.append('}');
		
		return sb.toString();
		
	}

}
