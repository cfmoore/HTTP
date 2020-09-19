package client;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

public class ServerGreet {

	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	
	public void start(int port)
	{
		try {
			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String greeting = in.readLine();
			if("hello server".equals(greeting))
				out.println("Hello Client");
			else
				out.println("Unrecognized Greeting");
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}

		
	}
	
	public void stop()
	{
		try
		{
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		ServerGreet server = new ServerGreet();
		server.start(8888);
	}

}
