package com.strategy;

import java.util.List;
import java.util.Map;

public interface Strategy {
	public String getAliases(String alias);
	public Map<String,List<String>> veryBigMapOfTheWorld();
	public void addStupidInput(String input);
}
