package com.ChainResponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strategy.Strategy;

public abstract class CheckChain {
	private CheckChain nextChain;
	private static List<String> standards=new ArrayList<String>();
	private static Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	public void setNextChain(CheckChain nextChain) {
		this.nextChain=nextChain;
	}
	public abstract String check(String input, Strategy s);
	
	public CheckChain getChain() {
		return nextChain;
	}
	public List<String> getStandards() {
		return standards;
	}
	public static void setStandards(List<String> standardsList) {
		standards = standardsList;
	}
	
	
	protected String checkNext(String input, Strategy s) {
		if (nextChain == null) {
            s.addStupidInput(input);
        	return "Input aggiunto al DB";
        }
        return nextChain.check(input, s);
	}
	
	public static CheckChain link(Map<String, List<String>> map, CheckChain first, CheckChain... chain) {
		CheckChain head = first;
		setMap(map);
		setStandards(new ArrayList<String>(map.keySet()));
        for (CheckChain nextInChain: chain) {
            head.nextChain = nextInChain;
            head = nextInChain;
        }
        return first;
    }
	public static Map<String, List<String>> getMap() {
		return map;
	}
	public static void setMap(Map<String, List<String>> map) {
		CheckChain.map = map;
	}
	
}
