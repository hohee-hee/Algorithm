import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt();
			char[][] field = new char[N][N];
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					field[r][c] = sc.next().charAt(0);
				}
			}
			int[] dr = {0,-1,-1,-1,0,1,1,1};
			int[] dc = {-1,-1,0,1,1,1,0,-1};
			int max = 0;
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					if(field[r][c] == 'G') continue;
					int depth = 0; //본인
					for(int i = 0 ; i < 8 ; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N || field[nr][nc] == 'G') continue;
						depth++;
					}
					if(depth == 0) depth = 1;
					max = Math.max(depth, max);
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
		
	}
}
