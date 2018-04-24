package com.usu.stocks;

import java.util.HashMap;

import com.usu.simulatorCommunication.messages.TickerMessage;

public class Portfolio extends HashMap<String, Stock> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6517146938474468373L;

	public void update(TickerMessage message) {
        if (message == null) return;

        if (containsKey(message.symbol)) {
        	Stock stock = new Stock(message);
        	this.get(message.symbol).update(stock);
        }
    }
	
	public Portfolio() {
		
	}
}