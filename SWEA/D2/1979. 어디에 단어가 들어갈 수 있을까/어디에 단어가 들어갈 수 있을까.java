import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] puzzle = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			int con_r = 0;
			int con_c = 0;
			int answer =0;
			
			for(int i = 0 ; i < N ; i++) {
				con_r = 0;
				con_c = 0;
				for(int j = 0 ; j < N ; j++) {
					if(puzzle[i][j] == 1) {	con_r++; }	
					else if(puzzle[i][j] == 0) { 
						if(con_r == K) { answer++; }
						con_r = 0; 
					}

					
					if(puzzle[j][i] == 1) {	con_c++; }
					else if(puzzle[j][i] == 0) { 
						if(con_c == K) { answer++; }
						con_c = 0; 
					}
				}
				if(con_r == K) { answer++; }
				if(con_c == K) { answer++; }
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
