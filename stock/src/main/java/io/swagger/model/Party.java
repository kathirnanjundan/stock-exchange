package io.swagger.model;

public class Party implements IParty {
	
	private String party;
	private String symbol;
	private String stock;
	private Integer price;
	private String status;
	
	@Override
	public String getStatus() {
		return status;
	}
	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String getParty() {
		return party;
	}
	@Override
	public void setParty(String party) {
		this.party = party;
	}
	@Override
	public String getSymbol() {
		return symbol;
	}
	@Override
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	@Override
	public String getStock() {
		return stock;
	}
	@Override
	public void setStock(String stock) {
		this.stock = stock;
	}
	@Override
	public Integer getPrice() {
		return price;
	}
	@Override
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Party [party=" + party + ", symbol=" + symbol + ", stock=" + stock + ", price=" + price + ", status="
				+ status + "]";
	}
}
