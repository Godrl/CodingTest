package TNG_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String,Integer> hash = new HashMap<>();
		hash.put("apple",1);
		hash.put("grape",2);
		hash.put("peach",3);
		hash.put("orange",4);
		
		System.out.println(hash);
		System.out.println(hash.keySet());
		
	}
}
