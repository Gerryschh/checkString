package com.strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Strategy {
	public String getAliases(String alias);
	public Map<String,List<String>> veryBigMapOfTheWorld();
	public void addStupidInput(String input);
	
	public Set<String> getStandards();
}
