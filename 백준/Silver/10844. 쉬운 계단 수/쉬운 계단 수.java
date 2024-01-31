import java.io.*;
import java.util.*;

public class Main {
    public static final int DIVISION = 1000000000;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(9);
            return;
        }

        int[][] dp = new int[10][N];
        // 초기값 저장
        for(int i = 1 ; i < 10 ; i++) dp[i][0] = 1;
        for(int i = 1 ; i < N ; i++) {
            dp[0][i] = dp[1][i-1] % DIVISION;
            for(int j = 1 ; j < 9 ; j++) dp[j][i] = (dp[j-1][i-1] + dp[j+1][i-1]) % DIVISION;
            dp[9][i] = dp[8][i-1] % DIVISION;
        }

        int answer = 0;
        for(int i = 0 ; i < 10 ; i++) {
            answer += dp[i][N-1];
            answer %= DIVISION;
        }

        System.out.println(answer);
    }
}

