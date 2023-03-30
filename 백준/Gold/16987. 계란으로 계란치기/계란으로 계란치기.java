
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, max;
	static int[][] eggs;
	
	public static void main(String[] args) throws IOException{
		//1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //N
		
		eggs = new int[N][2]; //[0] : 내구성 [1] : 무게
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//계란이 1개일 때는 아무 것도 깰 수 없다. => 종료
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		//2. 백트래킹
		max = 0;		
		BackTracking(0);
		
		//3. 출력
		System.out.println(max);
	}

	private static void BackTracking(int cur) {
		if(max == N) return;
		
		//맨 오른쪽 계란일 때
		if(cur == N) {
			//깨진 계란 계산하기
			int cnt = 0;
			for(int i = 0 ; i < N ; i++) {
				if(eggs[i][0] < 1) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}		
		
		
		boolean hit = false;
		for(int i = 0 ; i < N ; i++) {
			
			//들고 있는 계란이 깨진 계란일때
			if(eggs[cur][0] <= 0) break;
			//1. 계란치기			
			//자기 자신일때
			if(cur == i) continue;
			
			//이미 깨진 계란일 때
			if(eggs[i][0] < 1) continue;
			
			hit = true;
			//아니면 계란치기
			eggs[i][0] -= eggs[cur][1];
			eggs[cur][0] -= eggs[i][1];
			
			BackTracking(cur+1);
			
			eggs[i][0] += eggs[cur][1];
			eggs[cur][0] += eggs[i][1];
		}		
		if(!hit)  BackTracking(cur+1);
	}

}
