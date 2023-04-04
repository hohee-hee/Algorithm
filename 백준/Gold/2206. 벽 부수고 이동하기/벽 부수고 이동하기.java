import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] map;
	static int[][][] dist;
	
	
	public static void main(String[] args) throws IOException {
		//1. 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//- 지도 정보 입력 받기
		map = new int[N][M];
		ArrayDeque<int[]> walls = new ArrayDeque<>(); //벽의 위치정보 저장
		for(int r = 0 ; r < N ; r++) { 
			String str = br.readLine();
			for(int c = 0 ; c < M ; c++) {
				map[r][c] = str.charAt(c) - '0';
				if(map[r][c] == 1) walls.offerLast(new int[] {r,c});
			}
		}
		
		
		//2. 거리를 저장할 배열
		// [0][N][M] : 출발지 -> 해당 위치
		// [1][N][M] : 도착지 -> 해당 위치
		dist = new int[2][N][M]; 
		//시작점, 출발점 1로 초기화
		dist[0][0][0]= 1;
		dist[1][N-1][M-1] = 1;
		
		//3. BFS : 벽 안부순 거리 구하기 + 출발지부터 해당 정점까지의 거리 구하기
		//- 큐 초기화
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offerLast(new int[] {0, 0});
		
		//BFS
		BFS(0, q);
		
		//최소 거리를 저장할 변수
		int minDist = dist[0][N-1][M-1];
		//만약 끝까지 가지 못해서 거리가 현재 최소거리가 0으로 저장되었다면 최댓값으로 변경
		if(minDist == 0) minDist = Integer.MAX_VALUE;
		
//		for(int i = 0 ; i < N ; i++) System.out.println(Arrays.toString(dist[0][i]));
		
		//4. BFS : 도착지부터 해당 정점까지의 거리 구하기
		//- 큐 초기화
		q = new ArrayDeque<>();
		q.offerLast(new int[] {N-1, M-1});
		
		//BFS
		BFS(1, q);
//		for(int i = 0 ; i < N ; i++) System.out.println(Arrays.toString(dist[1][i]));
		
		//5. 벽을 모두 방문하면서 최소 거리 구하기
		while(!walls.isEmpty()) {
			int wr = walls.peekFirst()[0];
			int wc = walls.pollFirst()[1];
			
			int dist = findMin(wr, wc);
			
			if(dist == -1) continue; //불가능
			if(minDist > dist+1) minDist = dist+1; //최솟값 갱신
			
		}
		
		if(minDist == Integer.MAX_VALUE) minDist = -1;
		System.out.println(minDist);
	}
			

	private static int findMin(int wr, int wc) {
		
		//1. 델타배열 선언
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		//2. 주변 체크하면서 최솟값 찾기
		int minNum = Integer.MAX_VALUE; //최솟값을 저장할 변수
		
		for(int i = 0 ; i < 4 ; i++) {
			int r0 = wr + dr[i];
			int c0 = wc + dc[i];
			if(r0 < 0 || r0 >= N || c0 < 0 || c0 >= M) continue;
			if(dist[0][r0][c0] == 0) continue;
			
			for(int j = 0 ; j < 4 ; j++) {
				//같은 칸일 때
				if(i == j) continue;
				
				int r1 = wr + dr[j];
				int c1 = wc + dc[j];
				
				//Bounds check
				if(r1 < 0 || r1 >= N || c1 < 0 || c1 >= M) continue;
				
				//거리 정보가 없을 때
				if(dist[1][r1][c1] == 0) continue;
				
				int td = dist[0][r0][c0] + dist[1][r1][c1];
				
				if(minNum > td) minNum = td;
			}
		}
		
		if(minNum == Integer.MAX_VALUE) minNum = -1;
		
		return minNum;
	}


	private static void BFS(int type, ArrayDeque<int[]> q) {
		
		//1. 델타배열 선언
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};

		//2. 방문 여부 체크 배열
		boolean[][] isVisited = new boolean[N][M];	
		
		//시작 정점 방문 표시
		if(type == 0) isVisited[0][0] = true;
		else isVisited[N-1][M-1] = true;
		
		//3. BFS
		while(!q.isEmpty()) {			
			int cr = q.peekFirst()[0];
			int cc = q.pollFirst()[1];
			
			for(int dir = 0 ; dir < 4 ; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];				
				
				//out of Bound
				if(nr < 0 || nr >= N || nc <0 || nc >= M) continue;
				
				//벽일 때
				if(map[nr][nc] == 1) continue;				
				
				//방문 했을 떄
				if(isVisited[nr][nc]) continue;				
				
				//방문 여부 체크
				isVisited[nr][nc] = true;

				//거리 체크
				dist[type][nr][nc] = dist[type][cr][cc] + 1;
				
				//enqueue
				q.offerLast(new int[] {nr,nc});
			}			
		}
	}

}