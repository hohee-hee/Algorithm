import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 변수 입력 받기
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		//큐
		ArrayDeque<int[]> qa = new ArrayDeque<>();
		ArrayDeque<int[]> qb = new ArrayDeque<>();
		
		//지도 그리기
		char[][] maze = new char[R][C];
		int[] loc = new int[3]; //지훈이의 초기 위치
		for(int i = 0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				maze[i][j] = str.charAt(j);
				if(maze[i][j] == 'F') {
					int[] pt = {-1, i, j};
					qa.offerLast(pt);
				}
				else if(maze[i][j] == 'J') {
					loc =  new int[]{-2, i, j};
				}
			}
		}
		qa.offerLast(loc);
		
		int[][] time = new int[R][C];
		
		//BFS
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		int cur = 0; //현재 시간
		
		while(!qa.isEmpty() || !qb.isEmpty()) {		
			cur++;
			while(!qa.isEmpty()) {
				int type = qa.peekFirst()[0];
				int cr = qa.peekFirst()[1];
				int cc = qa.pollFirst()[2];
				for(int dir = 0 ; dir < 4 ; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					//out of index
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
						if(type == -2) {
							System.out.println(cur);
							return;
						}
						continue;
					}
					
					//벽이거나 불이면 이동 불가
					if(maze[nr][nc] == '#' || maze[nr][nc] == 'F') continue;	
					
					//시간 체크
					if(time[nr][nc] != 0) continue;	
					
					time[nr][nc] = cur;
					//큐에 넣기
					int[] pt = new int[] {type, nr, nc};
					qb.offerLast(pt);
				}
			}
			boolean check = false;
			
			while(!qb.isEmpty()) {
				if(qb.peekFirst()[0] == -2) check = true;
				qa.offerLast(qb.pollFirst());
			}
			
			if(!check) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		
	}
}
