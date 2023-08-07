import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] cards = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			cards[i] = Long.parseLong(st.nextToken());
		}
		
		while(M > 0) {
			// 1. 정렬하기
			Arrays.parallelSort(cards);
			
			// 2. 작은 수 2개 골라서 더하기
			long sum = cards[0] + cards[1];
			
			// 3. 수 바꾸기
			cards[0] = cards[1] = sum;
			
			// 4. 회차 차감하기
			M--;
		}
		
		// 더하기
		long answer = 0;
		for(int i = 0 ; i < N ; i++) {
			answer +=cards[i];
		}
		
		System.out.println(answer);
		
	}
}
