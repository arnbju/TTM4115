package no.ntnu.item.prosjekt.server;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.prosjekt.client.Order;


public class Server extends Block {

	public Order confirmOrder(Order input) {
		System.out.println("Dette er inni confirm order: " + input.getMsid());
		input.setAck("Din ordre er mottatt, du har id: " + input.getMsid());
		return input;
	}

	public String consoleUtput(Order ordre) {
		String tekst = "Du har mottatt en ordre fra: " + ordre.getMsid();
		return tekst;
	}

	public Order queueNrReturn(Order ordre) {
	//	System.out.println("Du står ikke i kø");
		ordre.setQueue("Du står ikke i kø");
		return ordre;
	}

	public String queueConsole(Order ordre) {
		return "Client med id " + ordre.getMsid() + " har spurt om kønr";
	}

}
