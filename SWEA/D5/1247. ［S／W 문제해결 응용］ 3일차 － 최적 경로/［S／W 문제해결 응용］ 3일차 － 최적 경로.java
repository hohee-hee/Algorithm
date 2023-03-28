import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int N; //입력 받을 N
	static int[][] v,e; //정점 정보
	static boolean[] isVisited; //방문 여부 확인
	static int mindist; //최소 거리 저장
	static int[] path; //가능한 경로 저장
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T; tc++) {
			//1. 주어진 입력 값 받기
			N = sc.nextInt();
			v = new int[N+2][2];
			//회사 좌표 저장
			v[0][0] = sc.nextInt();
			v[0][1] = sc.nextInt();
			//집 좌표 저장
			v[N+1][0] = sc.nextInt();
			v[N+1][1] = sc.nextInt();
			//고객 정보 저장
			for(int i = 1 ; i < N+1 ; i++) {
				v[i][0] = sc.nextInt();
				v[i][1] = sc.nextInt();
			}
			
			//2. 변수 초기화
			mindist = Integer.MAX_VALUE;
			isVisited = new boolean[N+2];
			path = new int[N];
			

			//4. 가능한 모든 경로 살피기
			BackTracking(0, 0);
			System.out.println("#" + tc + " " + mindist);
		}
	
	
	
	}
	
	//백트래킹으로 가능한 경로 모두 찾기
	private static void BackTracking(int depth, int pre) {
		if(depth == N) {
			int sum = Math.abs(v[0][0] - v[path[0]][0]) + Math.abs(v[0][1] - v[path[0]][1]);  // 0 ~ path[0] 까지의 거리
			int pidx = 0;
			for(int i = 0 ; i < N-1 ; i++) {
				sum += Math.abs(v[path[i]][0] - v[path[i+1]][0]) + Math.abs(v[path[i]][1] - v[path[i+1]][1]);
				if(sum > mindist) return;
			}
			sum+= Math.abs(v[path[N-1]][0] - v[N+1][0]) + Math.abs(v[path[N-1]][1] - v[N+1][1]);

			mindist = Math.min(mindist, sum);			
			return;
		}
		
		for(int i = 1 ; i < N+1 ; i++) {
			if(!isVisited[i]) {				
				path[depth] = i;
				isVisited[i] = true;
				BackTracking(depth+1, i+1);
				isVisited[i] = false;
			}
		}
	}
	
}
