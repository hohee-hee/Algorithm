
import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args)  throws IOException {
		
		//1. 입력 받기 : 두개를 만들어서 적록색약용과 비색약인용으로 사용		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] doyoung = new char[N][N]; //비색약
		char[][] jaejoon = new char[N][N]; //색약
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				doyoung[i][j] = str.charAt(j);		
				if(doyoung[i][j] == 'R') jaejoon[i][j] = 'G';
				else jaejoon[i][j] = doyoung[i][j];
			}
		}
		
		//2. 구역 찾기
		int noRed = BFS(jaejoon, N);
		int yesRed = BFS(doyoung, N);
		
		//3. 출력
		System.out.println(yesRed + " " + noRed);
		
	}

	private static int BFS(char[][] map, int N) {
		//영역 개수(반환)
		int area = 0;
		
		//델타 배열
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		//방문 여부 확인
		boolean[][] isVisited = new boolean[N][N];
		
		//BFS
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				//1. 시작점 찾기
				if(isVisited[r][c]) continue; //이미 방문 했으면 pass
				
				//2. 큐에 넣기
				q.offerLast(new int[] {r,c});
				
				//3. 색상 받기
				char color = map[r][c];
				
				//4. 영역 개수 더하기
				area++;

				//5. BFS
				while(!q.isEmpty()) {
					int cr = q.peekFirst()[0];
					int cc = q.pollFirst()[1];
					
					for(int dir = 0 ; dir < 4 ; dir++) {
						int nr = cr + dr[dir];
						int nc = cc + dc[dir];
						
						//out of index
						if(nr < 0 || nc < 0 || nc >= N || nr >= N) continue;
						
						//visited
						if(isVisited[nr][nc]) continue;
						
						//different color
						if(map[nr][nc] != color) continue;
						
						//방문체크
						isVisited[nr][nc] = true;
						
						//enqueue
						q.offerLast(new int[] {nr,nc});
						
					}
				}	
			}
		}
		return area;
	}
}
