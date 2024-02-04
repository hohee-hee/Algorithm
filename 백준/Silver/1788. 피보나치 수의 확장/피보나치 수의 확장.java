import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        boolean isPos = N > 0;
        if(!isPos) N *= -1;
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i = 2 ; i <= N ; i++) dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;

        if(isPos || N % 2 == 1)System.out.println(1);
        else System.out.println(-1);

        System.out.println(dp[N]);
    }
}

