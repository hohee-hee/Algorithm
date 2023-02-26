import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lp = 0;
		int rp = 0;
		int sum = 0;
		int answer = 0;
		while(true){
			sum = 0;
			
			//sum 구해주기
			for(int i = lp ; i <= rp ; i++) {
				sum += arr[i];
			}
			
			//포인터 이동하기
			if(sum == M) {
				answer++;
				lp++;
			}
			
			else if(sum < M) { rp++; }
			
			else { lp++; }
			
			if(lp > rp) { rp++;}
			
			if(lp == N || rp == N) break;
		}
		
		System.out.println(answer);
		
	}
}
