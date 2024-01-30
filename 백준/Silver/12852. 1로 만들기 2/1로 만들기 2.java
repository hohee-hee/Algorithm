import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];
        int[] prev = new int[N+1];

        dp[1] = 0;

        for(int i = 2 ; i < N+1 ; i++) {
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;

            if(i%3 == 0 && dp[i] >= dp[i/3] + 1) {

                dp[i] = dp[i/3] + 1;
                prev[i] = i/3;
            }

            if(i%2 == 0 && dp[i] >= dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                prev[i] = i/2;
            }
        }

        sb.append(dp[N]).append("\n");
        int idx = N;
        while(idx != 0) {
            sb.append(idx).append(" ");
            idx = prev[idx];
        }
        System.out.println(sb);
    }
}

