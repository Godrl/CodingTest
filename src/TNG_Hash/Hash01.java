package TNG_Hash;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
	완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
*/
public class Hash01 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"kiki", "eden"};
		
		Hash01_sol01 sol01 = new Hash01_sol01();
		System.out.println(sol01.solution(participant, completion));
		
		Hash01_sol02 sol02 = new Hash01_sol02();
		System.out.println(sol02.solution(participant, completion));
	}

}

/*
 * 풀이1
 * 	Arrays.sort() - 오름차순 정렬
 * 	정렬 후 비교를 통해 같지 않은 부분을 반환하여 answer에 담은 다음 리턴
 * 	완주자와 참여자의 길이가 1차이나므로 마지막 사람은 무조건 완주하지 못한 사람이다.
 *	고로 i를 for문 밖에 선언하여 마지막 참여자도 추가해줘야 한다.
*/
class Hash01_sol01 {
    public String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i=0;
		for(i=0;i<completion.length;i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		answer += participant[i];
		return answer;
    }
}

/*
 * 풀이2
 * 	 
 * 	맵에 참여자들을 모두 담고 값을 1로 만들고 같은 이름을 가진 완주자들의 값을 -1 해준다.
 * 	값이 0이 아닌 참여자들을 반환한다. 
 * 	조건에서 참여자와 완주자의 차이가 1이라고 했으므로 한명이 나오면 바로 함수를 빠져나가도 된다.
 * 
 *   Map.getOrDefault(key,defaulValue) - map에 key값이 있다면 key를 없다면 defaulValue를 반환
 *   Map.keySet() - map에 포함된 모든 key를 하나의 집합(Set)으로 반환
*/
class Hash01_sol02 {
    public String solution(String[] participant, String[] completion) {
		String answer = "";
				
		Map<String,Integer> hash = new HashMap<>();
		
		for(String part : participant) {
			hash.put(part, hash.getOrDefault(part, 0)+1);
			System.out.println(hash.keySet());
			System.out.println(hash.values());
		}
		for(String compl : completion) {
			hash.put(compl, hash.get(compl)-1);
		}
		for(String fail : hash.keySet()) {
			if(hash.get(fail) != 0) {
				answer = fail;
				break;
			}
		}
		return answer;
    }
}

