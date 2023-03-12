
import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; //수열 A
		int[] DP = new int[N]; //DP 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력받기
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		DP[0] = 1; //arr[0]은 최장길이가 1(자기자신)이므로 1 할당
		int maxDP = 0;
		int longest = 1;
		for(int i = 1 ; i < N ; i++) {
			maxDP = 0;
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] > arr[j]) {
					maxDP = Math.max(maxDP, DP[j]);
				}
			}			
			DP[i] = maxDP + 1;
			longest = Math.max(longest, DP[i]);
		}
		
		System.out.println(longest);
		
	}
}
