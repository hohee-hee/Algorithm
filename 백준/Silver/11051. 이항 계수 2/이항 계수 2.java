import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N == K || K == 0) {
            System.out.println(1);
            return;
        } else if(K == 1) {
            System.out.println(N);
            return;
        }


        int[][] dp = new int[K+1][N+1];
        for(int k = 1 ; k < N+1 ; k++) dp[1][k] = k;

        for(int k = 2 ; k < K+1 ; k++) {
            for(int n = k ; n < N+1 ; n++) dp[k][n] = (dp[k][n-1] + dp[k-1][n-1]) % 10007;
        }

        System.out.println(dp[K][N]);
    }
}