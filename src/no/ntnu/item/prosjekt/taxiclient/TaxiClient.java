package no.ntnu.item.prosjekt.taxiclient;

import no.ntnu.item.arctis.runtime.Block;

public class TaxiClient extends Block {

	public java.lang.String alias_id;
	public Taxi denneTaxi;
	
	
	public static String getAlias(String msid){
		return msid;
	}
	
	public static String getAlias(Taxi bil){
		return bil.getTxid();
	}

	public String createTaxi(String text) {
		Taxi bil = new Taxi(text);
		denneTaxi = bil;
		System.out.println("Dette er createTaxi: " + text);
		return text;
		
	}

	public Taxi logOnID(String action) {
		denneTaxi.setAction(action);
		return denneTaxi;
	}

	public Taxi logOffID(String action) {
		denneTaxi.setAction(action);
		return denneTaxi;
	}

	public Taxi busyID(String action) {
		denneTaxi.setAction(action);
		return denneTaxi;
	}

	public Taxi acceptID(String action) {
		denneTaxi.setAction(action);
		return denneTaxi;
	}

	public Taxi freeID(String action) {
		denneTaxi.setAction(action);
		return denneTaxi;
	}

	public String consoleString(Taxi bil) {
		return "ID: "+ bil.getTxid() + ", Siste Action: " + bil.getAction() + "\n" + bil.getBesked();
	}

	public String stateString(Taxi bil) {
		return "State: " + bil.getState();
	}

}
