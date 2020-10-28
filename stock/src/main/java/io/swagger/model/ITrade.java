package io.swagger.model;

import java.io.Serializable;

public interface ITrade extends Serializable {

	public String getStatus();

	public void setStatus(String status);

	public Trade seller(String seller);

	public String getSeller();

	public void setSeller(String seller);

	public Trade buyer(String buyer);

	public String getBuyer();

	public void setBuyer(String buyer);

	public Trade stock(String stock);

	public String getStock();

	public void setStock(String stock);

	public Trade price(Double price);

	public Double getPrice();

	public void setPrice(Double price);

	public Trade date(String date);

	public String getDate();

	public void setDate(String date);
}
