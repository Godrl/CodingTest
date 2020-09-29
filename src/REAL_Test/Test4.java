package REAL_Test;

import java.util.HashMap;
import java.util.Map;

/*
 * 배열에서 특정 문자의 수 구하기
 * ex) [a, b, c, d, a, b, c, d, 가, 나, 다] --> a : 2/ b : 2/ c : 2/ 가 : 1/ 나 : 1/ 다 :1   
*/
public class Test4 {
	public static void main(String[] args) {
		String[] str = {"a", "b", "c", "d", "a", "b", "c", "d", "가", "나", "다"};
		
		Map<String,Integer> map = new HashMap<String, Integer>();

		for(String s : str) {
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		System.out.println(map.keySet() +":"+map.values());
		
		
	}
}



