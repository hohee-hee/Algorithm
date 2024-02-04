import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(10);
            return;
        }

        int[] dp = new int[N];
        int[] cal = new int[10];
        dp[0] = 10;
        for(int i = 0 ; i < 10 ; i++) cal[i] = 1;

        for(int i = 1 ; i < N ; i++) {
            int sum = 1;
            cal[0] = 1;
            for(int j = 1 ; j < 10 ; j++) {
                cal[j] += cal[j-1];
                cal[j] %= 10007;
                sum += cal[j];
            }
            dp[i] = sum % 10007;
        }

        System.out.println(dp[N-1]);
    }
}

