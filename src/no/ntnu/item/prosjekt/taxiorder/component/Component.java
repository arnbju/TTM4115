package no.ntnu.item.prosjekt.taxiorder.component;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

int antall = 0;

	public String msidGenerator() {
		System.out.println("Dette er inn msidGenerator");
		antall = antall + 1;
		String sessionAlias = "MSID" + Integer.toString(antall); 
		System.out.println(sessionAlias);
		return sessionAlias;
	}

}
