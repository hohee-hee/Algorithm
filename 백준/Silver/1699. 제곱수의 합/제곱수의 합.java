import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int num = 1;
        for(int i = 1 ; i <= N ; i++) {
            if(i == num*num) {
                dp[i] = 1;
                num++;
                continue;
            }
            dp[i] = dp[i-1] + 1;
            int tmp = num - 1;
            while(tmp > 0) {
                dp[i] = Math.min(dp[i-tmp*tmp] + dp[tmp*tmp],dp[i]);
                tmp--;
            }
        }

        System.out.println(dp[N]);
    }
}

