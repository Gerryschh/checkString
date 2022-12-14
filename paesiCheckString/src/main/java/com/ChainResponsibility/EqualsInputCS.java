package com.ChainResponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strategy.Strategy;

public class EqualsInputCS extends CheckChain {

	@Override
	public String checkInternal(String input) {
		Map<String, List<String>> map = getStrategy().veryBigMapOfTheWorld();
		//Prende il riferimento di country dal DB
		for(String key: map.keySet()) {
			if(map.get(key).contains(input)) {
				System.out.println("Trovato con equalsInput");
				return key;
			}
		}
		return super.checkNext(input);
	}

}
