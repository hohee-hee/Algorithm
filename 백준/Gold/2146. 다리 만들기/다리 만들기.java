import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map; //섬 정보 저장
	static int N; //map의 크기
	
	static int[][] dist; //거리 정보저장
	static boolean[][] isVisited; //방문 여부 체크
	
	public static void main(String[] args) throws IOException {
		//1. 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//- 지도 정보 입력 받기
		map = new int[N][N];
		for(int r = 0 ; r < N ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		//- 변수 초기화
		isVisited = new boolean[N][N];
		
		//2. 델타배열 선언
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		
		//3. 각 섬에 넘버링 하기  : BFS
		int num = 1;
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				//-1. 시작점 찾기
				//- 바다인 경우
				if(map[r][c] == 0) continue;
				//- 이미 방문한 경우
				if(isVisited[r][c]) continue;
				
				//- 시작점 찾았다!
				ArrayDeque<int[]> q = new ArrayDeque<>();
				q.offerLast(new int[] {r,c});
				map[r][c] = num;
				
				//2. BFS				
				while(!q.isEmpty()) {
					int cr = q.peekFirst()[0];
					int cc = q.pollFirst()[1];
					for(int dir = 0 ; dir < 4 ; dir++) {
						int nr = cr + dr[dir];
						int nc = cc + dc[dir];
						
						//out of Bound
						if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
						//바다 일때
						if(map[nr][nc] == 0) continue;
						//이미 방문했을 때
						if(isVisited[nr][nc]) continue;
						
						//방문체크
						isVisited[nr][nc] = true;
						
						//넘버링
						map[nr][nc] = num;
						
						//enqueue
						q.offerLast(new int[] {nr,nc});
					}			
				}
				
				//3. 섬 넘버링 더하기
				num++;
			}
		}		
		
		//3. 거리구하기
		int dmin = Integer.MAX_VALUE; //최소거리를 저장
		int[] minDist = new int[num-2]; //최소 거리를 저장할 배열
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				//-1. 시작점 찾기
				//- 바다인 경우
				if(map[r][c] == 0) continue;
				
				//- 시작점 찾았다!
				ArrayDeque<int[]> q = new ArrayDeque<>();
				q.offerLast(new int[] {r,c});
				num = map[r][c];
				
				//- 방문 여부 확인 변수 초기화
				isVisited = new boolean[N][N];
				
				//- 거리 저장할 배열 초기화
				dist = new int[N][N];				
				
				//2. BFS				
				while(!q.isEmpty()) {
					int cr = q.peekFirst()[0];
					int cc = q.pollFirst()[1];
					for(int dir = 0 ; dir < 4 ; dir++) {
						int nr = cr + dr[dir];
						int nc = cc + dc[dir];
						
						//out of Bound
						if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
						//바다가 아닐 때
						if(map[nr][nc] != 0) continue;
						//이미 방문했을 때
						if(isVisited[nr][nc]) continue;
						
						//방문체크
						isVisited[nr][nc] = true;
						
						//거리 추가
						dist[nr][nc] = dist[cr][cc] + 1;
						
						//enqueue
						q.offerLast(new int[] {nr,nc});
					}			
				}
				
				
				//3. 최소 거리 찾기
				int tmp = findDist(num);
				if(dmin > tmp) dmin = tmp;
				
				//4. 조기종료 조건 : 최소값이 1이면 더 이상 작아질 수 없음
				if(dmin == 1) {
					System.out.println(dmin);
					return;
				}	
				
			}
		}
		
		//출력
		System.out.println(dmin);		
	}	
	
	private static int findDist(int num) {
		//1. 반환할 변수
		int re = Integer.MAX_VALUE;
		
		//2. 델타배열 선언
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		//최소 거리 찾기
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				//바다거나 자기 자신이거나 이미 거리를 계산한 적이 있는 섬이면 pass
				if(map[r][c] <= num) continue;
				
				//그렇지 않으면 주변 4방향의 거리 보기
				for(int dir = 0 ; dir < 4 ; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					//out of Bound
					if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
					
					int ndist = dist[nr][nc];
					
					//주변거리가 0이면 섬이라는 의미이므로 pass
					if(ndist == 0) continue;
				
					//그렇지 않으면 re랑 비교해서 저장해주기
					if(re > ndist) re = ndist;
					//- 조기종료 조건 : 최소값이 1이면 더 이상 작아질 수 없음
					if(re == 1) return re;
				}
			}
		}		
		return re;
	}
}
