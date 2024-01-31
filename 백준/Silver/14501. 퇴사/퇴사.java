import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        int answer = 0;
        for(int i = 1 ; i <= N ; i++) {
            // 퇴사날까지 상담을 완료할 수 없는 경우
            if(T[i] + i > N+1) {
                dp[i] = answer;
                continue;
            }

            dp[i] = P[i];
            for(int j = i-1 ; j > 0 ; j--) {
                if(T[j] + j > i) dp[i] = Math.max(P[i], dp[i]);
                else dp[i] = Math.max(dp[j] + P[i], dp[i]);
            }

            if(dp[i] > answer) answer = dp[i];
        }

        System.out.println(answer);
    }
}

