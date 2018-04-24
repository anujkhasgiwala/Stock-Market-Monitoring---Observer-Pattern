package com.usu.stocks.subjectObserver;

import java.util.List;

import com.usu.stocks.Stock;

public abstract class StockSubject {
	protected List<StocksObserver> stockObserverList;
	
	/**
	 * 
	 * @param addNewObserver
	 */
	public abstract void registerStockOberserver(StocksObserver addNewObserver);

	/**
	 * 
	 * @param deleteObserver
	 */
	public abstract void removeStockObserver(StocksObserver deleteObserver);

	/**
	 * 
	 */
	public abstract void notifyStockObserver(Stock stock);

}