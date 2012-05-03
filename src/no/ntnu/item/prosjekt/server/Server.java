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
	//	System.out.println("Du st�r ikke i k�");
		ordre.setAck("Du st�r ikke i k�");
		return ordre;
	}

	public String queueConsole(Order ordre) {
		return "Client med id " + ordre.getMsid() + " har spurt om k�nr";
	}

	public Order cancelReturn(Order ordre) {
		ordre.setAck("Din ordre er kanselert ");
		return ordre;
	}

	public String cancelConsole(Order ordre) {
		return "Klient med id " + ordre.getMsid() + " har kanselert bestillingen";
	}

	public String taxiLogOn(Taxi bil) {
		for (int i = 0; i < ledigeTaxier.length; i++) {
			if (ledigeTaxier[i].getTxid() == bil.getTxid()){
				ledigeTaxier = addTaxi(ledigeTaxier, bil);
				break;
			}
		}		
		
		for (int i = 0; i < ledigeTaxier.length; i++) {
			System.out.println("Taxi " + ledigeTaxier[i].getTxid() + " er ledig. Plass i array er" + i);
		}
		
		
		return "Taxi med id: " + bil.getTxid() + " har logget p�, action: " + bil.getAction();
	}

	public String taxiLogOut(Taxi bil) {
				
		for (int i = 0; i < ledigeTaxier.length; i++) {
			if(bil.getTxid() == ledigeTaxier[i].getTxid()){
				ledigeTaxier = fjernTaxi(ledigeTaxier, bil);
				break;	 
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
		return "Taxi med id " + bil.getTxid() + " er n� ledig, action: " + bil.getAction();
	}

	public Taxi dummy(Taxi bil) {
		bil.setAction("Dummy info");
		return bil;
	}
	
	public Taxi[] fjernTaxi(Taxi[] taxiListe, Taxi taxiBil){ // metode for � fjerne en taxi fra en Taxi-liste
		Taxi[] kopi = new Taxi[taxiListe.length-1];
		int plass = 0;
		
		for (int i = 0; i < taxiListe.length; i++) {
			if (taxiBil.getTxid() == taxiListe[i].getTxid()){
				plass = i;
			}
		}
		
		for (int i = 0; i < plass; i++) {
			kopi[i] =  taxiListe[i];
		}
		
		for (int i = plass+1; i < kopi.length; i++) {
			kopi[i] = taxiListe[i+1];
		}
		
		return kopi;
		}
	
	public Taxi[] addTaxi(Taxi[] taxiListe, Taxi taxiBil){ //metode for � legge till taxi i Taxi-liste
		Taxi[] kopi = new Taxi[taxiListe.length+1];
		kopi[kopi.length-1] = taxiBil;
		
		for (int i = 0; i < kopi.length; i++) {
			kopi[i] = taxiListe[i];
		}
		return kopi;
		
	}
	


	public Taxi processOrder(Order ordre) {
		Taxi bil = ledigeTaxier[0];
		bil.setBesked("Vil du hente kunde med id: " + ordre.getMsid());
		
		return bil;
		
	}
		
		
	public Order[] leggTilOrder(Order[] liste, Order ordre){
		
		Order[] kopi = new Order[liste.length + 1];
		
		for (int i = 0; i < ledigeTaxier.length; i++) {
			kopi[i] = liste[i];
		}
			
		kopi[ledigeTaxier.length -1] = ordre;
			
				
		return kopi;
	}
}
