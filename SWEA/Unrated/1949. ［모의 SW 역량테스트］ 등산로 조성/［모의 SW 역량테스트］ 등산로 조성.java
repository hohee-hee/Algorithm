
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	
	static int N, K;
	static int[][] map;
	static boolean[][] isVisited;
	
	static int maxDist; //가장 긴 등산로의 거리
	
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ;tc++) {
			
			//1. 입력 받기
			N = sc.nextInt();
			K = sc.nextInt();
			
			//- 지도 입력 받기
			map = new int[N][N];
			int top = Integer.MIN_VALUE; //봉우리 높이
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ;c < N ; c++) {
					map[r][c] = sc.nextInt();					
					//최대 높이 = 봉우리 찾기
					if(map[r][c] > top) top = map[r][c];
					//
				}
			}
			//2. 등산로 찾기
			maxDist = Integer.MIN_VALUE;
			flag = false;
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					//시작점 찾기 = 봉우리 찾기					
					//높이가 top이 아니면 pass
					if(map[r][c] != top) continue;
					isVisited = new boolean[N][N];
					isVisited[r][c] = true;
					DFS(r,c,1);
					isVisited[r][c] = false;
				}
			}
			
			//3. 출력
			System.out.println("#" + tc + " " + maxDist);
			
		}
	}
	
	// true 땅을 판 상태
	//false 땅안팜
	private static void DFS(int cr, int cc, int dist) {
		
		//최댓값 갱신
		if(maxDist < dist) maxDist = dist;
		
		//델타배열
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};		
		
		//델타 탐색
		for(int dir = 0 ; dir < 4; dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			
			//bounds check
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			
			//방문 체크
			if(isVisited[nr][nc]) continue;
		
			//땅파기
			if(!flag) {
				for(int dig = 1 ; dig <= K ; dig++) {
					//0. 높이체크
					if(map[nr][nc] - dig >= map [cr][cc]) continue;
					
					//1. 땅파기
					map[nr][nc] -= dig;
					flag = true;
					
					//2. 방문 체크
					isVisited[nr][nc] = true;
					
					//3. DFS
					DFS(nr,nc,dist+1);
				
					//3. 원상 복구
					isVisited[nr][nc] = false;
					map[nr][nc] += dig;	
					flag = false;
				}
			}
			
			//땅 안팠을 때
			//0. 높이체크
			if(map[nr][nc] >= map [cr][cc]) continue;	
			
			//1. 방문 체크
			isVisited[nr][nc] = true;
			
			//2. DFS
			DFS(nr,nc,dist+1);
			
			//3. 원상 복구
			isVisited[nr][nc] = false;
		}
		
	}
}
