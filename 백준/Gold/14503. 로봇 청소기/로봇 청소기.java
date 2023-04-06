import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//1. 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. 청소하기
		int cr = r; //현 row
		int cc = c; //현 col
		int cnt = 0; //청소한 칸의 개수
		
		//델타배열 :북동남서
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		
		//반복
		outer : while(true) {
			
			//1. 청소 여부 확인
			if(room[cr][cc] == 0) {
				room[cr][cc] = -1;
				cnt++;
			}
			
			//2. 4방탐색
			boolean isDirty = false; //더러운 방이 있는지
			for(int dir = 0 ; dir < 4 ; dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				
				//Bounds chk
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				//청소해야하는 방이 있으면 체크하고 중단
				if(room[nr][nc] == 0) {
					isDirty = true;
					break;
				}
			}
			
			//3. 청소해야하는 칸이 없을 때
			if(!isDirty) {
				//1. 후진하기
				int nr = cr - dr[d];
				int nc = cc - dc[d];
				
				//Bounds chk
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

				//벽인지 체크 -> 벽이면 루프 종료
				if(room[nr][nc] == 1) break outer;
				
				//1번으로 돌아가기
				cr = nr; cc = nc;				
				continue;				
			}
			
			//4. 청소해야하는 칸이 있을 때
			while(true) {
				//회전
				d = (d+3) % 4;
				
				//검사
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(room[nr][nc] == 0) {
					cr = nr; cc = nc;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
