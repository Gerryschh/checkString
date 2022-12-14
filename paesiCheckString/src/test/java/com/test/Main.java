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
import com.ChainResponsibility.Levenshtein;
import com.ChainResponsibility.SorensenDice;
import com.strategy.Strategy;
import com.strategy.StrategyFile;

public class Main {

	public static void main(String[] args) { 
		Strategy s = new StrategyFile();
		Map<String, List<String>> map = s.veryBigMapOfTheWorld();
		/*CheckChain es = new EqualsStandardCS();
		CheckChain cd = new Contained(); cd.setNextChain(es);
		CheckChain cs = new Contains(); cs.setNextChain(cd);
		CheckChain cp = new ContainsPartial(); cp.setNextChain(cs);
		CheckChain j = new Jaccard(0.6); j.setNextChain(cp);
		CheckChain lev = new Levenshtein(2); lev.setNextChain(cd);
		CheckChain sd = new SorensenDice(0.6); sd.setNextChain(j);
		CheckChain jd = new JaroDistance(0.8); jd.setNextChain(lev);
		CheckChain ei = new EqualsInputCS(); ei.setNextChain(jd);*/
		
		CheckChain es = new EqualsStandardCS();
		CheckChain cs = new Contains(); cs.setNextChain(es);
		CheckChain lev2 = new Levenshtein(2); lev2.setNextChain(cs);
		CheckChain lev1 = new Levenshtein(1); lev1.setNextChain(lev2);
		
		lev1.setStrategy(s);
		//cs.setStrategy(s);
		
		Scanner sc;
		try {
			sc = new Scanner (new File("./src/main/resources/dataset/nazioni_test"));
			sc.useDelimiter("\n");
			while(sc.hasNext()) {
				String current= sc.next();
				cs.check(current.trim());
				//System.out.println("Paese txt: "+ current+" Paese trovato: "+checkChain.check(current, s) );
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}   
}
