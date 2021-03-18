import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCount2 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("B", "A", "a", "C", "B", "A");
		Map<String,Integer> map=new HashMap<>();
		
		for(String str:list) {
			Integer count=map.get(str);
			if(count==null) {
				count=0;
			}
			map.put(str, count+1);
		}
		
		for(Map.Entry<String,Integer> intr:map.entrySet()) {
			System.out.println(intr.getKey()+":"+intr.getValue());
		}

	}

}
