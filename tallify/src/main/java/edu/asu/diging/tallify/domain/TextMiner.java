package edu.asu.diging.tallify.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextMiner {

	Map<String, Integer> getStringCount(String[] text, String[] ignoreWords) {

		Map<String, Integer> textMap = new HashMap<String, Integer>();
		Set<String> ignoreWordsSet = new HashSet<String>();

		for (String str : ignoreWords) {
			ignoreWordsSet.add(str);

		}

		for (String str : text) {

			if (!ignoreWordsSet.contains(str)) {
				if (textMap.containsKey(str)) {
					textMap.put(str, textMap.get(str) + 1);
				}

				else {
					textMap.put(str, 1);
				}
			}

		}

		return textMap;

	}

}
