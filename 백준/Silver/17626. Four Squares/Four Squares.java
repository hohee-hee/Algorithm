import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sq = (int) Math.sqrt(n);
        if(sq * sq == n) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            if((int)Math.sqrt(i) * (int)Math.sqrt(i) == i) {
                dp[i] = 1;
                continue;
            }

            dp[i] = 4;
            for(int j = 1 ; j * j <= i ; j++) {
                dp[i] = Math.min(dp[j*j] + dp[i-j*j], dp[i]);
                if(dp[i] == 2) break;
            }
        }

        System.out.println(dp[n]);
    }
}