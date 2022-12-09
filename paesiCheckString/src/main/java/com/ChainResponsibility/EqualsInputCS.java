package com.ChainResponsibility;

import com.strategy.Strategy;

public class EqualsInputCS extends CheckChain {

	@Override
	public String check(String input, Strategy s) {
		//Prende il riferimento di country dal DB
		for(String key: super.getMap().keySet()) {
			if(super.getMap().get(key).contains(input)) {
				System.out.println("Trovato con equalsInput");
				return key;
			}
		}
		
		return super.checkNext(input, s);
	}

}
