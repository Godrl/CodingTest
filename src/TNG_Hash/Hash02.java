package TNG_Hash;

import java.util.HashMap;
import java.util.Map;

/*
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.

*/
public class Hash02 {
	public static void main(String[] args) {
		String[] str = {"123","456","789"};
		Hash02_sol sol = new Hash02_sol();
		System.out.println(sol.solution(str));

	}
}

/*
 * Map.containsKey(key) --> key값을 가지고 있으면 true 없으면 false 반환
 * 
 * 전화번호를 키값으로 맵에 넣어둔 뒤 각각의 키중에 해당 번호가 있는지 검사하여 결과를 반환한다.
*/
class Hash02_sol {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,String> map = new HashMap<String,String>();
        
        for(int i=0;i<phone_book.length;i++) map.put(phone_book[i], "number");
        
        for(String s : phone_book) {
        	for(int i = 0 ; i<s.length();i++) {
        		if(map.containsKey(s.substring(0, i))) answer = false;
        	}
        }
        
             
		return answer;
    }
}