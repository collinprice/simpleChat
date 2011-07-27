package simpleChat.client;

/**
 * Author: Collin Price
 * Contact: collin.price@gmail.com
 * Blog: collinprice.wordpress.com
 * Twitter: twitter.com/collinprice
 */

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class RecieverThread extends Thread {

	private BufferedReader in;
	private JTextArea area;
	
	public RecieverThread (BufferedReader stream, JTextArea area) {
		in = stream;
		this.area = area;
	}
	
	public void run () {
		String input;
		while (true) {
			
			try {
				if ((input = in.readLine()) != null) {
					area.append(input + "\n");
				}
			} catch (IOException e) {
				System.err.println("Error recieving server input.");
				this.interrupt();
			}
		}
		
	}
	
}
