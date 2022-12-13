package com.strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StrategyFile implements Strategy {
	
	private static Set<String> standards;

	@Override
	public String getAliases(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
	//NON HO UN DB
	@Override
	public Map<String, List<String>> veryBigMapOfTheWorld() {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		try {
			Scanner sc= new Scanner (new File("./src/main/resources/dataset/data_csv.txt.csv"));
			sc.useDelimiter("\n");
			while(sc.hasNext()) {
				//System.out.println(sc.next());
				String current= sc.next();
				if (current.contains("\"")) {
					String[] dati=current.trim().replaceAll("\"", "").split(",");
					List<String> x= new ArrayList<String>();
					x.add(dati[2]);
					String concatenata= dati[1].concat(" ").concat(dati[0]);
					x.add(concatenata);
					map.put(dati[0], x);
				}
				else {
					String[] dati=current.trim().split(","); 
					//dati[0] contiene il country, dati[1] contiene l'alias
					List<String> x= new ArrayList<String>();
					x.add(dati[1]);
					map.put(dati[0], x);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setStandards(map.keySet());
		return map;
	}

	@Override
	public void addStupidInput(String input) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		String result = "";
		for(String paese: this.veryBigMapOfTheWorld().keySet()) {
			result += "Paese: "+paese+
					"      Aliases: "+this.veryBigMapOfTheWorld().get(paese).toString()+
					"\n";
		}
		return result;
	}
	public Set<String> getStandards() {
		return standards;
	}
	public static void setStandards(Set<String> standards) {
		StrategyFile.standards = standards;
	}
	
	

}
