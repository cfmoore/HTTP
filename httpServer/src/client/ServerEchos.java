package client;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;

public class ServerEchos 
{
	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;

	public void start(int port)
	{
		try
		{
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine ="";
		while((inputLine = in.readLine())!=null)
		{
			if(".".equals(inputLine))
			{
				out.println("Good Bye!");
				break;
			}
			out.println(inputLine);
		}
		
		
		}
		catch(IOException io)
		{
			System.out.println(io);
		}
	}
	
	/*public static void main(String[] args) {
		ServerEchos server = new ServerEchos();
		server.start(9999);
	}*/
}
