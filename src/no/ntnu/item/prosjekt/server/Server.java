package no.ntnu.item.prosjekt.server;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.prosjekt.client.Order;
import no.ntnu.item.prosjekt.taxiclient.Taxi;



public class Server extends Block {
	public 		Taxi[] ledigeTaxier = new Taxi[0];
	public		Taxi[] busyTaxier = new Taxi[0];
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
		System.out.println("Ledige taxier har lengde: " + ledigeTaxier.length);
		boolean eksisterer = false;
		for (int i = 0; i < ledigeTaxier.length; i++) {
			if (ledigeTaxier[i].getTxid() == bil.getTxid()){
				eksisterer = true;
				break;
			}
		}
		
		if(eksisterer == false){
			ledigeTaxier = Helper.addTaxi(ledigeTaxier, bil);
			bil.setBesked("Du har blitt logget på systemet");
			bil.setState("Free");
		}else{
			bil.setBesked("Du var allerede logget på systemet");
		}
			
		if(queueList.length != 0){
			for (int i = 0; i < ordreList.length; i++) {
				if(ordreList[i].getMsid()==queueList[0]){
					processOrder(ordreList[i]);
				}
			}
		}
		
		for (int i = 0; i < ledigeTaxier.length; i++) { //sysout for feilsøking
			System.out.println("Taxi " + ledigeTaxier[i].getTxid() + " er ledig. Plass i array er" + i);
		}
				
		bil.setToConsole("Taxi med id: " + bil.getTxid() + " har logget på, action: " + bil.getAction());
		return bil;
	}

	public Taxi taxiLogOut(Taxi bil) {
		System.out.println("Ledige taxier har lengde: " + ledigeTaxier.length);
		if(bil.getState()=="Free"){
			ledigeTaxier = Helper.removeTaxi(ledigeTaxier, bil);
			bil.setState("Logged Off");
		}else if(bil.getState()=="Busy"){
			busyTaxier = Helper.removeTaxi(busyTaxier, bil);
			bil.setState("Logged Off");
		}else{
			bil.setBesked("Du har den ukjente staten: " + bil.getState());
		}
		
		
		bil.setToConsole("Taxi med id: " + bil.getTxid() + " har logget av, action: " + bil.getAction());
		return bil;
	}

	public Taxi taxiAccept(Taxi bil) {
		boolean harOrdre = false;
		for (int i = 0; i < ordreList.length; i++) {
			System.out.println("Ordreid: " + ordreList[i].getMsid() + " TaxiID: " + ordreList[i].getTxid());
			if(bil.getTxid() == ordreList[i].getTxid()){
				bil.setBesked("Du skal hente kunde med id: " + ordreList[i].getMsid() + "på adresse x");
				harOrdre = true;
			}
		}
		if (harOrdre == false){
			bil.setBesked("Du har ingen ventende ordre");
		}
		bil.setToConsole("Taxi med id " + bil.getTxid() + " har akseptert, action: " + bil.getAction() + "\n Ledige taxier: " + ledigeTaxier.length + " Busy Taxier: " + busyTaxier.length);
		return bil;
	}

	public Taxi taxiBusy(Taxi bil) {
		System.out.println("-------");
		System.out.println(bil.getState());
		boolean eksisterer = false;
		for (int i = 0; i < ordreList.length; i++) {
			if(bil.getTxid() == ordreList[i].getTxid()){
				bil.setState("Busy");
				bil.setMsid("Avvist");
				bil.setBesked("Du har avvist ordren fra kunde: " + ordreList[i].getMsid() + "\n Og din state er nå satt til " + bil.getState());
				eksisterer = true;
				processOrder(ordreList[i]);
				break;
			}
		}
		if(eksisterer == false && bil.getState()=="Free"){
			bil.setState("Busy");
			bil.setBesked("Din state er nå " + bil.getState());
			ledigeTaxier = Helper.removeTaxi(ledigeTaxier, bil);
			busyTaxier = Helper.addTaxi(busyTaxier, bil);
			
			System.out.println("Taxi med id: " +bil.getTxid() + "er nå endret til " + bil.getState());
			
		}
		
		bil.setToConsole("Taxi med id " + bil.getTxid() + " er "+ bil.getState()+ ", action: " + bil.getAction());
		return bil;
	}

	public Taxi taxiFree(Taxi bil) {
		if(bil.getState()=="Free"){
				bil.setBesked("Du er allerde i staten Free");
		}else if(bil.getState()=="Busy"){
			bil.setState("Free");
			bil.setBesked("Du er nå i state Free");
			ledigeTaxier = Helper.addTaxi(ledigeTaxier, bil);
			busyTaxier = Helper.removeTaxi(busyTaxier, bil);
			System.out.println("Taxi med id: " + bil.getTxid() + "er nå endret til " + bil.getState());
		}
		else{
			bil.setBesked("Du er i den ukjente staten: " + bil.getState());
		}
		bil.setToConsole("Taxi med id " + bil.getTxid() + " er nå "+bil.getState()+", action: " + bil.getAction());
		return bil;
	}

	public Taxi processOrder(Order ordre) {
		System.out.println("LedigeTaxier: " + ledigeTaxier.length + " BusyTaxier: " + busyTaxier.length + " OrderID: " +ordre.getMsid());
		int taxiBil = 0; //henter bilen som har vært lengst ledig
		Taxi bil = ledigeTaxier[taxiBil];
		bil.setBesked("Vil du hente kunde med id: " + ordre.getMsid());
		bil.setMsid(ordre.getMsid());
		bil.setState("Busy");
		
		if(ordre.getTxid()==null){
				ordreList = Helper.addOrder(ordreList, ordre);
		}
		ordre.setTxid(bil.getTxid());
		
		ledigeTaxier = Helper.removeTaxi(ledigeTaxier, bil);
		busyTaxier = Helper.addTaxi(busyTaxier, bil);
		
		System.out.println("Ordre lagt til: " + ordreList[0].getMsid() + " og sendt til taxi: " + bil.getTxid());
		
		return bil;
		
	}

	public String toConsole(Taxi bil) {
		return bil.getToConsole();
	}

	public Order taxiToOrder(Taxi taxi) {
		String msid = taxi.getMsid();
		Order o = ordreList[0];
		for (int i = 0; i < ordreList.length; i++) {
			if (ordreList[i].getMsid() == msid){
			o = ordreList[i];
			o.setAck("Du blir hentet av taxi " + msid);
			}
		}
		return o;
	}
}
