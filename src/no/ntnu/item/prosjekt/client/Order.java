package no.ntnu.item.prosjekt.client;

public class Order {
	private String msid;
	private String ack;
	private String queue;
	private String request;
	private String toConsole;
	private String txid;
	
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Order(String msid){
		this.msid = msid;
	}
	
	public String getMsid() {
		return msid;
	}
	
	public void setMsid(String msid) {
		this.msid = msid;
	}
	
	public String getAck() {
		return ack;
	}
	
	public void setAck(String ack) {
		this.ack = ack;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getToConsole() {
		return toConsole;
	}

	public void setToConsole(String toConsole) {
		this.toConsole = toConsole;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}


}
