package simpleChat.server;

/**
 * Author: Collin Price
 * Contact: collin.price@gmail.com
 * Blog: collinprice.wordpress.com
 * Twitter: twitter.com/collinprice
 */

import java.net.*;
import java.io.*;

public class ChatServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5225);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 5225");
			System.exit(1);
		}
		
		Socket clientSocket = null;
		
		try {
			while (true) {
				clientSocket = serverSocket.accept();
				ThreadHandler thread = new ThreadHandler(clientSocket);
				thread.start();
			}
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		} finally {
			serverSocket.close();
		}
		
	}

}
