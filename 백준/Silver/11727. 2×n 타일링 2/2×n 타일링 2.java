import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(1);
            return;
        } else if(N == 2) {
            System.out.println(3);
            return;
        }

        int[] dp = new int[N+1];
        dp[1] = 1; dp[2] = 3;
        for(int i = 3 ; i < N+1 ; i++) dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        System.out.println(dp[N]);
    }
}

