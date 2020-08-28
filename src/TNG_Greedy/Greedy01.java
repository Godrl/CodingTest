package TNG_Greedy;
/*
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

   전체 학생의 수 n, 
   체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
   여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
   체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
*/
public class Greedy01 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(n, lost, reserve));
	}
}

/*	key point
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있기 때문에 빌려주기 전에 여벌이 있는지 검사를 해야한다.
*/
class Solution {
    public int solution(int n, int[] lost, int[] reserve) { 
    	int[] student = new int[n];
        	
//    	체육복 없는 학생들 = -1
    	for (int i = 0; i < lost.length; i++) {
    		student[lost[i]-1]--;
    	}
//    	체육복 여벌 있는 학생들 = +1
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i]-1]++;
        }
                       
//		수업을 들을 수 있는 학생을 전체로 잡고 체육복을 받을 수 있는 사람들은 받고 못 받은 사람을 -1씩 깍는다.
        int answer = n;
//		여벌이 있는 학생들이 체육복을 나눠준다 
        for (int i = 0; i < student.length; i++) {
//        	체육복이 없는 학생 
            if (student[i] == -1) {
//            	앞 번호 친구가 여별 체육복이 있다면
                if (i-1 >= 0 && student[i-1] == 1) {
                    student[i]++;
                    student[i-1]--;
                } 
//              뒷 번호 친구가 여벌 체육복이 있다면
                else if (i+1 < student.length && student[i+1] == 1) {
                    student[i]++;
                    student[i+1]--;
                } 
//              앞 뒤 아무도 없다면 수업을 못 받는 사람이 늘어난다  
                else answer--;
            }
        }
        return answer;
    }
}
