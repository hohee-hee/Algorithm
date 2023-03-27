
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] p;
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
		p = new int[M];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		BackTracking(0, 0);
		
		System.out.println(sb);
		
	}

	private static void BackTracking(int idx, int pre) {
		if(idx == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(p[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int before = 0;
		for(int i = pre ; i < N ; i++) {
			if( before != arr[i]) {
				p[idx] = arr[i];
				before = p[idx];
				BackTracking(idx+1, i);
			}
		}
	}
}

