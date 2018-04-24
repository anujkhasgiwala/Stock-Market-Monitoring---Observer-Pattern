package com.usu.stockMonitoring.observerForms;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.usu.stocks.Stock;
import com.usu.stocks.subjectObserver.StocksObserver;

public class IndividualStockVolumeGraphObserver extends StocksObserver {

	public IndividualStockVolumeGraphObserver() {
		stock = new Stock();
		stock.registerStockOberserver(this);
	}

	@Override
	public void update(Stock stock) {
		createTextPane1();
		createTextPane2();
	}
	
	private void createTextPane1() {
		JFrame frmStockPriceMonitoring = new JFrame();
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.PINK);
		textPane.setEditable(false);
		textPane.setText("Anuj");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(330, 41, 310, 10);
		panel_1.add(textPane);		
		
		frmStockPriceMonitoring.getContentPane().add(panel_1);
	}
	
	private void createTextPane2() {
		JFrame frmStockPriceMonitoring = new JFrame();
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.YELLOW);
		textPane_1.setText("Keval");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(640, 40, 300, 10);
		panel_2.add(textPane_1);
		
		frmStockPriceMonitoring.getContentPane().add(panel_2);		
	}
}