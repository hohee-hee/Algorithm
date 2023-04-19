import java.util.*;
import java.io.*;


public class Main {
	
	static int N, M, minT;
	static int[][] map, time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//1. 입력 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//전역 변수 초기화
		map = new int[N][N];
		
		//바이러스를 놓을 수 있는 곳을 저장할 배열
		ArrayList<int[]> pos = new ArrayList<>();
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				//바이러스를 놓을 수 있는 칸이면 리스트에 따로 저장
				if(map[r][c] == 2) {
					pos.add(new int[] {r,c});
					map[r][c] = 0; //빈칸으로 바꾸기
				}
			}
		}
		
		//2. BackTracking
		minT = Integer.MAX_VALUE;
		int[][] virus = new int[M][2];
		bt(0, 0, pos, virus);
		
		//3. 출력
		if(minT == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minT);
	}

	private static void bt(int depth, int pre, ArrayList<int[]> pos, int[][] virus) {
		if(depth == M) {
			time = new int[N][N];
			BFS(virus);		
			return;
		}	
		
		for(int i = pre ; i < pos.size() ; i++) {
			virus[depth] = pos.get(i);
			bt(depth+1, i+1, pos, virus);
		}
	}

	private static void BFS(int[][] virus) {
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};		
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i = 0 ; i < M ; i++) {
			q.offerLast(new int[] {virus[i][0], virus[i][1]});
			time[virus[i][0]][virus[i][1]] = 1;
		}
		
		//time 배열에 체크하기
		while(!q.isEmpty()) {
			int cr = q.peekFirst()[0];
			int cc = q.pollFirst()[1];
			
			for(int dir = 0 ; dir < 4 ; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				
				//bounds chk
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				//if wall
				if(map[nr][nc] == 1) continue;
				
				//if visited
				if(time[nr][nc] != 0) continue;
				
				//시간 체크
				time[nr][nc] = time[cr][cc] + 1;
				
				if(time[nr][nc] > minT) return;
				
				//enque
				q.offerLast(new int[] {nr,nc});
				
			}
			
		}
		
			
		
		
		//시간 찾기
		boolean isPos = true;
		
		int t = 0;
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				if(time[r][c] == 0 && map[r][c] != 1) return;
				if(t < time[r][c]) t = time[r][c];				
			}
		}
		
		if(t-1 < minT) minT = t-1;
		return;
	}
}
