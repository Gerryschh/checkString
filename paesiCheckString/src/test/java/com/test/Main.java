package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.Contained;
import com.ChainResponsibility.Contains;
import com.ChainResponsibility.ContainsPartial;
import com.ChainResponsibility.EqualsInputCS;
import com.ChainResponsibility.EqualsStandardCS;
import com.ChainResponsibility.Jaccard;
import com.ChainResponsibility.JaroDistance;
import com.ChainResponsibility.SorensenDice;
import com.strategy.Strategy;
import com.strategy.StrategyFile;

public class Main {

	public static void main(String[] args) { 

		Strategy s = new StrategyFile();
		Map<String, List<String>> map = s.veryBigMapOfTheWorld();
		
		CheckChain checkChain = CheckChain.link(
				map,
	            new EqualsStandardCS(),
	            new Contained(),
	            new Contains(),
	            new ContainsPartial(),
	            new Jaccard(),
	            new SorensenDice(),
	            new JaroDistance(),
	            new EqualsInputCS()
	        );
		
		Scanner sc;
		try {
			sc = new Scanner (new File("./src/main/resources/dataset/150_nazioni_modified.txt"));
			sc.useDelimiter("\n");
			while(sc.hasNext()) {
				String current= sc.next().toLowerCase();
				System.out.println("Paese txt: "+ current+" Paese trovato: "+checkChain.check(current, s) );
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}   
}
