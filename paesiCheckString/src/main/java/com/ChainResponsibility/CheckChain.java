package com.ChainResponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strategy.Strategy;

public abstract class CheckChain {
	private CheckChain nextChain;
	private static Strategy strategy;
	
	public void setNextChain(CheckChain nextChain) {
		this.nextChain=nextChain;
	}
	public final String check(String input) {
		String result = checkInternal(input);
			/*if(result != null) {
				return result;
			} else*/ return checkNext(input);
		}
	protected abstract String checkInternal(String input);
	
	private CheckChain getChain() {
		return nextChain;
	}
	
	
	protected String checkNext(String input) {
		if (nextChain == null) {
            strategy.addStupidInput(input);
        	return "Input aggiunto al DB";
        }
        return nextChain.check(input);
	}
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
}
