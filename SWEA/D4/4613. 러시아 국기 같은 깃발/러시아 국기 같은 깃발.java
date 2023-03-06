import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] flag = new char[N][M];
			for(int i = 0 ; i < N ; i++) {
				String str = sc.next();
				for(int j = 0 ; j < M ; j++) {
					flag[i][j] = str.charAt(j);
				}
			}
			
			int st = 1;
			int en = N-2;
			
			int min = Integer.MAX_VALUE;
			for(int i = st ; i <= en ; i++) {
				for(int j = en ; j >= i ; j--) {	
					int sum = 0;
					for(int k = 0 ; k < i ; k++) {
						for(int l = 0 ; l < M ; l++) {
							if(flag[k][l] != 'W') sum++; 
						}
					}
					for(int k = i ; k <= j ; k++) {
						for(int l = 0 ; l < M ; l++) {
							if(flag[k][l] != 'B') sum++; 
						}
					}
					for(int k = j+1 ; k < N ; k++) {
						for(int l = 0 ; l < M ; l++) {
							if(flag[k][l] != 'R') sum++; 
						}
					}
					if(sum < min) min = sum;
				}
			}
			System.out.printf("#%d %d\n", tc, min);
		}			
	}
}
