import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Queue<String> q1 = new LinkedList<>(); //앞 절반을 넣을 큐
		Queue<String> q2 = new LinkedList<>(); //뒤 절반을 넣을 큐
		
		int T = Integer.parseInt(sc.next());
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			int N = Integer.parseInt(sc.next());
			
			//입력받기 - 앞 절반은 q1에 뒤 절반은 q2에 넣기
			for(int i = 0 ; i < N ; i++) {
				if(i < (N+1) / 2) {
					q1.offer(sc.next());
				}
				else {
					q2.offer(sc.next());
				}					
			}
			
			//출력하기 : 짝수번째는  q1에서 홀수번째는 q2에서 빼오기
			for(int i = 0 ; i < N ; i++) {
				if(i % 2 == 0) {
					sb.append(q1.poll()).append(" ");
				}
				else {
					sb.append(q2.poll()).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
