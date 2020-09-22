package TNG_Greedy;

/*
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.

입출력 예
number		k	return
1924		2	94
1231234		3	3234
4177252841	4	775841
*/
public class Greedy02 {
	public static void main(String[] args) {
		Greedy02_Solution sol = new Greedy02_Solution();
		
		System.out.println(sol.solution("1924", 2));
		System.out.println(sol.solution("1231234", 3));
		System.out.println(sol.solution("417725841", 4));
		
	}
}

/*
 * String.charAt(int index) --> index번째 문자열을 반환
 * 
 * StringBuilder.appen(char c) --> 문자 c 추가
 * 
 *  toString() --> 객체를 문자로 반환 
*/
class Greedy02_Solution {
    public String solution(String number, int k) {
//    	연산이 많아서 시간효율을 위해 사용		ex) append();
    	StringBuilder answer = new StringBuilder();
    	int idx = 0;

//    	각 자리수 마다 최댓값을 구한다(자리수에 제한이 있으므로 전체 길이에서 빼야하는 갯수를 뺀 길이까지만 최댓값을 비교하면서 구해야한다)
        for(int i = 0; i < number.length() - k; i++) {
//        	최댓값 초기화
        	char max = '0';
        	
//			처음부터 하나씩 비교해서 최댓값 구하기        
        	for(int j = idx; j <= k + i; j++) {
	        	if(max < number.charAt(j)) {
	        		max = number.charAt(j);
	        		idx = j + 1;
	        	}
        	}			
//        	구한 최댓값을 추가해준다
			answer.append(max);
        }
        
        return answer.toString();
    }
}