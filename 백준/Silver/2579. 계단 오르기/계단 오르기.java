import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+1];
        for(int i = 1 ; i <= N ; i++) stairs[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][N+1];
        dp[0][1] = stairs[1];
        if(N == 1) {
            System.out.println(dp[0][1]);
            return;
        }

        for(int i = 2 ; i < N+1 ; i++) {
            dp[0][i] = Math.max(dp[0][i-2], dp[1][i-2]) + stairs[i];
            dp[1][i] = dp[0][i-1] + stairs[i];
        }

        int answer = Math.max(dp[0][N], dp[1][N]);
        System.out.println(answer);
    }
}

