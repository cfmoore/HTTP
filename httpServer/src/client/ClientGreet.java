package client;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

public class ClientGreet {
	
	private Socket clientSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	
	public void startConnection(String ip, int port)
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
	
	public String sendMessage(String message) throws IOException
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
