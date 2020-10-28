package io.swagger.model;

import java.io.Serializable;

public interface IParty extends Serializable {

	void setPrice(Integer price);

	Integer getPrice();

	void setStock(String stock);

	String getStock();

	void setSymbol(String symbol);

	String getSymbol();

	void setParty(String party);

	String getParty();
	
	String getStatus();
	
	void setStatus(String status);

}
