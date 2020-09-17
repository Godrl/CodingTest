package TNG_Structure;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.

입출력 예
scoville				K	return
[1, 2, 3, 9, 10, 12]	7	2

*/
public class Heap01 {
	public static void main(String[] args) {
		Heap01_Solution sol = new Heap01_Solution();
		int[] scoville = {5,1,3,7,12,10};
		int K = 7;
		System.out.println(sol.solution(scoville, K));
		
	}
}

/*
 * Queue.offer() --> 데이터 삽입(Min-Heap 방식 - 부모노드가 자식노드보다 값이 작다,왼쪽부터 삽입)
 * Queue.size() -->	데이터 개수 반환
 * Queue.peek() --> 가장 작은 데이터를 반환하지만 삭제하지 않는다.
 * Queue.poll() --> 가장 작은 데이터를 반환하면서 삭제한다.
*/
class Heap01_Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
       Queue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int i : scoville) queue.offer(i);
      
//     	큐안에 가장 작은 값이 스코빌 지수보다 클 때 까지 실행
        while(queue.peek() < K) {
//        	개수가 한개만 있으면 스코빌 지수를 구할수 없기 때문에 제한사항에 따라 -1 반환
        	if(queue.size() == 1) return -1;
        	
//        	가장 작은값과 두번째로 작은 값을 빼내서 새로운 값을 만든다.
        	queue.offer(queue.poll() + queue.poll()*2);
        	answer++;
        }
        return answer;
        
    }
}