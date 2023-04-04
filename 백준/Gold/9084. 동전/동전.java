import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 입력 받기
			//동전 개수
			int N = Integer.parseInt(br.readLine());
			
			//동전 단위
			int[] coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) coins[i] = Integer.parseInt(st.nextToken());
			
			//금액
			int P = Integer.parseInt(br.readLine());
			
			//2. DP배열
			int[] DP = new int[P+1];
			DP[0] = 1;
			
			
			//3. 더하기
			for(int i = 0 ; i < N ; i++) {
				int coin = coins[i];
				for(int j = 1 ; j <= P ; j++) {
					if(j-coin < 0) continue;
					DP[j] += DP[j - coin];
				}
			}
			sb.append(DP[P]+ "\n");
		}
		System.out.println(sb);
		
	}
}
