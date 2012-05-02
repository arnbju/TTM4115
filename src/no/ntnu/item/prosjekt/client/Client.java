package no.ntnu.item.prosjekt.client;

import no.ntnu.item.arctis.runtime.Block;

public class Client extends Block {

	public static java.lang.String alias_id;

	public static String getAlias(String melding){
		System.out.println("GetAlias: " + melding);
		return melding;
	}
	

	
	public String CreateOrder() {
		System.out.println("Dette er inni create order");
		System.out.println(alias_id);
		return alias_id;
	}

	public String sysOutTest() {
		System.out.println("blabalabsdad");
		//System.out.println(x);
		return "Din ordre er registert";
	}

	public void testeMetode() {
		System.out.println("Dette er en testemetode");
	}

}
