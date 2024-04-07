import java.util.*;
import java.io.*;

public class Main{
    public static final int DIV = 1_000_000_000;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(K == 1) {
            System.out.println(1);
            return;
        } else if(K == 2) {
            System.out.println(N+1);
            return;
        }

        int[][] dp = new int[K+1][N+1];

        for(int r = 1 ; r <= K ; r++) {
            dp[r][0] = 1;
            for(int c = 1 ; c <= N ; c++) {
                dp[r][c] = (dp[r][c-1] + dp[r-1][c]) % DIV;
            }
        }

        System.out.println(dp[K][N]);
    }
}