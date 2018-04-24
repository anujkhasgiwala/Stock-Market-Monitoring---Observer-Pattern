package com.usu.stockMonitoring.forms;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.usu.stocks.Portfolio;
import javax.swing.JScrollPane;

public class StockPriceMonitoringSystemControlForm {

	protected JFrame frmStockPriceMonitoring;
	private JTextField txtHeaderInfo;
	protected JTable table;
	
	Portfolio allPortfolios, selectedPortfolio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockPriceMonitoringSystemControlForm window = new StockPriceMonitoringSystemControlForm();
					window.frmStockPriceMonitoring.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockPriceMonitoringSystemControlForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("all")
	private void initialize() {
		frmStockPriceMonitoring = new JFrame();
		frmStockPriceMonitoring.setTitle("Stock Price Monitoring System");
		frmStockPriceMonitoring.setResizable(false);
		frmStockPriceMonitoring.setBounds(100, 100, 1240, 750);
		frmStockPriceMonitoring.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStockPriceMonitoring.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 65, 20);
		frmStockPriceMonitoring.getContentPane().add(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("Observer");
		mnNewMenu_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Add");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddObserverDialog();
			}
		});
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Delete");
		menuItem_4.setEnabled(false);
		menuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_2.add(menuItem_4);
		
		/*JMenu mnNewMenu_1 = new JMenu("Stock");
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setVisible(false);
		
		JMenuItem menuItem_1 = new JMenuItem("Add");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					allPortfolios = new StockSymbolCSVParser().getStockSymbol();
				} catch(Exception e) {
					e.printStackTrace();
				}
				new AddStocksForms(allPortfolios);
				selectedPortfolio = AddStocksForms.selectedPortfolio;//to be removed later
			}
		});
		mnNewMenu_1.add(menuItem_1);
		menuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_1.setBounds(0, 0, 129, 22);
		
		JMenuItem menuItem_2 = new JMenuItem("Delete");
		menuItem_2.setEnabled(false);
		mnNewMenu_1.add(menuItem_2);
		menuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_2.setBounds(0, 0, 129, 22);*/
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(90, 10, 10, 20);
		frmStockPriceMonitoring.getContentPane().add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		txtHeaderInfo = new JTextField();
		txtHeaderInfo.setBounds(100, 10, 550, 20);
		frmStockPriceMonitoring.getContentPane().add(txtHeaderInfo);
		txtHeaderInfo.setHorizontalAlignment(SwingConstants.LEFT);
		txtHeaderInfo.setEditable(false);
		txtHeaderInfo.setText("Header Info");
		txtHeaderInfo.setColumns(2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 40, 310, 230);
		frmStockPriceMonitoring.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setAlignmentY(Component.TOP_ALIGNMENT);
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		//panel.add(table);
		table.setBackground(new Color(255, 250, 250));
		table.setShowGrid(true);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {{null, null, null, null}, },
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
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(330, 41, 310, 10);
		frmStockPriceMonitoring.getContentPane().add(panel_1);
		
		JTextPane textPane = new JTextPane();
		panel_1.add(textPane);
		textPane.setBackground(Color.PINK);
		textPane.setEditable(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(830, 40, 400, 10);
		frmStockPriceMonitoring.getContentPane().add(panel_2);
		
		JTextPane textPane_1 = new JTextPane();
		panel_2.add(textPane_1);
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.YELLOW);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 283, 1220, 10);
		frmStockPriceMonitoring.getContentPane().add(panel_3);
		
		Canvas canvas = new Canvas();
		panel_3.add(canvas);
		canvas.setEnabled(false);
		canvas.setBackground(Color.MAGENTA);
	}
}
