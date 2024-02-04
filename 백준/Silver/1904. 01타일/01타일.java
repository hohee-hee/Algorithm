import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(1);
            return;
        } else if(N == 2) {
            System.out.println(2);
            return;
        }

        int[] dp = new int[N];
        dp[0] = 1; dp[1] = 2;
        for(int i = 2 ; i < N ; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[N-1]);
    }
}

