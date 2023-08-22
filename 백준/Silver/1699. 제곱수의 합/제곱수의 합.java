import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)  throws IOException {
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 2. 제곱수 여부 확인
        if((Math.pow((long)Math.sqrt(N), 2) == N)){
        	System.out.println(1);
        	return;
        }
        
        // 3. 아니라면 DP
        // 모두 1^2로 표시한다는 가정 하에 i로 초기화
        int[] dp = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
        	dp[i] = i;
        }

        for(int i = 1 ; i <= N ; i++) {
        	for(int j = 2 ; j*j <= i ; j++) {
        		dp[i] = Math.min(dp[i], dp[i - j*j]+1);
        	}
        }
        
        System.out.println(dp[N]); 
	}
}
