import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];

        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int period = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            if(i+period <= N+1) dp[i + period] = Math.max(dp[i+period], dp[i] + price);
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        System.out.println(dp[N+1]);
    }
}

