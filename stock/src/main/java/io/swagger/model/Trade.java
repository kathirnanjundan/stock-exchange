package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-11T16:56:57.149Z")

public class Trade  implements ITrade {
  @JsonProperty("seller")
  private String seller = null;

  @JsonProperty("buyer")
  private String buyer = null;

  @JsonProperty("stock")
  private String stock = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("date")
  private String date = null;
  
  private String status="";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Trade seller(String seller) {
		this.seller = seller;
		return this;
	}

  /**
   * Get seller
   * @return seller
  **/
  @ApiModelProperty(value = "")


  public String getSeller() {
    return seller;
  }

  public void setSeller(String seller) {
    this.seller = seller;
  }

  public Trade buyer(String buyer) {
    this.buyer = buyer;
    return this;
  }

  /**
   * Get buyer
   * @return buyer
  **/
  @ApiModelProperty(value = "")


  public String getBuyer() {
    return buyer;
  }

  public void setBuyer(String buyer) {
    this.buyer = buyer;
  }

  public Trade stock(String stock) {
    this.stock = stock;
    return this;
  }

  /**
   * Get stock
   * @return stock
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getStock() {
    return stock;
  }

  public void setStock(String stock) {
    this.stock = stock;
  }

  public Trade price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Trade date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trade trade = (Trade) o;
    return Objects.equals(this.seller, trade.seller) &&
        Objects.equals(this.buyer, trade.buyer) &&
        Objects.equals(this.stock, trade.stock) &&
        Objects.equals(this.price, trade.price) &&
        Objects.equals(this.date, trade.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seller, buyer, stock, price, date);
  }

  @Override
public String toString() {
	return "Trade [seller=" + seller + ", buyer=" + buyer + ", stock=" + stock + ", price=" + price + ", date=" + date
			+ ", status=" + status + "]";
}

/**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

