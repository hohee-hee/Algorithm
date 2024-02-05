import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N];
        dp[0] = 1;

        int len = 0;
        int maxIdx = 0;
        for(int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for(int j = i-1 ; j >= 0 ; j--) {
                if(A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if(dp[i] > len) {
                len = dp[i];
                maxIdx = i;
            }
        }

        sb.append(len).append("\n");
        int[] answer = new int[len+1];
        int aIdx = len;
        for(int i = maxIdx ; i >= 0 ; i--) {
            if(dp[i] == aIdx) {
                answer[aIdx] = A[i];
                aIdx--;
            }
        }

        for(int i = 1 ; i <= len ; i++) sb.append(answer[i]).append(" ");
        System.out.println(sb);
    }
}

