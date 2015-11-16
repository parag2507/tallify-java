package edu.asu.diging.tallify.web;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.diging.tallify.domain.TextMine;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView student() {

		ModelAndView model = new ModelAndView("home");
		model.addObject("command", new TextMine());
		return model;
	}

	@RequestMapping(value = "/processText")
	public ModelAndView processDimension(
			@ModelAttribute("SpringWeb") TextMine input) {

		ModelAndView model = new ModelAndView("home");
		model.addObject("command", input);

		String text = input.getText();
		String stopWords = input.getStopWords();

		String splitText[] = text.split(" ");
		String ignoreText[] = stopWords.split(",");

		model.addObject("mapOfStringCount",
				getStringCount(splitText, ignoreText));

		return model;
	}

	private Map<String, Integer> getStringCount(String[] text,
			String[] ignoreWords) {

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
		return sortByValue(textMap);

	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
