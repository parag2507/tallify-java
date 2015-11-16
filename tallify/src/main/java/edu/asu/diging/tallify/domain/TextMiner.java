package edu.asu.diging.tallify.domain;

import java.util.HashMap;
import java.util.Map;

public class TextMiner {
	
	Map<String,Integer> getStringCount(String[] text){
		
		Map<String,Integer> textMap = new HashMap<String,Integer>();
		
		for(String str : text){
			
			if(textMap.containsKey(str)){
				textMap.put(str, textMap.get(str)+1);
			}
			
			else{
				textMap.put(str, 1);
			}
			
		}
		
		return textMap;
		
	}
}
