package TNG_Structure;

import java.util.Stack;

/*
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.

prices			return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
*/
public class Stack01 {
	public static void main(String[] args) {
		Stack01_Solution sol = new Stack01_Solution();
		int[] prices = {1,3,2,4};
		sol.solution(prices);
	}
}

/*
 * Stack<int[]> --> {5,6} 
 * 					{3,5}
 * 					{2,3}
 * 					{1,2} 
 * Stack.peek(); --> {5,6}의 배열 주소를 리턴 / 제거하지 않음
 * Stack.pop(); --> {5,6}의 배열 주소를 반환 / 제거
 * Stack.push(int[]); 배열 값을 맨 위에 쌓는다 
 * Stack.peek()[0]; --> 맨위의 배열의 첫번째 값 = 5
 * 
*/
class Stack01_Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        
//      뒤에서 부터 검색
        for(int i = prices.length-2; i>=0; i--) {
        	
//        	이미 stack에 저장되어 있기 때문에 떨어지지 않는 시간을 초기화 해준다.
        	int sec = 0;
        	
//        	stack에 값이 있고 stack에서 자신보다 낮은 값이 나올 때 까지 stack에 있는 값들을 지우면서 초를 증가시킨다.
        	while(!stack.isEmpty() && stack.peek()[0] >= prices[i])	
        		sec += stack.pop()[1];
        	
//        	stack에 있는 값보다 낮은 값이 나오면 초가 1씩 증가,마지막 전은 무조건 1초간 떨어지지 않는다.
        	answer[i] = stack.push(new int[] {prices[i],sec+1})[1];
        }
                
        return answer;
    }
}