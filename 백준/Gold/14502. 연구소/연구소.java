import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, max;
	static int[][] map, wall;
	static ArrayList<int[]> blank, virus;
	
	public static void main(String[] args) throws IOException{
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		blank = new ArrayList<>();
		virus = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) blank.add(new int[] {i,j});
				else if(map[i][j] == 2) virus.add(new int[] {i,j});
			}
		}
		
		//2. BT
		wall = new int[3][2];
		max = Integer.MIN_VALUE;
		bt(0, 0);
		
		//3. 출력
		System.out.println(max);
		
	}

	private static void bt(int depth, int pre) {
		if(depth == 3) {
			//BFS
			int safe = BFS(blank.size() - 3);
			
			if(safe > max) max = safe;
			
			return;
		}
		
		for(int i = pre ; i < blank.size() ; i++) {
			//맵 변형
			map[blank.get(i)[0]][blank.get(i)[1]] = 1;
			bt(depth+1, i+1);
			//맵 원상복구
			map[blank.get(i)[0]][blank.get(i)[1]] = 0;
		}
	}

	private static int BFS(int cnt) {
		
		//1. 맵 복사하기
		int[][] copy = new int[N][M];
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		for(int i = 0 ; i < virus.size() ; i++) {
			ArrayDeque<int[]> q = new ArrayDeque<int[]>();
			q.offerLast(virus.get(i));
			
			while(!q.isEmpty()) {
				int cr = q.peekFirst()[0];
				int cc = q.pollFirst()[1];
				
				for(int dir = 0 ; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					//bounds chk
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					
					//blank chk
					if(copy[nr][nc] != 0) continue;
					
					//change
					copy[nr][nc] = 2;
					
					//enque
					q.offerLast(new int[] {nr,nc});
					
					cnt--;
				}
			}
			
		}
		
		
		return cnt;
	}
}
