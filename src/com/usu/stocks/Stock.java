package com.usu.stocks;

import java.util.ArrayList;
import java.util.List;

import com.usu.simulatorCommunication.messages.TickerMessage;
import com.usu.stocks.subjectObserver.StockSubject;
import com.usu.stocks.subjectObserver.StocksObserver;

public class Stock extends StockSubject {

	public String symbol;
	public long messageTimestamp;
	public int openingPrice;
	public int previousClosingPrice;
	public int currentPrice;
	public int bidPrice;
	public int askPrice;
	public int currentVolume;
	public int averageVolume;
	
	public static List<StocksObserver> stockObserverList = new ArrayList<>();

	@Override
	public void registerStockOberserver(StocksObserver addNewObserver) {
		if(addNewObserver == null)
			throw new NullPointerException("Null Observer");
		synchronized (new Object()) {
			if(!stockObserverList.contains(addNewObserver))
				stockObserverList.add(addNewObserver);
		}
	}

	@Override
	public void removeStockObserver(StocksObserver deleteObserver) {
		synchronized (new Object()) {
			stockObserverList.remove(deleteObserver);
		}
	}

	@Override
	public void notifyStockObserver(Stock stock) {
		for (StocksObserver stocksObserver : stockObserverList) {
			stocksObserver.update(stock);
		}
	}

	public List<StocksObserver> getStockObserverList() {
		return stockObserverList;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getMessageTimestamp() {
		return messageTimestamp;
	}

	public void setMessageTimestamp(long messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	public int getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(int openingPrice) {
		this.openingPrice = openingPrice;
	}

	public int getPreviousClosingPrice() {
		return previousClosingPrice;
	}

	public void setPreviousClosingPrice(int previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(int askPrice) {
		this.askPrice = askPrice;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public int getAverageVolume() {
		return averageVolume;
	}

	public void setAverageVolume(int averageVolume) {
		this.averageVolume = averageVolume;
	}

	public void update(Stock stock) {
		notifyStockObserver(stock);
	}

	public Stock(TickerMessage message) {
		symbol = message.symbol;
		messageTimestamp = message.messageTimestamp;
		openingPrice = message.openingPrice;
		previousClosingPrice = message.previousClosingPrice;
		currentPrice = message.currentPrice;
		bidPrice = message.bidPrice;
		askPrice = message.askPrice;
		currentVolume = message.currentVolume;
		averageVolume = message.averageVolume;
	}
	
	public Stock() {
	}

}