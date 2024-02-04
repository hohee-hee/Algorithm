import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) P[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(j > i) dp[i][j] = dp[i][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], P[j] + dp[i-j][j]);
            }
        }

        System.out.println(dp[N][N]);
    }
}

