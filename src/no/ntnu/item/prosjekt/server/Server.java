package no.ntnu.item.prosjekt.server;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.prosjekt.client.Order;
import no.ntnu.item.prosjekt.taxiclient.Taxi;


public class Server extends Block {
	public 		Taxi[] ledigeTaxier = new Taxi[0];
	public		Order[] ordreList = new Order[0];


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
		ordre.setAck("Du står ikke i kø");
		return ordre;
	}

	public String queueConsole(Order ordre) {
		return "Client med id " + ordre.getMsid() + " har spurt om kønr";
	}

	public Order cancelReturn(Order ordre) {
		ordre.setAck("Din ordre er kanselert ");
		return ordre;
	}

	public String cancelConsole(Order ordre) {
		return "Klient med id " + ordre.getMsid() + " har kanselert bestillingen";
	}

	public String taxiLogOn(Taxi bil) {
		boolean eksisterer = false;
		for (int i = 0; i < ledigeTaxier.length; i++) {
			if (ledigeTaxier[i].getTxid() == bil.getTxid()){
				eksisterer = true;
			}
		}
		
		if (eksisterer == false){
			Taxi[] kopi = new Taxi[ledigeTaxier.length];
			for (int i = 0; i < ledigeTaxier.length; i++) {
				kopi[i] = ledigeTaxier[i];
			}
			
			
			ledigeTaxier = new Taxi[kopi.length+1];
			
			
			for (int i = 0; i < kopi.length; i++) {
				ledigeTaxier[i] = kopi[i];
			}
			
			ledigeTaxier[ledigeTaxier.length -1] = bil;
		}
		
		
		for (int i = 0; i < ledigeTaxier.length; i++) {
			System.out.println("Taxi " + ledigeTaxier[i].getTxid() + " er ledig. Plass i array er" + i);
		}
		
		
		return "Taxi med id: " + bil.getTxid() + " har logget på, action: " + bil.getAction();
	}

	public String taxiLogOut(Taxi bil) {
		boolean eksister = false;
		
		for (int i = 0; i < ledigeTaxier.length; i++) {
			if(bil.getTxid() == ledigeTaxier[i].getTxid()){
				eksister = true;
				int plass = i;
				
				 
			}
		}
		
		
		return "Taxi med id: " + bil.getTxid() + " har logget av, action: " + bil.getAction();
	}

	public String taxiAccept(Taxi bil) {
		return "Taxi med id " + bil.getTxid() + " har akseptert, action: " + bil.getAction();
	}

	public String taxiBusy(Taxi bil) {
		return "Taxi med id " + bil.getTxid() + " er busy, action: " + bil.getAction();
	}

	public String taxiFree(Taxi bil) {
		return "Taxi med id " + bil.getTxid() + " er nå ledig, action: " + bil.getAction();
	}

	public Taxi dummy(Taxi bil) {
		bil.setAction("Dummy info");
		return bil;
	}
	
	public Taxi[] fjernTaxi(Taxi[] taxiListe, Taxi taxiBil){ // metode for å fjerne en taxi
		Taxi[] kopi = new Taxi[taxiListe.length-1];
		for (int j = 0; j < taxiListe.length; j++) {
			kopi[j] =  taxiListe[j];
		}
		
	}
		
		

	
}
