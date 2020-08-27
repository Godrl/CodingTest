package TNG_Array;

import java.util.Arrays;


/*
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

*/

public class Array01 {
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		Solution sol = new Solution();
		for(int answer: sol.solution(array, commands)) System.out.print(answer+" ");
				
				
	}
}

/*
 * Arrays.copyOfRange(array,fromIndex,toIndex) - array변수의 배열에서 fromIndex에서 toIndex까지의 범위만 복사해서 새로 배열을 만듦(원래 배열은 변화 X)
 * Arrays.sort() - 오름차순으로 정렬 
*/
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int fromIndex = 0;
		int toIndex = 0;
				
		for(int i=0;i<commands.length;i++) {
			fromIndex = commands[i][0]-1;
			toIndex = commands[i][1];

			int[] select = Arrays.copyOfRange(array, fromIndex, toIndex);
			Arrays.sort(select);
			
			answer[i] = select[commands[i][2]-1];
			
		}
        return answer;
    }
}


