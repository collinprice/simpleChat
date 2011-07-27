package simpleChat.client;

/**
 * Author: Collin Price
 * Contact: collin.price@gmail.com
 * Blog: collinprice.wordpress.com
 * Twitter: twitter.com/collinprice
 */

import java.io.*;
import java.net.*;

import javax.swing.JTextArea;

public class ChatClient {

	private String username = "Wally";
	private Socket client = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private RecieverThread inputStream = null;
	
	public ChatClient (String username, JTextArea area) {
		this.username = username;
		
		try {
			client = new Socket("127.0.0.1",5225);
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while(!in.ready());
		} catch (UnknownHostException e) {
			System.err.println("Who is host: ");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Cannot get IO from connection.");
			System.exit(1);
		}
		
		out.println(username + " has entered chat room.");
		inputStream = new RecieverThread(in,area);
		inputStream.start();
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		
	} // constructor
	
	public void sendMessage (String msg) {
		out.println(username + ": " +msg);
	} // sendMessage
	
	public String getUsername () {
		return username;
	} // getUsername
	
	public void killClient () {
		inputStream.interrupt();
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			System.err.println("Problem closing input buffer.");
		}
		try {
			client.close();
		} catch (IOException e) {
			System.err.println("Problem closing client.");
		}
	} // killClient
	

} // chatClient
