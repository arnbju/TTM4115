package no.ntnu.item.prosjekt.server;

import no.ntnu.item.prosjekt.client.Order;
import no.ntnu.item.prosjekt.taxiclient.Taxi;

public class Helper {
	
	public static Order[] leggTilOrder(Order[] liste, Order ordre){
		
		Order[] kopi = new Order[liste.length + 1];
		
		for (int i = 0; i < liste.length; i++) {
			kopi[i] = liste[i];
		}
			
		kopi[liste.length -1] = ordre;
			
				
		return kopi;
	}
	
	public static Taxi[] fjernTaxi(Taxi[] taxiListe, Taxi taxiBil){ // metode for å fjerne en taxi fra en Taxi-liste
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
	
	public static Taxi[] addTaxi(Taxi[] taxiListe, Taxi taxiBil){ //metode for å legge till taxi i Taxi-liste
		Taxi[] kopi = new Taxi[taxiListe.length+1];
		kopi[kopi.length-1] = taxiBil;
		
		for (int i = 0; i < kopi.length; i++) {
			kopi[i] = taxiListe[i];
		}
		return kopi;
		
	}
}
