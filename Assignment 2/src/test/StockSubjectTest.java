package test;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.usu.stockMonitoring.observerForms.PortfolioStockPricePanelObserver;
import com.usu.stocks.Stock;
import com.usu.stocks.subjectObserver.StockSubject;

public class StockSubjectTest {

	/*For my implementation only 2 cases are possible for testing the stock register functionality*/	
	@Test
	public void testRegisterObserver_ForValidObserver() {
		new PortfolioStockPricePanelObserver();
		
		//make stockObserverList in Stock.class as public to execute
		assertThat(Stock.stockObserverList.get(0), instanceOf(PortfolioStockPricePanelObserver.class));
	}
	
	@Test(expected=NullPointerException.class)
	public void testResgisterObserver_ForNullObserver() {
		StockSubject ssTest = new Stock();
		ssTest.registerStockOberserver(null);
	}
}
