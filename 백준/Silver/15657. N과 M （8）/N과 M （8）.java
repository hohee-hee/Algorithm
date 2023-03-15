import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] per;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 변수 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		per = new int[M];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//차피 앞에서부터 오름차순으로 출력해야하므로 정렬을 먼저하고 출력
		Arrays.sort(arr);
		
		//백트래킹
		permunation(0);		
		
		System.out.println(sb);
	}

	private static void permunation(int k) {
		//기저조건
		if(k == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(per[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(k==0 || per[k-1] <= arr[i]) {
				per[k] = arr[i];
				permunation(k+1);
			}
		}
	}
}
