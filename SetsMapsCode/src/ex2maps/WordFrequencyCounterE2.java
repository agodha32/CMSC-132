/*
 * Example of using maps to keep track of instances of words.  
 * Run using command line arguments.
 * 
 */
package ex2maps;

import java.util.Map;
import java.util.*;

public class WordFrequencyCounterE2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		for (String word : args) {
			if (!map.containsKey(word)) {
				map.put(word, 1); /* First instance seen */
			} else {
				map.put(word, map.get(word) + 1);
			}
		}

		System.out.println("Words Frequency:\n");
		
		/* Creating map out of another map so we can print words in sorted order */
		map = new TreeMap<>(map);
		
		for (String word : map.keySet()) {
			System.out.println(word + "\t" + map.get(word));
		}
	}
}
