
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] DP = new int[N];
		for(int i = 0 ; i < N ; i++) {
			DP[i] = Integer.parseInt(st.nextToken());
		}
		
		//2. 최댓값 찾기
		int max = DP[0];
		for(int i = 1 ; i < N ; i++) {
			if(DP[i] + DP[i-1] > DP[i]) DP[i] += DP[i-1];
			
			if(max < DP[i]) max = DP[i];
		}
		
		//3. 출력
		System.out.println(max);
		
	}
}
