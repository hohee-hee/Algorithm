import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1 ; tc <= 10 ; tc++) {
			int len = sc.nextInt();
			int[][] field = new int[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				for(int j = 0 ; j < 100 ; j++) {
					field[i][j] = sc.nextInt();
				}
			}
			int meet = 0;
			Deque<Integer> dq = new ArrayDeque<>();
			for(int c = 0 ; c < 100 ; c++) {
				int N = 0, S = 0;
				for(int r = 0 ; r < 100 ; r++) {
					if(field[r][c] != 0) dq.offerLast(field[r][c]);
				}
				while(dq.peekFirst() == 2) dq.pollFirst();
				while(dq.peekLast() == 1) dq.pollLast();
				
				while(!dq.isEmpty()) {
					while(dq.peekFirst() == 1) {
						dq.pollFirst();
					}
					while(!dq.isEmpty() && dq.peekFirst() == 2) {
						dq.pollFirst();
					}
					meet++;
				}
			}
			System.out.printf("#%d %d\n", tc, meet);
		}
		
	}
}
