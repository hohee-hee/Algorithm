import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//1. 입력 받기	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] board = new int[H][W];
		int cheese = 0;

		for(int r = 0 ; r < H ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < W ; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if(board[r][c] == 1) cheese++;
			}
		}
		//조기종료
		if(cheese == 0) {
			System.out.printf("%d \n%d",0,0);
			return;
			
		}
		
		int time = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(cheese);
		
		while(true) {
			//1. 종료 조건 체크
			boolean isBreak = true;
			end : for(int r = 0 ; r <  H ; r++) {
				for(int c = 0 ; c < W ; c++) {
					if(board[r][c] == 1) {
						isBreak = false;
						break end;
					}
				}
			}
			if(isBreak) break;
			
			//2. 구멍 찾아서 바꾸기 
			boolean[][] isVisited = new boolean[H][W];
			ArrayDeque<int[]> q = new ArrayDeque<int[]>();
			q.offer(new int[] {0,0});
			
			//뎉타
			int[] dr = {0,-1,0,1};
			int[] dc = {-1,0,1,0};
			
			while(!q.isEmpty()) {
				int cr = q.peekFirst()[0];
				int cc = q.pollFirst()[1];
				
				for(int dir = 0 ; dir < 4 ; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					//Bounds chk
					if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
					
					//방문 여부 확인
					if(isVisited[nr][nc]) continue;
					
					//1이면 pass
					if(board[nr][nc] == 1) continue;
					
					//enqueue					
					q.offerLast(new int[] {nr,nc});
					
					//방문 체크
					isVisited[nr][nc] = true;						
				}
							
			}
			
			//구멍은 2로 바꾸기
			for(int r = 0 ; r < H ; r++) {
				for(int c = 0 ; c < W ; c++) {
					if(isVisited[r][c] || board[r][c] == 1) continue;
					board[r][c] = 2;
				}
			}
			
			//3. 가장자리 찾기
			boolean[][] melt = new boolean[H][W]; //녹는지 안녹는지 여부 확인
			for(int r = 0 ; r < H ; r++) {
				for(int c = 0 ; c < W ; c++) {
					if(board[r][c] != 1) continue;
					
					for(int dir = 0 ; dir < 4 ; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						
						if(board[nr][nc] == 0) {
							melt[r][c] = true;
							break;
						}
					
					}
				}
			}
			
			//4. 녹이면서 개수 세기 및 원상복구
			int cnt = 0;
			for(int r = 0 ; r < H ; r++) {
				for(int c = 0 ; c < W ; c++) {
					if(board[r][c] == 1 && melt[r][c]) board[r][c] = 0;
					
					if(board[r][c] == 1) cnt++;
					
					if(board[r][c] == 2) board[r][c] = 0;
				}
			}
			
			//4. 시간
			time++;
			
			//5. 저장
			list.add(cnt);
		}
		
		//6. 출력
		if(time == 1) System.out.printf("%d \n%d", time, list.get(0));
		else System.out.printf("%d \n%d", time, list.get(time-1));
		
	}

}
