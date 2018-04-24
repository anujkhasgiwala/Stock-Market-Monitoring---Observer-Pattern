package com.usu.stockMonitoring.forms;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.usu.stockMonitoring.observerForms.IndividualStockPriceGraphObserver;
import com.usu.stockMonitoring.observerForms.IndividualStockVolumeGraphObserver;
import com.usu.stockMonitoring.observerForms.PortfolioStockPricePanelObserver;
import com.usu.stockMonitoring.parser.StockSymbolCSVParser;

public class AddObserverDialog {
	
	public AddObserverDialog() {
		radioButtonsValue();
	}

	private final JDialog dialog = new JDialog();
	private final JPanel contentPanel = new JPanel();
	
	public static boolean radioButtonsValue[] = new boolean[3];

	/**
	 * Create the dialog.
	 */
	private void radioButtonsValue() {
		dialog.setTitle("Select Observer");
		dialog.setBounds(100, 100, 450, 300);
		dialog.getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		dialog.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		dialog.setVisible(true);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Portfolio Stock Prices");
		rdbtnNewRadioButton.setBounds(134, 75, 200, 23);
		contentPanel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					radioButtonsValue[0] = true;
				} else {
					radioButtonsValue[0] = false;
				}
			}
		});

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Individual Stock Price Graph");
		rdbtnNewRadioButton_1.setBounds(134, 101, 200, 23);
		contentPanel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					radioButtonsValue[1] = true;
				} else {
					radioButtonsValue[1] = false;
				}
			}
		});

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Individual Stock Volume Graph");
		rdbtnNewRadioButton_2.setBounds(134, 127, 200, 23);
		contentPanel.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					radioButtonsValue[2] = true;
				} else {
					radioButtonsValue[2] = false;
				}
			}
		});
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rdbtnNewRadioButton);
		bg1.add(rdbtnNewRadioButton_1);
		bg1.add(rdbtnNewRadioButton_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 225, 434, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		dialog.getContentPane().add(buttonPane);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		dialog.getRootPane().setDefaultButton(okButton);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddStocksForms(new StockSymbolCSVParser().getStockSymbol());
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				dialog.setVisible(false);
				if(radioButtonsValue[0]) {
					new PortfolioStockPricePanelObserver();
				} else if(radioButtonsValue[1]) {
					new IndividualStockPriceGraphObserver();
				} else if(radioButtonsValue[2]) {
					new IndividualStockVolumeGraphObserver();
				}
			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
	}

}
