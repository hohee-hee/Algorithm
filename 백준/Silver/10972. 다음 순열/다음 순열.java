
import java.util.*;
import java.io.*;

public class Main {
	
	static int N; 
	static int[] per;
	
	public static void main(String[] args) throws IOException{
		//입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		per = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			per[i] = Integer.parseInt(st.nextToken());
		}
		
		//기준 원소 찾기
		int sidx = N-2; //기준 원소 인덱스
		while(sidx >= 0 && per[sidx] >= per[sidx+1]) {
			sidx--;
		}
		if(sidx < 0) {
			System.out.println(-1);
			return;
		}
		
		//타겟 원소 찾기
		int tidx = N-1 ;
		while(per[sidx] >= per[tidx]) {
			tidx--;
		}
		
		//swap
		swap(sidx, tidx);
		
		//정렬
		int lp = sidx + 1;
		int rp = N- 1;
		while(lp < rp) {
			swap(lp,rp);
			rp--;
			lp++;
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {			
			sb.append(per[i] + " ");
		}
		System.out.println(sb);
	}
	
	private static void swap(int a, int b) {
		int tmp = per[a];
		per[a] = per[b];
		per[b] = tmp;
	}
}
