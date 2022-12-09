package com.ChainResponsibility;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.strategy.Strategy;

public class SorensenDice extends CheckChain {
	private final Pattern SPACE_REG = Pattern.compile("\\s+");
	private int k = 4;

	@Override
	public String check(String input, Strategy s) {
		for(String word : super.getStandards()) {
			double sor = similarity(word, input);
			if (sor > 0.6) {
				System.out.println("trovato con SorensenDice con :" + sor);
				return input;
			}
		}
        	
		return super.checkNext(input, s);
	}

	public final Map<String, Integer> getProfile(final String string) {
		HashMap<String, Integer> shingles = new HashMap<String, Integer>();

		String string_no_space = SPACE_REG.matcher(string).replaceAll(" ");
		for (int i = 0; i < (string_no_space.length() - k + 1); i++) {
			String shingle = string_no_space.substring(i, i + k);
			Integer old = shingles.get(shingle);
			if (old != null) {
				shingles.put(shingle, old + 1);
			} else {
				shingles.put(shingle, 1);
			}
		}

		return Collections.unmodifiableMap(shingles);
	}

	public final double similarity(final String s1, final String s2) {
		if (s1 == null) {
			throw new NullPointerException("s1 must not be null");
		}

		if (s2 == null) {
			throw new NullPointerException("s2 must not be null");
		}

		if (s1.equals(s2)) {
			return 1;
		}

		Map<String, Integer> profile1 = getProfile(s1);
		Map<String, Integer> profile2 = getProfile(s2);

		Set<String> union = new HashSet<String>();
		union.addAll(profile1.keySet());
		union.addAll(profile2.keySet());

		int inter = 0;

		for (String key : union) {
			if (profile1.containsKey(key) && profile2.containsKey(key)) {
				inter++;
			}
		}

		return 2.0 * inter / (profile1.size() + profile2.size());
	}

	/**
	 * Distance is computed as 1 - similarity.
	 * 
	 * @param s1 The first string to compare.
	 * @param s2 The second string to compare.
	 * @return 1 - the Jaccard similarity.
	 * @throws NullPointerException if s1 or s2 is null.
	 */
	public final double distance(final String s1, final String s2) {
		return 1 - similarity(s1, s2);
	}
}
