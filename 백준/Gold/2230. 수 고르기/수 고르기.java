import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());			
		}
		
		Arrays.sort(arr);
		
		int lp = 0, rp = 0; //포인터
		int min = Integer.MAX_VALUE; //최솟값
		
		//투포인터를 이동시키면서 조건에 부합하는 값 찾기
		// - 두 수의 합이 M보다 작으면 rp를 우측으로 옮기기
		// - 두 수의 합이 M보다 크거나 같으면 최솟값을 찾고 lp를 우측으로 옮기기
		// - lp가 rp와 같으면 rp를 우측으로 옮기기
		while(lp < N-1 && rp < N) {
			int tsum = arr[rp] - arr[lp];
			if(tsum < M) { rp++; }
			else {
				if(min > tsum) { min = tsum; }
				lp++;
			}
			
			if(lp == rp) rp++;
		}
		
		System.out.println(min);
	}
}
