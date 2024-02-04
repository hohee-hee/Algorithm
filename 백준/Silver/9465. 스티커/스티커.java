import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N];
            for(int i = 0 ; i < 2 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++) stickers[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][N];
            int[] colMax = new int[N];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            colMax[0] = Math.max(dp[0][0], dp[1][0]);
            for(int c = 1 ; c < N ; c++) {
                dp[0][c] = Math.max(colMax[c-1], dp[1][c-1]+stickers[0][c]);
                dp[1][c] = Math.max(colMax[c-1], dp[0][c-1]+stickers[1][c]);
                colMax[c] = Math.max(dp[0][c], dp[1][c]);
            }

            sb.append(colMax[N-1]).append("\n");
        }

        System.out.println(sb);
    }
}

