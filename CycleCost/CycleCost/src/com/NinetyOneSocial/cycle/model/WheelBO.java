package com.NinetyOneSocial.cycle.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WheelBO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String wheelSubPart;
	private int price;
	
	public WheelBO() {
		//nothing
	}
	
	public WheelBO(String wheelSubPart, int price) {
		super();
		this.wheelSubPart = wheelSubPart;
		this.price = price;
	}

	public final String getWheelSubPart() {
		return wheelSubPart;
	}

	public final void setWheelSubPart(String wheelSubPart) {
		this.wheelSubPart = wheelSubPart;
	}

	public final int getPrice() {
		return price;
	}

	public final void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "WheelBO [wheelSubPart=" + wheelSubPart + ", price=" + price + "]";
	}
	
	
}
