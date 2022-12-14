package com.paesi;

public class Alias implements Bean {
	private String aliasCountry;
	private Country country;
	private String algorithm;
	private double soglia;
	public double getSoglia() {
		return soglia;
	}
	public void setSoglia(double soglia) {
		this.soglia = soglia;
	}
	private boolean approved;

	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public String getAliasCountry() {
		return aliasCountry;
	}
	public void setAliasCountry(String aliasCountry) {
		this.aliasCountry = aliasCountry;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Alias [aliasCountry=" + aliasCountry + ", country=" + country + ", algorithm=" + algorithm + ", soglia="
				+ soglia + ", approved=" + approved + "]";
	}
	
}
