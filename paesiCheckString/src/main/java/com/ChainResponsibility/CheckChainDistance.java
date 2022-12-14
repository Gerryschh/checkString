package com.ChainResponsibility;

public abstract class CheckChainDistance extends CheckChainStandards {
	private double distance;

	public CheckChainDistance(double soglia) {
		super();
		this.distance = soglia;
	}

	protected String getNameDetails() {
		return "-" + distance;
	}

	public double getDistance() {
		return distance;
	}
	
}
