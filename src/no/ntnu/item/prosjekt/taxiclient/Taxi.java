package no.ntnu.item.prosjekt.taxiclient;

public class Taxi {
	private String txid;
	private String action;
	private String state;
	private String besked;
	private String toConsole;
	private String msid;

	public Taxi(String txid){
		System.out.println("Taxi constructor: " + txid);
		this.txid = txid;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBesked() {
		return besked;
	}

	public void setBesked(String besked) {
		this.besked = besked;
	}

	public String getToConsole() {
		return toConsole;
	}

	public void setToConsole(String toConsole) {
		this.toConsole = toConsole;
	}

	public String getMsid() {
		return msid;
	}

	public void setMsid(String msid) {
		this.msid = msid;
	}
	
}
