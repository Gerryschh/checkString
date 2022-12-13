package com.ChainResponsibility;

import java.util.ArrayList;
import java.util.List;

import com.strategy.Strategy;

public abstract class CheckChainStandards extends CheckChain {
	
	public final String checkInternal(String input) {
		for (String standard : getStrategy().getStandards()) {
			if(compare(input, standard)) {
				System.out.println(input + "-" + standard + " trovato con " + this.getClass().getSimpleName());
				return standard;
			}
		}
		return checkNext(input);
	};
	
	protected abstract boolean compare(String input, String standard);
	
}
