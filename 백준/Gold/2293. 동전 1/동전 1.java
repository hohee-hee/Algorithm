import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N+1];
        for(int i = 1 ; i <= N ; i++) coins[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][K+1];

        // 패딩 초기화
        for(int n = 1 ; n <= N ; n++) dp[n][0] = 1;

        // dp
        for(int n = 1 ; n <= N ; n++) {
            int coin = coins[n];
            for(int k = 1 ; k <= K ; k++) {
                if(k < coin) dp[n][k] = dp[n-1][k];
                else dp[n][k] = dp[n-1][k] + dp[n][k-coin];
            }
        }

        System.out.println(dp[N][K]);
    }
}

