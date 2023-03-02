import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		boolean[] roll = new boolean[L+1];
		int N = Integer.parseInt(br.readLine());
		
		int expect = 0; //기대하는 조각 중 최댓값
		int ex_num = 0; //가장 많은 조각을 받을 것으로 기대되는 사람의 번호
		int max_piece = 0; //실제 받을 수 있는 조각의 최댓값
		int max_num = 0; //가장 많은 조각을 실제로 받은 사람의 번호
		
		for(int i = 1; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			//1. 기대하는 조각 중 최댓값을 비교하여 기대되는 사람의 번호를 저장하기			
			if(expect < K - P) { 
				expect = K - P;
				ex_num = i; 
			}

			//2. 실제로 받을 수 있는 조각의 최댓값을 비교하여 실제 받는 사람의 번호를 저장
			
			int cnt = 0; //카운팅을 위한 변수
			//범위를 만족하는 j번째 조각이 이미 누군가 가져간 조각인지 확인
			//가져가지 않았다면 조각을 그 사람에게 주고 카운팅해주기
			for(int j = P ; j <= K ; j++) {
				if(!roll[j]) {
					roll[j] = true;
					cnt++;
				}
			}
			//최댓값 비교
			if(max_piece < cnt) { 
				max_piece = cnt;
				max_num = i; 
			}
		}

		System.out.println(ex_num);
		System.out.println(max_num);
	}
}
