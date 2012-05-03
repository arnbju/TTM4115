package no.ntnu.item.prosjekt.client;

import no.ntnu.item.arctis.runtime.Block;

public class Client extends Block {

	public static java.lang.String alias_id;
	public no.ntnu.item.prosjekt.client.Order ordre;
	
	public static String getAlias(String melding){
		System.out.println("GetAlias: " + melding);
		return melding;
	}
	
	public static String getAlias(Order ordre){
		return ordre.getMsid();
	}

	public Order CreateOrder(String msid) {
		Order ordre = new Order(msid);
		System.out.println("Create order: "+ msid);
		return ordre;
	}

	public String sysOutTest() {
		System.out.println("blabalabsdad");
		//System.out.println(x);
		return "Din ordre er registert";
	}

	public void testeMetode() {
		System.out.println("Dette er en testemetode");
	}



	public String toConsole(Order ordre) {
		return ordre.getAck();
	}

	public String msidCheck(String msid) {
		System.out.println("MsidCheck: " + msid);
		return msid;
	}

}
