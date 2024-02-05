import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) num[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N+1][N+1]; // c: start point, r: length
        for(int s = 1 ; s <= N ; s++) dp[1][s] = true;
        for(int s = 1 ; s < N ; s++) {
            if(num[s] == num[s+1]) dp[2][s] = true;
        }
        for(int l = 3 ; l <= N ; l++) {
            for(int s = 1 ; s <= N-l+1; s++) {
                if(num[s] != num[s+l-1]) dp[l][s] = false;
                else dp[l][s] = dp[l-2][s+1];
            }
        }


        int M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int len = E-S+1;
            int answer = dp[len][S] ? 1 : 0;
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}

