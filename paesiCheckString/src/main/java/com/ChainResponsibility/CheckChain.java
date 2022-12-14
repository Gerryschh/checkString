package com.ChainResponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.AliasDao;
import com.dao.CountryDao;
import com.dao.impl.AliasDaoImpl;
import com.dao.impl.CountryDaoImpl;
import com.paesi.Alias;
import com.paesi.Country;
import com.strategy.Strategy;

public abstract class CheckChain {
	private CheckChain nextChain;
	private static Strategy strategy;
	private AliasDao dao = new AliasDaoImpl();
	private CountryDao cdao = new CountryDaoImpl();	
	
	
	public void setNextChain(CheckChain nextChain) {
		this.nextChain=nextChain;
	}
	public final String check(String input) {
		String result = checkInternal(input);
			
		if(result != null) {
			Alias a = new Alias();
			a.setAliasCountry(input);
			Country c = cdao.get(result);
			a.setCountry(c);
			a.setAlgorithm(this.getClass().getSimpleName());
			a.setApproved(false);
			a.setSoglia(0);
			dao.create(a);
			//return result;
		}
		//non ho trovato la soluzione, procedo col successivo se c'è
		if (nextChain!= null)
			return this.nextChain.check(input);
		else {
			strategy.addStupidInput(input);
        	return null;
		}
		}
	protected abstract String checkInternal(String input);
	
	private CheckChain getChain() {
		return nextChain;
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
}
