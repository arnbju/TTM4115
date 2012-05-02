package no.ntnu.item.prosjekt.egencounter;

import no.ntnu.item.arctis.runtime.Block;

public class EgenCounter extends Block {

	public int antall = 4;

	public boolean telle() {
		//String id = Integer.toString(antall);
		antall = antall - 1;
		return (antall>0);
	}

}
