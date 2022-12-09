package com.ChainResponsibility;

import com.strategy.Strategy;

public class Contained extends CheckChain{

	@Override
	public String check(String input, Strategy s) {
		//SE CONTIENE I PAESI
		//ES: input ITALIA2, Standard: ITALIA
		for (String singleStandard : super.getStandards()) {
			if(input.contains(singleStandard)) {
				System.out.println("Trovato con Contained");
				return singleStandard;
			}
		}
		return super.checkNext(input, s);
	}

}
