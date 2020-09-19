package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import client.ClientEcho;
import client.ServerEchos;

class TestEcho {

	ClientEcho client = null;
	ServerEchos server = null;
	
	@BeforeEach
	public void setup() 
	{
		System.out.println("HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		client = new ClientEcho();
		client.startConnection("127.0.0.1", 9999);
		
		
	}
	
	@Test
	public void givenClient_whenServerEchosMessage_ThenCorrect() throws IOException 
	{
		/*System.out.println("HERE:");
		client = new ClientEcho();
		client.startConnection("127.0.0.1", 9999);*/
		String resp1 = client.sendMessage("hello");
		String resp2 = client.sendMessage("world");
		String resp3 = client.sendMessage("!");
		String StopServer = client.sendMessage(".");
		
		assertEquals("hello",resp1);
		assertEquals("world",resp2);
		assertEquals("!",resp3);
		assertEquals("Good Bye!",StopServer);
		
	}
	
	@AfterEach
	public void tearDown() throws IOException
	{
		client.stopConnection();
	}

}
