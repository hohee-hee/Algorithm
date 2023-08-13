import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. dp
        int[] dp = new int[N];        
        dp[0] = arr[0];
        int answer = dp[0];
        for(int i = 1; i < N ; i++) {
            dp[i] = arr[i];
            for(int j = 0 ; j < i ; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j]+arr[i], dp[i]);
                }
            }
            // 3. 정답 찾기
            answer = Math.max(dp[i], answer);
        }
        
        
        System.out.println(answer);
    }
}