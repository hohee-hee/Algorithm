import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N+1]; //계단 점수
		int[] dp = new int[N+1]; //DP
		
		// 계단 점수 입력 받기
		for(int i = 1; i <= N ; i++) { score[i] = Integer.parseInt(br.readLine()); }
		
		//dp의 1번 요소 초기화
		dp[1] = score[1];		
		//계단이 2개 이상이면 2번 요소도 초기화
        if(N > 1) dp[2] = score[1] + score[2];
		if(N > 2) dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

		//만약 계단이 1개 또는 2개라면 바로 출력 후 종료
		if(N < 4) {	System.out.println(dp[N]); }
		
		//만약 계단이 3개 이상이라면 dp
		else {
			for(int i = 4 ; i <= N ; i++) {
				dp[i] = Math.max(dp[i-3] + score[i-1] + score[i], dp[i-2] + score[i]);
			}	
			System.out.println(dp[N]);
		}
		
	
	}
}
