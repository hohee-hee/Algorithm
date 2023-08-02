import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        
        // 점화식 : [i] = [i-1] + [i-2] + [i-3]
        // [1] 1 [2] 2 [3] 4
        
        
        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            if(N == 1) {
            	sb.append(1 + "\n");
            	continue;
            } 
            if(N == 2) {
            	sb.append(2 + "\n");
            	continue;
            }
            if(N == 3) {
            	sb.append(4 + "\n");
            	continue;
            }
            
        	int[] dp = new int[N+1];
        	
        	dp[1] = 1;
        	dp[2] = 2;
        	dp[3] = 4;
        	
        	for(int i = 4 ; i < N+1 ; i++) dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        	
        	sb.append(dp[N] + "\n");
        }
        
        System.out.println(sb);
	}
}
