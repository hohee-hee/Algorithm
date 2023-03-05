import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			
			int N = sc.nextInt();
			boolean[][] field = new boolean[N][N];
			for(int i = 0 ; i < N ; i++) {
				String s = sc.next();
				for(int j = 0 ; j < N ; j++) {
					char c= s.charAt(j);
					if(c == '.') field[i][j] = false;
					else field[i][j] = true;
				}
			}
			
			String answer = "NO";
			
			//델타 배열
			int[] dc = { 1, 0, 1, -1 }; //오른쪽, 아래쪽, 우하향, 좌하향
			int[] dr = { 0, 1, 1, 1 };
			
			outer : for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!field[i][j]) continue;
					//탐색
					int cr = i;
					int cc = j;
					for(int k = 0 ; k < 4; k++) {
						int cnt = 0;
						int nr = cr;
						int nc = cc;
						while(nr >= 0 && nr < N && nc >=0 && nc < N && field[nr][nc]) {
							cnt++;
							nr += dr[k];
							nc += dc[k];
							if(cnt == 5) {
								answer = "YES";
								break outer;
							}
						}
					}
				}
			}
			
			
			
			System.out.printf("#%d %s\n", tc, answer);
		}
	}
}
