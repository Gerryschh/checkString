package com.paesi;

public class Country implements Bean {
	private String countryName;
	private String alphacode;
	
	public String getAlphacode() {
		return alphacode;
	}

	public void setAlphacode(String alphacode) {
		this.alphacode = alphacode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
