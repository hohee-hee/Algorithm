import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//입력받기

		int N = Integer.parseInt(br.readLine());

		int[][] street = new int[N][3];

		for(int i = 0 ; i < N ; i++){

		    StringTokenizer st = new StringTokenizer(br.readLine());

		    for (int j = 0 ; j < 3 ; j++){

		        street[i][j] = Integer.parseInt(st.nextToken());

		    }

		}

		

		//DP : R G B 순서

		int[][] dp = new int[N][3];

		dp[0] = street[0];

		for(int i = 1 ; i < N ; i++){

		    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + street[i][0];

		    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + street[i][1];

		    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + street[i][2];

		}

		

		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));

	}

}