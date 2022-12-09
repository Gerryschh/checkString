package com.test;

import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.Contained;
import com.ChainResponsibility.Contains;
import com.ChainResponsibility.ContainsPartial;
import com.ChainResponsibility.EqualsInputCS;
import com.ChainResponsibility.EqualsStandardCS;
import com.ChainResponsibility.Jaccard;
import com.ChainResponsibility.JaroDistance;
import com.ChainResponsibility.SorensenDice;
import com.Gerardo.ConnectionToDB;
import com.strategy.Strategy;
import com.strategy.StrategyDB;

public class Main {

	public static void main(String[] args) { 
		
		Strategy s = new StrategyDB();
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
		
		System.out.println(checkChain.check("khorea del sud", s) );
		System.out.println("test#6");

	}   
}
