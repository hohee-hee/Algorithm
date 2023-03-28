import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] cheese;
	static boolean[][] isEaten;
	
	//델타 배열
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 입력 받기
			N = sc.nextInt();
			cheese = new int[N][N];
			HashSet<Integer> hs = new HashSet<>();
			//치즈 맛 입력 받기
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					cheese[i][j] = sc.nextInt();
					hs.add(cheese[i][j]);
				}
			}
			
			//2. hs to list
			ArrayList<Integer> list = new ArrayList<>(hs);
            list.add(0);
			Collections.sort(list);
			
			//4. 리스트 돌면서 계산
			int max = -1; //최댓값 저장
			for(int i = 0 ; i < list.size() ; i++) {
				//현재 날짜
				int day = list.get(i);
				//요정이 먹었는지 확인하기
				isEaten = new boolean[N][N];
				for(int r = 0 ; r < N ; r++) {
					for(int c = 0 ; c < N ; c++) {
						if(cheese[r][c] <= day)
							isEaten[r][c] = true;
					}
				}
                
				//BFS
				int cnt = 0;
				for(int r = 0 ; r < N ; r++) {
					for(int c = 0 ; c < N ; c++) {
						//이미 먹었다면 
						if(isEaten[r][c]) continue;
						
						//안먹었다면  BFS
						cnt++;
						int[] pt = {r,c};
						BFS(pt);
					}
				}
				//최솟값 계산
				max = Math.max(max, cnt);				
			}			
			
			//출력
			System.out.println("#" + tc + " " + max);
		}
		
	}
	
	private static void BFS(int[] pt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offerLast(pt);
		while(!q.isEmpty()) {
			//현재 노드
			int cr = q.peekFirst()[0];
			int cc = q.pollFirst()[1];
			for(int dir = 0 ; dir < 4 ; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				
				//out of idx
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				//방문 여부 혹은 요정의 취식 여부 확인
				if(isEaten[nr][nc]) continue;
				
				//방문체크
				isEaten[nr][nc] = true;
				
				//큐에 넣기
				int[] npt = new int[] {nr,nc};
				q.offerLast(npt);
			}
		}
	}
}
