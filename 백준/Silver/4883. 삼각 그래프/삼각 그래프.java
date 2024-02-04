import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 0;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            tc++;
            int[][] graph = new int[N][3];
            for(int i = 0 ; i < N ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 3 ; j++) graph[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N][3];
            dp[0][0] = graph[0][0]; dp[0][1] = graph[0][1];
            for(int r = 0 ; r < N ; r++) {
                for(int c = 0 ; c < 3 ; c++) {
                    if((r == 0 && c < 2) || (r == N-1 && c == 2)) continue;

                    int prev = Integer.MAX_VALUE;
                    if(c-1 >= 0) prev = Math.min(prev, dp[r][c-1]);
                    if(r-1 >= 0) {
                        if(!(r-1 == 0 && c == 0))prev = Math.min(prev, dp[r-1][c]);
                        if(c-1 >= 0 && !(r-1 == 0 && c-1 == 0)) prev = Math.min(prev,dp[r-1][c-1]);
                        if(c+1 < 3) prev = Math.min(prev,dp[r-1][c+1]);
                    }
                    dp[r][c] = prev + graph[r][c];
                }
            }

            sb.append(tc).append(". ").append(dp[N-1][1]).append("\n");
        }

        System.out.println(sb);
    }
}

