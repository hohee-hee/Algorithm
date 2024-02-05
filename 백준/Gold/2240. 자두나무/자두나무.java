import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plums = new int[T+1];
        for(int i = 1 ; i <= T ; i++) plums[i] = Integer.parseInt(br.readLine());

        int[][][] dp = new int[W+1][T+1][2];
        for(int w = 0 ; w <= W ; w++) {
            dp[w][0][0] = 0;
            dp[w][0][1] = 1;
        }

        for(int t = 1 ; t <= T ; t++) {
            int plum = plums[t];
            for(int w = 0 ; w <= W ; w++) {
                dp[w][t][0] = dp[w][t-1][0];
                dp[w][t][1] = w % 2 == 0 ? 1 : 2;

                if(t < w || plum != dp[w][t][1]) continue;

                if(plum == dp[w][t-1][1]) dp[w][t][0] = dp[w][t-1][0] + 1;
                if(w-1 >= 0) dp[w][t][0] = Math.max(dp[w][t][0], dp[w-1][t-1][0] + 1);
            }
        }

        int answer =0;
        for(int w = 0 ; w <= W ; w++) {
            answer = Math.max(answer, dp[w][T][0]);
        }



        System.out.println(answer);
    }
}

