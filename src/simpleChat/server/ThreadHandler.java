package simpleChat.server;

/**
 * Author: Collin Price
 * Contact: collin.price@gmail.com
 * Blog: collinprice.wordpress.com
 * Twitter: twitter.com/collinprice
 */

import java.net.*;
import java.util.Vector;
import java.io.*;

public class ThreadHandler extends Thread {

	static Vector<ThreadHandler> handlers = new Vector<ThreadHandler>(10);
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	ThreadHandler (Socket socket) throws IOException {
		this.socket = socket;
		
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	} // constructor
	
	public void run () {
		String input;
		
		synchronized (handlers) {
			handlers.add(this);
		}
		
		try {
			out.println("Welcome to Chat Server 9000 \r\n There are currently " + handlers.size() + " users online.");
			//while (!(input = in.readLine()).equalsIgnoreCase("/quit")) {
			while (true) {
				input = in.readLine();
				
				if (input.equalsIgnoreCase("/users")) {
					String temp;
					
					for (ThreadHandler thread : handlers) {
						
					}
					
					
				} else if (input.equalsIgnoreCase("/number")) {
					this.out.println("There are currently " + handlers.size() + " users online.");
				} else if (input.equalsIgnoreCase("/help")) {
					this.out.println("Two commands available.");
					this.out.println("/users - displays the names of all the current users.");
					this.out.println("/number - displays the number of users currently online.");
				} else {
					for (ThreadHandler thread : handlers) {
						if (thread.equals(this)) {
							//continue;
						}
						thread.out.println(input);
						thread.out.flush();
					}
				}
				
			}
			
		} catch (IOException e) {
			System.err.println("User dropped.");
		} finally {
			
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				System.err.println("Error closing streams.");
			} finally {
				synchronized (handlers) {
					handlers.remove(this);
				}
			}
			
			
			
		}
		
	} // run
	
}
