package com.ChainResponsibility;

import com.strategy.Strategy;

public class Contained extends CheckChainStandards{

	@Override
	protected boolean compare(String input, String standard) {
		return standard.contains(input);
	}

}
