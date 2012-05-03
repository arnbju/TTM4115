package no.ntnu.item.prosjekt.userclient;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.prosjekt.client.*;

public class UserClient extends Block {

	public Order denneOrdre;

	public java.lang.String alias_id;

	public static String getAlias(String melding){
		System.out.println("GetAlias: " + melding);
		return melding;
	}

	public static String getAlias(Order ordre){
		return ordre.getMsid();
	}

	public String reciveAck(Order ordre) {
		denneOrdre = ordre;
		return ordre.getAck();
	}

	public Order createOrder() {
		Order ordre = new Order(alias_id);
		System.out.println("Create order: " + alias_id);
		return ordre;
	}

	public String extractAlias(Order ordre) {
		return ordre.getMsid();
	}

	public void testCancel() {
	}

	public Order queueNrTest() {
		
		System.out.println("QueueNrTest");
		return denneOrdre;
	}

	public String reciveQueue(Order ordre) {
		return ordre.getQueue();
	}

}
