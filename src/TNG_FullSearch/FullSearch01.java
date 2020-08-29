package TNG_FullSearch;

import java.util.ArrayList;
import java.util.List;

/*
 * 수포자는 수학을 포기한 사람의 준말입니다. 
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
*/
public class FullSearch01 {
	public static void main(String[] args) {
		Solution sol = new Solution();
				
		int[] answers = {1,3,2,4,2};
		for(int ans : sol.solution(answers)) System.out.print(ans+" ");
	}
}

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
		int count1 = 0, count2 = 0, count3 = 0;
		int[] p1= {1,2,3,4,5};
		int[] p2= {2,1,2,3,2,4,2,5};
		int[] p3= {3,3,1,1,2,2,4,4,5,5};

//		i % array.length - 배열의 길이를 넘어가지 않게 나머지를 구하면 계속 반복된다
		for(int i=0;i<answers.length;i++) {
			if(answers[i]==p1[i%5]) count1++;
			if(answers[i]==p2[i%8]) count2++;
			if(answers[i]==p3[i%10]) count3++;
		}
			
//		Math.max(a,b) 큰 숫자를 반환한다. 같을때는 둘다 반환
		int max = Math.max(count1, Math.max(count2, count3));
		
		List<Integer> arr=new ArrayList<Integer>();
		if(max==count1) arr.add(1);
		if(max==count2) arr.add(2);
		if(max==count3) arr.add(3);
		
		answer = new int[arr.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i]=(int) arr.get(i);
			System.out.print(answer[i]+" ");
		}
		System.out.println();
		return answer;
    }
}
