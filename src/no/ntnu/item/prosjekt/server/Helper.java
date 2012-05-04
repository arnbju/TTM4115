package no.ntnu.item.prosjekt.server;

import no.ntnu.item.prosjekt.client.Order;
import no.ntnu.item.prosjekt.taxiclient.Taxi;

public class Helper {
	
	public static Order[] addOrder(Order[] liste, Order ordre){
		Order[] kopi = new Order[liste.length + 1];
		kopi[liste.length] = ordre;
		
		for (int i = 0; i < liste.length; i++) {
			kopi[i] = liste[i];
		}
		return kopi;
	}
	
	public static Order[] removeOrder(Order[] liste, Order order){
		Order[] kopi = new Order[liste.length-1];
		int plass = 0 ;
		
		for (int i = 0; i < liste.length; i++) {
			if (liste[i].getMsid() == order.getMsid()){
				plass = i;
			}
		}
		for (int i = 0; i < plass; i++) {
			kopi[i] = liste[i];	
		}
		for (int i = plass; i < kopi.length; i++) {
			kopi[i] = liste[i+1];
		}
		return kopi;
	}
	
	public static Taxi[] removeTaxi(Taxi[] taxiListe, Taxi taxiBil){ // metode for å fjerne en taxi fra en Taxi-liste
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
		for (int i = plass; i < kopi.length; i++) {
			kopi[i] = taxiListe[i+1];
		}
		return kopi;
		}
	
	public static Taxi[] addTaxi(Taxi[] taxiListe, Taxi taxiBil){ //metode for å legge till taxi i Taxi-liste
		Taxi[] kopi = new Taxi[taxiListe.length+1];
		kopi[kopi.length-1] = taxiBil;
		
		for (int i = 0; i < taxiListe.length; i++) {
			kopi[i] = taxiListe[i];
		}
		return kopi;
		
	}
	
	public static String[] addString(String[] liste, String string){
		String[] kopi = new String[liste.length + 1];
		kopi[liste.length] = string;
		
		for (int i = 0; i < liste.length; i++) {
			kopi[i] = liste[i];
		}
		return kopi;
	}
	
	public static String[] removeString(String[] liste, String string){
		String[] kopi = new String[liste.length-1];
		int plass = 0;
		
		for (int i = 0; i < liste.length; i++) {
			if (kopi[i] == liste[i]){
				plass = i;
				break;
			}
		}
		for (int i = 0; i < plass; i++) {
			kopi[i] = liste[i];
		}
		for (int i = plass; i < kopi.length; i++) {
			kopi[i]=liste[i+1];
		}
		return kopi;
	}
	
	public static int getQueueNr(Order ordre, Order[] liste){
		int plass = 0;
		for (int i = 0; i < liste.length; i++) {
			if(ordre.getMsid() == liste[i].getMsid()){
				plass = i;
			}
		}
		return plass;
	}
}
