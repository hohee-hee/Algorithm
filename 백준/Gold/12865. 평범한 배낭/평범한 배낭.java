import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N+1];
        int[] V = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];
        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1 ; c <= K ; c++) {
                if(W[r] > c) dp[r][c] = dp[r-1][c];
                else dp[r][c] = Math.max(dp[r-1][c], dp[r-1][c-W[r]] + V[r]);
            }
        }

        System.out.println(dp[N][K]);
    }
}

