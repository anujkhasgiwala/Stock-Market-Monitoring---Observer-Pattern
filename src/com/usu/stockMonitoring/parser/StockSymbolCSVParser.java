package com.usu.stockMonitoring.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.usu.stocks.Portfolio;

public class StockSymbolCSVParser {

	public Portfolio getStockSymbol() throws Exception {
		List<String> stockSymbols = new ArrayList<>();
		BufferedReader in = new BufferedReader(new FileReader("files/CompanyList.csv"));
		String line;
		while ((line = in.readLine()) != null) {
			String[] tokens = line.split(",");
			stockSymbols.add(tokens[0]);
		}
		in.close();
		
		return setPortfolio(stockSymbols);
	}
	
	public Portfolio setPortfolio(List<String> stockSymbols) {
		Portfolio selectedStocks = new Portfolio();
		for (String stockSymbol : stockSymbols) {
			selectedStocks.put(stockSymbol, null);
		}
		
		return selectedStocks;
	}
}
