import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//계산 횟수를 순차적으로 담을 배열
		int[] dp = new int[N+1];
		
	
		for(int i = 2 ; i < N+1 ; i++) {
			//1을 먼저 더해준 값을 dp[i]에 넣어주기
			dp[i] = dp[i-1] + 1;
			
			//만약 i가 2로 나누어 떨어진다면
			//dp[i/2]+1 (2로 나눈 값의 dp값에 1 더하기 -> 나눗셈 해준 회차 추가 역할) 와 현재 dp값을 비교
			//최솟값을 넣기
			if(i % 2 == 0) {
				if(dp[i/2]+1 < dp[i]) {
					dp[i] = dp[i/2] + 1;				
				}
			}
			//만약 i가 3으로 나누어 떨어진다면
			//dp[i/3]+1 (3으로 나눈 값의 dp값에 1 더하기 -> 나눗셈 해준 회차 추가 역할) 와 현재 dp값을 비교
			//최솟값을 넣기
			if(i % 3 == 0) {
				if(dp[i/3]+1 < dp[i]) {
					dp[i] = dp[i/3] + 1;				
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}
