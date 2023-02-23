import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1 ; test_case <= 10 ; test_case++) {
			int T = sc.nextInt();
			System.out.print("#" + T);
			Queue<Integer> q = new LinkedList<>();
			
			//입력
			for(int i = 0 ; i < 8 ; i++) { q.offer(sc.nextInt()); }
			
			int val = 0;
			while(true) {
				//모듈러
				val = val % 5 + 1;
				int tmp = q.poll() - val;
				//0보다 작거나 같아지면 멈추기
				if(tmp <= 0) { 
					q.offer(0);
					break; 
				}
				q.offer(tmp);
			}
			
			while(!q.isEmpty())
				System.out.print(" " + q.poll());
			System.out.println();
		}


	}
}