package com.usu.stocks.subjectObserver;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.usu.stocks.Stock;

public abstract class StocksObserver {
	
	public JFrame frmStockPriceMonitoring;
	
	public StockSubject stock;
	
	public abstract void update(Stock stock);
	
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 40, 310, 230);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel.setVisible(true);
		
		return panel;
	}
}