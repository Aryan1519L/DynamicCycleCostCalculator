package com.NinetyOneSocial.cycle.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeatingBO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String seatSubPart;
	private int price;

	
	public SeatingBO() {
		//nothing
	}
	
	public SeatingBO(String seatSubPart, int price) {
		this.seatSubPart = seatSubPart;
		this.price = price;
	}

	public final String getSeatSubPart() {
		return seatSubPart;
	}

	public final void setSeatSubPart(String seatSubPart) {
		this.seatSubPart = seatSubPart;
	}

	public final int getPrice() {
		return price;
	}

	public final void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SeatingBO [seatSubPart=" + seatSubPart + ", price=" + price + "]";
	}
	
}
