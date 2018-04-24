package com.usu.stockMonitoring.observerForms;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.usu.stocks.Stock;
import com.usu.stocks.subjectObserver.StocksObserver;

public class PortfolioStockPricePanelObserver extends StocksObserver {
	
	public PortfolioStockPricePanelObserver() {
		stock = new Stock();
		stock.registerStockOberserver(this);
		frmStockPriceMonitoring = new JFrame();
		frmStockPriceMonitoring.add(createPanel());
	}

	@Override
	public void update(Stock stock) {
		Object stockObject[] = new Object[4];
		stockObject[0] = stock.symbol;
		stockObject[1] = stock.currentPrice;
		stockObject[2] = stock.bidPrice;
		stockObject[3] = stock.askPrice;
		//((DefaultTableModel)table.getModel()).fireTableDataChanged();
		
		createTable(stockObject);
	}
	
	@SuppressWarnings("all")
	public void createTable(Object stockObject[]) {
		JTable table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setAlignmentY(Component.TOP_ALIGNMENT);
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(255, 250, 250));
		table.setShowGrid(true);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {stockObject,},
			new String[] {"Stock", "Current", "Bid", "Ask Price"}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 40, 310, 230);
		scrollPane.setViewportView(table);
		
		frmStockPriceMonitoring.setVisible(true);
		frmStockPriceMonitoring.setTitle("Portfolio Stock Prices");
		frmStockPriceMonitoring.setResizable(false);
		frmStockPriceMonitoring.setBounds(100, 100, 1240, 750);
		frmStockPriceMonitoring.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStockPriceMonitoring.getContentPane().setLayout(null);
		((JPanel)frmStockPriceMonitoring.getContentPane().getComponent(0)).add(scrollPane);
	}
}