package no.ntnu.item.prosjekt.server;

import no.ntnu.item.arctis.runtime.Block;

public class Server extends Block {

	public String confirmOrder(String input) {
		System.out.println("Dette er inni confirm order: " + input);
		return input;
	}

	public String consoleUtput(String msid) {
		String tekst = "Du har mottatt en ordre fra: " + msid;
		return tekst;
	}

}
