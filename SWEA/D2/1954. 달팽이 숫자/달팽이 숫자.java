import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc <= T ; tc++) {
			
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			int r = 0, c= -1;
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			int dir = 0;
			for(int i = 1; i <= N*N ; i++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if(nr < 0 || nc < 0 || nr >= N || nc >= N || snail[nr][nc] != 0) {
					dir = (dir+1) % 4;
				}
				
				nr = r + dr[dir];
				nc = c + dc[dir];
				
				r = nr;
				c = nc;
				
				snail[r][c] = i;
				
			}
			
			sb.append("#" + tc + "\n");
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
