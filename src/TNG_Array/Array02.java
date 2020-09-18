package TNG_Array;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 
[6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예
numbers				return
[6, 10, 2]			6210
[3, 30, 34, 5, 9]	9534330
*/
public class Array02 {
	public static void main(String[] args) {
		Array02_Solution sol = new Array02_Solution();
		int[] numbers = {3, 30, 34, 5, 9};
		
		System.out.println(sol.solution(numbers));
	}
}

/*
 * Integer.toString(int num), String.valueOf(int num) --> 숫자를 문자로 변환
 * 
 * Arrays.sort(String[] a, Comparator<>(){
 * 		@Override
 * 		public int compare(String o1, String o2){
 * 			return 	(o2+o1).compareTo(o1+o2);
 * 		}
 * )}
 * --> 문자열안에서 두 문자씩 더하여 더 큰 문자조합이 나오면 내림차순으로 정렬해서 반환 
 *** 									앞에 (o2+o1)순서를 바꾸면 오름차순 반환 
 * 
*/
class Array02_Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
//      숫자를 문자열로 변환해서 저장한다.
        for(int i=0; i<numbers.length; i++)	arr[i] = Integer.toString(numbers[i]);
        
//      두개씩 계속 더해서 가장 큰 문자 조합이 나올 때 반환
        Arrays.sort(arr, new Comparator<String>() {
        	
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
        });

//      0으로만 이루어진 문자는 0이므로 0을 반환 ex) {1, 3, 5, 00, 000} -> {1, 3, 5, 0, 0}
        if(arr[0].equals("0")) return "0";
        else {
//          정렬된 문자열을 추가한다.
        	for(String i : arr) answer += i;
        }
               
        return answer;
    }
}