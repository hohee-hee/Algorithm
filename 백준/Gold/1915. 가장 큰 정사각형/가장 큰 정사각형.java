import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		//2. DP
		int[][] DP = new int[N][M];
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0) continue;
				
				int a = 0;
				int b = 0;
				int c = 0;
				
				//위
				if((i-1) >= 0) a = DP[i-1][j];
				
				//왼
				if((j-1) >= 0) b = DP[i][j-1];
				
				//왼위
				if((i-1) >=0 && (j-1) >= 0) c = DP[i-1][j-1];

				DP[i][j] = Math.min(Math.min(a, b), c) + 1;
				
				if(max < DP[i][j]) max = DP[i][j];
			}
		}
		
		//3. 출력
		System.out.println(max*max);
	}
}
