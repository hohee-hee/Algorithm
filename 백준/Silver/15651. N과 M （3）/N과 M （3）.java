import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main{
	static int N, M;
	static int[] arr;
	static boolean[] isUsed;
	static StringBuilder sb;
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		isUsed = new boolean[N+1];

		sb = new StringBuilder();
		permunation(0);
		System.out.println(sb);
		
	}
	
	private static void permunation(int k) {
		if(k == M) {
			for(int i = 0 ; i < k ;i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N ; i++) {
			arr[k] = i;
			permunation(k+1);
		}
	}
	
}
