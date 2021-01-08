package com.NinetyOneSocial.cycle.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FrameBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String frameName;
	private int price;
	
	public FrameBO() {
		// nothing
	}

	public FrameBO(String frameName, int price) {
		this.frameName = frameName;
		this.price = price;
	}

	public final String getFrameName() {
		return frameName;
	}

	public final void setFrameName(String frameName) {
		this.frameName = frameName;
	}

	public final int getPrice() {
		return price;
	}

	public final void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FrameBO [frameName=" + frameName + ", price=" + price + "]";
	}

}
