import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//1. 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//지도 입력 받기
		int[][] map = new int[N][N];
		//상어의 현 위치
		int cr = -1;
		int cc = -1;
		//물고기 수 체크
		int fishCnt = 0;
		
		for(int r = 0 ;r < N ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c= 0 ;c < N ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					cr = r; cc = c;
					map[r][c] = 0;
				}
				else if(map[r][c] > 0) fishCnt++;
			}
		}
		
		//- 조기종료 : 물고기가 1도 없을 때
		if(fishCnt == 0) {
			System.out.println(0);
			return;
		}
		
		//2. BFS
		//델타배열 : 위 좌 우 하
		int[] dr = {-1,0,0,1};
		int[] dc = {0,-1,1,0};
		
		int size = 2; //아기 상어의 크기
		int eaten = 0; //먹은 물고기의 수
		int time = 0; //시간
		
		while(true) {
			int[][] dist = new int[N][N]; //거리 저장 배열
			for(int i = 0 ; i < N ; i++) Arrays.fill(dist[i], -1); //-1로 모두 처리하기
			
			ArrayDeque<int[]> q = new ArrayDeque<>(); //큐
			q.offerLast(new int[] {cr,cc}); //현 상어 위치 저장
			dist[cr][cc] = 0;
			ArrayList<int[]> candidate= new ArrayList<>();
			int limit = Integer.MIN_VALUE;
			
			//1. 거리찾기
			while(!q.isEmpty()) {
				cr = q.peekFirst()[0];
				cc = q.pollFirst()[1];
				if(limit == dist[cr][cc]) break;
				
				for(int dir = 0 ; dir < 4 ; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					//Bounds chk
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					
					//방문체크
					if(dist[nr][nc] != -1) continue;
					
					//크기가 크다면 방문 불가
					if(map[nr][nc] > size) continue;					
					
					//크기가 작다면 멈추기
					if(map[nr][nc] > 0 && map[nr][nc] < size) {
						limit = dist[cr][cc] + 1;
						candidate.add(new int[] {nr,nc});
					}
					
					//거리 체크
					dist[nr][nc] = dist[cr][cc] + 1;					

					//enque
					q.offerLast(new int[] {nr,nc});
				}
			}
			
			//먹을 후보가 없으면 종료
			if(candidate.size()  == 0) break;
			
			//2. 먹기
			//정렬
			Collections.sort(candidate, new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] == o2[0]) return o1[1]-o2[1];
					return o1[0] - o2[0];
				}
			});
			
			int er = candidate.get(0)[0]; //먹을 물고기의 row
			int ec = candidate.get(0)[1]; //먹을 물고기의 col
			
			eaten++;
			time += limit;
			cr = er;
			cc = ec;
			map[er][ec] = 0;
            
			//3. 크기 체크
			if(eaten == size){
				size++;
				eaten = 0;
			}
			
			//4. 출발지 재지정 -> enque
			q.clear();
			q.offerLast(new int[] {cr,cc});
			
		}
		
		System.out.println(time);
	}
}
