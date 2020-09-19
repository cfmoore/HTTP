package client;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

public class StopServer {
	
	private static Socket clientSocket = null;
	private static PrintWriter out = null;
	private static BufferedReader in = null;
	
	public static void startConnection(String ip, int port)
	{	
		try
		{
			clientSocket = new Socket(ip,port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}
		
		catch(IOException io)
		{
			System.out.println(io);
		}

	}
	
	public static String sendMessage(String message) throws IOException
	{
		out.println(message);
		String response = in.readLine();
		return response;
	}
	
	public void stopConnection() throws IOException
	{
		in.close();
		out.close();
		clientSocket.close();
	}

	public static void main(String[] args)
	{
		try
		{
		startConnection("127.0.0.1", 9999);
		sendMessage(".");
		}
		catch(IOException e)
		{
		System.out.println(e);
		}

	}

}
