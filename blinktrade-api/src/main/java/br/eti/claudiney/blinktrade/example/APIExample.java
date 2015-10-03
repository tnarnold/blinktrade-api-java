package br.eti.claudiney.blinktrade.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import br.eti.claudiney.blinktrade.api.BlinktradeAPI;
import br.eti.claudiney.blinktrade.enums.BlinktradeBroker;
import br.eti.claudiney.blinktrade.enums.BlinktradeOrderSide;
import br.eti.claudiney.blinktrade.enums.BlinktradeOrderType;
import br.eti.claudiney.blinktrade.enums.BlinktradeSymbol;

/**
 * API examples.
 * 
 * @author Claudiney Nascimento e Silva
 * 
 * @version 1.0 2015-09-27
 * 
 * @since September/2015
 *
 */
public class APIExample {
	
	private static final String API_KEY = "YOUR_API_KEY_GENERATED_IN_API_MODULE";
	private static final String API_SECRET = "YOUR_SECRET_KEY_GENERATED_IN_API_MODULE";
	
	public static void main(String[] args) throws Exception {
		
		String response = null;
		
		/*
		 *  Initialize API
		 */
		
		BlinktradeAPI api = new BlinktradeAPI(API_KEY, API_SECRET, BlinktradeBroker.FOXBIT); 

		/*
		 *  Request Balance 
		 */
		
		System.out.println("========== Balance ==========");
		Integer balanceReqID = new Integer(1); // It can be any random number.
		response = api.getBalance(balanceReqID);
		
		System.out.println(response);
		
		/*
		 *  Request Open Orders 
		 */
		
		System.out.println("========== Open Orders ==========");
		Integer orderReqID = new Integer(1); // It can be any random number.
		response = api.requestOpenOrders(orderReqID);
		
		System.out.println(response);
		
		/*
		 *  Send New Order
		 */
		
		BigDecimal satoshiBase = new BigDecimal("100000000"); // Keep constant
		
		// Current amount (in native currency)
		BigDecimal amount = new BigDecimal("100.00");
		
		// Desired price
		BigDecimal price = new BigDecimal("200.00"); 
		
		// This line calculates the amount of bitcoin (in satoshis) required for buy order .
		BigInteger satoshis = amount
				.multiply(satoshiBase)
				.divide(price, 8, RoundingMode.DOWN)
				.toBigInteger();
		
		System.out.println("========== Send Order ==========");
		Integer clientOrderID = new Integer((int)(System.currentTimeMillis()/1000)); // Must be an unique ID. 
		response = api.sendNewOrder(
				clientOrderID,
				BlinktradeSymbol.BTCBRL,
				BlinktradeOrderSide.BUY,
				BlinktradeOrderType.LIMITED,
				price,
				satoshis);
		
		System.out.println(response);
		
		/*
		 *  Cancel an open order
		 */
		
		System.out.println("========== Cancel Order ==========");
		Integer previousClientOrderID = clientOrderID; // Must be an unique ID. Keep the last client Order 
		response = api.cancelOrder(previousClientOrderID);
		
		/*
		 *  Generate Bitcoin address
		 */
		
		System.out.println("========== GENERATE BITCOIN ADDRESS ==========");
		Integer depositRequestID = new Integer(1); // Any random integer ID 
		response = api.createBitcoinAddressForDeposit(depositRequestID);
		
		System.out.println(response);
		
	}

}
