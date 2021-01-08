package com.NinetyOneSocial.cycle.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChainAssemblyBO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String caSubPart;
	private int price;
	
	public ChainAssemblyBO() {
		//nothing
	}

	
	public ChainAssemblyBO(String caSubPart, int price) {
		super();
		this.caSubPart = caSubPart;
		this.price = price;
	}


	/**
	 * @return the caSubPart
	 */
	public final String getCaSubPart() {
		return caSubPart;
	}

	/**
	 * @param caSubPart the caSubPart to set
	 */
	public final void setCaSubPart(String caSubPart) {
		this.caSubPart = caSubPart;
	}

	/**
	 * @return the price
	 */
	public final int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public final void setPrice(int price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChainAssemblyBO [caSubPart=" + caSubPart + ", price=" + price + "]";
	}
	
	
	

}
