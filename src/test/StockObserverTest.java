package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usu.stockMonitoring.observerForms.PortfolioStockPricePanelObserver;
import com.usu.stocks.Stock;

public class StockObserverTest {

	@Test
	public void testStockUpdate() {
		Stock stock = new Stock();
		stock.symbol="AAPL";
		stock.registerStockOberserver(new PortfolioStockPricePanelObserver());
		stock.notifyStockObserver(stock);
		//assertEquals(stock.symbol, PortfolioStockPricePanelObserver.stock1.symbol);//to run this create a static stock object and assign it with stock value in update method
	}
}
