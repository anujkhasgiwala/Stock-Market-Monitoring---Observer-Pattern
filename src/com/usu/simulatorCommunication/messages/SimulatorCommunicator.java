package com.usu.simulatorCommunication.messages;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.usu.stocks.Portfolio;

public class SimulatorCommunicator {
	
	DatagramSocket clientSocket;
	Portfolio portfolios;
	private InetAddress remoteAddress;
    private boolean isMonitoring;
	
	public void startUDPPacket() throws Exception {
		clientSocket = new DatagramSocket(0);
		remoteAddress = InetAddress.getByName("52.41.30.128");
		// clientSocket.connect("0.0.0.0", 0);
		
        isMonitoring=true;
		new CommunicatorThread().run();
	}
	
	public void stopUDPPacket() throws SocketException, Exception {
		isMonitoring = false;
		if(clientSocket != null) {
			clientSocket.close();
			clientSocket = null;
		}
	}
	
	private void monitoring(Object state) {
        if (portfolios == null)
        	return;
        
        StreamStocksMessage startMessage = new StreamStocksMessage();
        for(String key : portfolios.keySet()) {
        	startMessage.Add(key);
        }
        send(startMessage);
        
        while (isMonitoring) {
            try {
            	portfolios.update(receive(10000));
            }
            catch (Exception e) {
            }
        }
    }
	
	public void send(StreamStocksMessage message) {
        if (message == null)
        	return;

        byte[] bytesToSend = message.Encode();

        try {
        	clientSocket.send(new DatagramPacket(bytesToSend, bytesToSend.length, remoteAddress, 12099));//we can replace port # by 0
        }
        catch (Exception e) {
        }
    }

	
    private TickerMessage receive(int timeout) throws IOException {
        TickerMessage message = null;

        byte[] receivedData = receivePacket(timeout);
        if (receivedData != null && receivedData.length > 0)
            message = TickerMessage.Decode(receivedData);

        return message;
    }


    private byte[] receivePacket(int timeout) throws IOException {
    	byte[] receivedData = new byte[42];

        clientSocket.setSoTimeout(timeout);
        DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
        try {
        	clientSocket.receive(receivedPacket);
        }
        catch (SocketException err) {
        	JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Simulator stopped sending packet");
        }
        
        return receivedPacket.getData();
    }
    
    private class CommunicatorThread implements Runnable {

		@Override
		public void run() {
			monitoring(new Object());			
		}
    	
    }
    
    public SimulatorCommunicator(Portfolio selectedStocksPortfolio){
        portfolios = selectedStocksPortfolio;
    }
}