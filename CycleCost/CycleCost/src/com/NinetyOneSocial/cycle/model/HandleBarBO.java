package com.NinetyOneSocial.cycle.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HandleBarBO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String hbSubPart;
	private int price;
	
	public HandleBarBO() {
		//nothing
	}
	
	public HandleBarBO(String HB_SubPart, int price) {
		this.hbSubPart = HB_SubPart;
		this.price = price;
	}

	public final String getHB_SubPart() {
		return hbSubPart;
	}

	public final void setHB_SubPart(String HB_SubPart) {
		this.hbSubPart = HB_SubPart;
	}

	public final int getPrice() {
		return price;
	}

	public final void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HandleBarBO [HB_SubPart=" + hbSubPart + ", price=" + price + "]";
	}

}
