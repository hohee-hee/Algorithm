import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		//1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //N
		
		int[][] schedule = new int[N+1][2]; //상담 일정 저장
		for(int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//2. dp
		int[] dp = new int[N+2];
		
		//계산하기
		for(int i = N ; i > 0 ; i--) {
			if(schedule[i][0] + i > N+1) dp[i] = dp[i+1];
			else dp[i] = Math.max(dp[i+1], dp[i+schedule[i][0]] + schedule[i][1]);
		}
		System.out.println(dp[1]);
	}
}
