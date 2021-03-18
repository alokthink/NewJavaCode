import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequencyCount {

	public static void main(String[] args) {
//		List<String> list = Arrays.asList("B", "A", "a", "C", "B", "A");
//		Set<String> set=new HashSet<>();
//		for(String s1:list) {
//			set.add(s1.toUpperCase());
//			//System.out.println(s1.toUpperCase()+":"+Collections.frequency(list, s1.toUpperCase()));
//		}
//		for(String s2:set) {
//			//set.add(s1.toUpperCase());
//			System.out.println(s2+":"+Collections.frequency(list, s2.toUpperCase()));
//		}
//		
//
		
		List<String> list = Arrays.asList("B", "A", "a", "C", "B", "A");

		Map<String, Integer> frequencyMap = new HashMap<>();
		for (String s: list) {
			Integer count = frequencyMap.get(s.toLowerCase());
			if (count == null)
				count = 0;

			frequencyMap.put(s.toLowerCase(), count + 1);
		}

		for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
