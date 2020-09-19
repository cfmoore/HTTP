package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import client.ClientGreet;

class TestServerResponse {

	@Test
	public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException
	{
		ClientGreet client = new ClientGreet();
		client.startConnection("127.0.0.1", 8888);
		String response = client.sendMessage("hello server");
		assertEquals("Hello Client",response);
	}

}
