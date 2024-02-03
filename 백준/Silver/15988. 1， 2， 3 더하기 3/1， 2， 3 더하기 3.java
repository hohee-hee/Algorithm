import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[10000001];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        int pt = 4;
        for(int tc = 0 ; tc < T ; tc++) {
            int n = Integer.parseInt(br.readLine());

            if(dp[n] != 0) {
                sb.append(dp[n]).append("\n");
                continue;
            }

            for(int i = pt ; i <= n ; i++) dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
            pt = n+1;
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}

