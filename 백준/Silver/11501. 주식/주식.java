import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 입력 받기
			int N = Integer.parseInt(br.readLine());
			
			int[] price = new int[N]; //주가

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				price[i] = Integer.parseInt(st.nextToken());		
				
			}
			
			int high = price[N-1];
			long answer = 0;
			long sum = 0;
			int stock = 0;
			for(int i = N-2 ; i >= -1 ; i--) {
				if(i == -1) {
					long get = stock * high;
					answer += get - sum;
					break;
				}
				
				if(high > price[i]) {
					sum += price[i];
					stock++;
					continue;
				}
				
				long get = stock * high;
				answer += get - sum;
				high = price[i];
				sum = 0;
				stock = 0;			
			}
			
			System.out.println(answer);
		}
		
		
	}
}
