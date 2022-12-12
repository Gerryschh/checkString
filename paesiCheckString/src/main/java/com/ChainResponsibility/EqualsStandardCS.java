package com.ChainResponsibility;

import java.util.List;

import com.strategy.Strategy;

public class EqualsStandardCS extends CheckChainStandards{

	@Override
	protected boolean compare(String input, String standard) {
		return input.equals(standard);
	}

}
