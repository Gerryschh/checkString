package com.ChainResponsibility;

import java.util.List;

import com.strategy.Strategy;

public class EqualsStandardCS extends CheckChain{

	@Override
	public String check(String input, Strategy s) {
		if(super.getStandards().contains(input)){
			System.out.println("Hai indicato: " + input);
			return input;
		}else{
			return super.getChain().check(input, s);
		}
		
	}

}
