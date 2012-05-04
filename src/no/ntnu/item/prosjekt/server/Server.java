package no.ntnu.item.prosjekt.server;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.prosjekt.client.Order;
import no.ntnu.item.prosjekt.taxiclient.Taxi;



public class Server extends Block {
	public 		Taxi[] ledigeTaxier = new Taxi[0];
	public		Order[] ordreList = new Order[0];
	public 		String[] queueList = new String[0];
	


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

	public Taxi taxiLogOn(Taxi bil) {
		boolean eksisterer = false;
		for (int i = 0; i < ledigeTaxier.length; i++) {
			if (ledigeTaxier[i].getTxid() == bil.getTxid()){
				break;
			}
		}
		
		if(eksisterer == false){
			ledigeTaxier = Helper.addTaxi(ledigeTaxier, bil);
			bil.setState("Free");
		}		
		
		for (int i = 0; i < ledigeTaxier.length; i++) { //sysout for feilsøking
			System.out.println("Taxi " + ledigeTaxier[i].getTxid() + " er ledig. Plass i array er" + i);
		}
				
		bil.setToConsole("Taxi med id: " + bil.getTxid() + " har logget på, action: " + bil.getAction());
		return bil;
	}

	public Taxi taxiLogOut(Taxi bil) {
				
		for (int i = 0; i < ledigeTaxier.length; i++) {
			if(bil.getTxid() == ledigeTaxier[i].getTxid()){
				ledigeTaxier = Helper.removeTaxi(ledigeTaxier, bil);
				
				break;	 
			}
		}
		
		
		bil.setToConsole("Taxi med id: " + bil.getTxid() + " har logget av, action: " + bil.getAction());
		return bil;
	}

	public Taxi taxiAccept(Taxi bil) {
		boolean harOrdre = false;
		for (int i = 0; i < ordreList.length; i++) {
			if(bil.getTxid() == ordreList[i].getTxid()){
				bil.setBesked("Du skal hente kunde med id: " + ordreList[i].getMsid() + "på adresse x");
				harOrdre = true;
			}
		}
		if (harOrdre == false){
			bil.setBesked("Du har ingen ventende ordre");
		}
		bil.setToConsole("Taxi med id " + bil.getTxid() + " har akseptert, action: " + bil.getAction());
		return bil;
	}

	public Taxi taxiBusy(Taxi bil) {
		bil.setToConsole("Taxi med id " + bil.getTxid() + " er busy, action: " + bil.getAction());
		return bil;
	}

	public Taxi taxiFree(Taxi bil) {
		bil.setToConsole("Taxi med id " + bil.getTxid() + " er nå ledig, action: " + bil.getAction());
		return bil;
	}

	public Taxi processOrder(Order ordre) {
		Taxi bil = ledigeTaxier[0];
		bil.setBesked("Vil du hente kunde med id: " + ordre.getMsid());
		
		return bil;
		
	}

	public String toConsole(Taxi bil) {
		return bil.getToConsole();
	}
		
		

}
