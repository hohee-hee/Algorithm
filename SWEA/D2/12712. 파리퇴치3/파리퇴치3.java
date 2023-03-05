import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] field = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					field[i][j] = sc.nextInt();					
				}
			}
			
			int sum_c = 0;
			int sum_x = 0;
			int max = 0;
			int[] dc = { -1, 0, 1, 0, -1, 1, 1, -1 };
			int[] dr = { 0, -1, 0, 1, -1, -1, 1, 1 };
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					int nr = i;
					int nc = j;
					int cnt = 1;
					sum_c = field[nr][nc];
					sum_x = field[nr][nc];
					while(cnt < M) {
						if(nr + cnt < N) sum_c += field[nr+cnt][nc];
						if(nc + cnt < N) sum_c += field[nr][nc+cnt];
						if(nr - cnt >= 0) sum_c += field[nr-cnt][nc];
						if(nc - cnt >= 0) sum_c += field[nr][nc-cnt];	
						
						if(nr + cnt < N && nc + cnt < N) sum_x += field[nr+cnt][nc+cnt];
						if(nr - cnt >= 0 && nc + cnt < N) sum_x += field[nr-cnt][nc+cnt];
						if(nr - cnt >= 0 && nc - cnt >= 0) sum_x += field[nr-cnt][nc-cnt];
						if(nr + cnt < N && nc - cnt >= 0) sum_x += field[nr+cnt][nc-cnt];	
						
						cnt++;
					}
					
					max = Math.max(max, Math.max(sum_c, sum_x));
					
				}
			}
			
			
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
