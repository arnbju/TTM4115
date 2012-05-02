package no.ntnu.item.prosjekt.testesystem.component;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {
int antall = 0;

	public void printer() {
		System.out.println(antall);
	}

	public void stopped() {
		System.out.println("Stopped");
	}

}
