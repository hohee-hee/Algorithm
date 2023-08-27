import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
		
        if(N == 1) {
        	System.out.println(1);
        	System.out.println(A[0]);
        	return;
        }
		// 2. dp
		// 2중 for로 가장 긴 배열 찾아서 넣기
        int[] dp = new int[N];
        dp[0] = 1;
        int maxlen = 0;
        int answer = 0;
        for(int i = 1 ; i < N ; i++) {
        	maxlen = 0;
        	for(int j = 0 ; j < i ; j++) {
        		if(A[j] < A[i])	maxlen = Math.max(maxlen, dp[j]);
        	}
        	dp[i] = maxlen+1;
        	if(dp[i] > answer) answer = dp[i];
        }
        
        // 3. 최대 길이
        int idx = answer;
        int[] print = new int[N+1];
        for(int i = N-1 ; i >= 0 ; i--) {
			if(dp[i] == idx) {
				print[idx-1] = A[i];
				idx--;
			}
        	
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer + "\n");
        
        for(int i = 0 ; i < answer ; i++) {
        	sb.append(print[i] + " ");
        }
        
        System.out.println(sb);
	}
}
