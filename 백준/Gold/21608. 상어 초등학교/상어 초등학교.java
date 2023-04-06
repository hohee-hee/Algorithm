import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] classroom, count;
	
	
	public static void main(String[] args) throws IOException {		
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //N
		int[][] stu = new int[N*N][5]; //학생 정보
		
		//학생 정보 저장하기
		for(int i = 0 ; i < N*N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				stu[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. 필요한 배열 만들기
		classroom = new int[N+1][N+1]; //교실
		int[][] seat = new int[N*N+1][2]; //학생들의 좌석 정보 저장
		
		//3. 첫 학생 앉히기 : 무조건 2,2
		classroom[2][2] = stu[0][0];
		seat[stu[0][0]][0] = seat[stu[0][0]][1] = 2;
		
		//4. 자리 정하기
		//델타배열
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		//자리 정하기
		for(int i = 1 ; i < N*N ; i++) {
			//1. 좋아하는 학생의 인접 좌석 중 빈 좌석을 찾고, 그 빈도수도 같이 찾기
			//빈도수를 저장할 배열
			count = new int[N+1][N+1];
			
			int max = 0;
			for(int j = 1 ; j < 5 ; j++) {				
				int stnum = stu[i][j]; //학생 번호
				
				//- 아직 좌석이 지정되지 않았다면 pass
				if(seat[stnum][0] == 0) continue;
			
				//델타 탐색
				int cr = seat[stnum][0];
				int cc = seat[stnum][1];
				
				for(int dir = 0 ; dir < 4 ; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					//Bounds check
					if(nr < 1 || nc < 1 || nr > N || nc > N) continue;
					
					//빈자리가 아니면 pass
					if(classroom[nr][nc] != 0) continue;
					
					//자리 후보에 넣기 == 자리 카운팅하기
					count[nr][nc]++;
					
					//최댓값저장
					if(max < count[nr][nc]) max = count[nr][nc];				
				}
			}
			
            //2. 문제 조건 1을 만족하는 칸의 개수 세기
			int cnt = counting(max);
			
			//3. 만약 칸이 1개라면 1번 조건에서 끝 : 바로 그 칸에 집어넣기
			if(cnt == 1) {
				int[] set = setSeat(max, stu[i][0]);
				seat[stu[i][0]][0] = set[0];
				seat[stu[i][0]][1] = set[1];
				continue;
			}
			
			//4. 만약 칸이 여러개라면 2번 조건 계산하기
			int max2 = 0;
			for(int r = 1 ; r <= N ; r++) {
				for(int c = 1 ; c <= N ; c++) {
					//인접이 아니면 pass
					if(count[r][c] != max) continue;
					
					//빈자리가 아니면 아니면 pass
					if(classroom[r][c] != 0) continue;
					
					for(int dir = 0 ; dir < 4 ; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						
						//Bounds check
						if(nr < 1 || nc < 1 || nr > N || nc > N) continue;
						
						
						//빈자리가 아니면 pass
						if(classroom[nr][nc] != 0) continue;
						
						// 자리 카운팅 하기							
						count[r][c]++;			
					}
					//최댓값 갱신
					if(max2 < count[r][c]) max2 = count[r][c];
				}
			}		
			
			//5. 개수 세기
			cnt = counting(max2);
			
			int[] set = setSeat(max2, stu[i][0]);
			seat[stu[i][0]][0] = set[0];
			seat[stu[i][0]][1] = set[1];
			
		}
		
		//5. 만족도 조사
		int good = 0;
		for(int i = 0 ; i < N*N ; i++) {
			int stnum = stu[i][0];
			int cnt = 0;
			for(int j = 1; j < 5; j++) {
				if(Math.abs(seat[stnum][0] - seat[stu[i][j]][0]) + Math.abs(seat[stnum][1] - seat[stu[i][j]][1]) == 1)
					cnt++;				
			}
			good += Math.pow(10,  cnt-1);
		}
		
		//6.출력
		System.out.println(good);
		
	}

	private static int[] setSeat(int max, int stnum) {
		for(int r = 1 ; r <= N ; r++) {
			for(int c = 1 ; c <= N ; c++) {	
				if(classroom[r][c] != 0) continue;
				if(count[r][c] == max) {
					classroom[r][c] = stnum;
					return new int[] {r,c};
				}
			}
		}
		return null;
	}

	private static int counting(int max) {
		int cnt = 0;	
		for(int r = 1 ; r <= N ; r++) {
			for(int c = 1 ; c <= N ; c++) {
				if(count[r][c] == max) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
