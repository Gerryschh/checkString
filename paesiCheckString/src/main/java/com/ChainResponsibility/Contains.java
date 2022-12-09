package com.ChainResponsibility;

import com.strategy.Strategy;

public class Contains extends CheckChain {


	@Override
	public String check(String input, Strategy s) {
		
		//SE E' CONTENUTA NEI PAESI, CONTAINS() E' CASE SENSITIVE E TIENE CONTO ANCHE DEGLI SPAZI
		//ES: input: ITA, Standard: ITALIA
		for (String singleStandard : super.getStandards()) {
			if(singleStandard.contains(input)) {
				System.out.println("Trovato con Contains");
				return singleStandard;
			}
		}
		return super.checkNext(input, s);

	}

}
