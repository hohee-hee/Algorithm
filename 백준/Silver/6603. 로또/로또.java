import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int[] S;
	static int[] per;
	static boolean[] isUsed;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		// 반복
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			//종료조건
			if(K == 0) break;
			
			//필요한 배열 초기화
			S = new int[K]; //입력받을 집합 S
			per = new int[6]; //가능한 번호 배열을 저장할 배열
			isUsed = new boolean[K]; //사용 여부 확인
			
			//입력받기
			for(int i = 0 ; i < K ; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			//백트래킹
			permunation(0);
			
			sb.append("\n");
		}
		
		//출력
		System.out.println(sb);
	}

	private static void permunation(int idx) {
		//기저조건
		if(idx == 6) {
			for(int i = 0 ; i < 6 ; i++) {
				sb.append(per[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < K ; i++) {
			if(idx == 0 && i > K-6) {
				return;
			}
			if(idx==0 || per[idx-1] < S[i]) {
				per[idx] = S[i];
				permunation(idx+1);
			}
		}
	}
}
