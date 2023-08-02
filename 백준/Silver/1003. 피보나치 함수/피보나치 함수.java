import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        
        // 점화식 : [0][i-1] + [0][i-2] [1][i-1] + [1][i-2]
        
        
        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());
        	int[][] dp = new int[2][N+1];

        	
        	// 가지 치기
        	if(N == 0) {
        		sb.append(1 + " " + 0 + "\n");
        		continue;
        	}
        	if(N == 1) {
        		sb.append(0 + " " + 1 + "\n");
        		continue;
        	}
        	
        	// 초기 값 설정
        	dp[0][0] = dp[1][1] = 1;
        	
        	for(int i = 2 ; i < N+1 ; i++) {
        		dp[0][i] = dp[0][i-1] + dp[0][i-2];
        		dp[1][i] = dp[1][i-1] + dp[1][i-2];
        	}
        	
    		sb.append(dp[0][N] + " " + dp[1][N] + "\n");
        }
        
        System.out.println(sb);
	}
}
