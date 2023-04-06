import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, answer;
	static int[][] office; //사무실 맵
	static ArrayList<int[]> cctv;
	
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		//1. 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// - 사무실 정보 입력받기
		cctv = new ArrayList<>(); //cctv 정보
		office = new int[N][M];
		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c= 0 ; c < M ; c++) {
				office[r][c] = Integer.parseInt(st.nextToken());
				if(office[r][c] > 0 && office[r][c] < 6) cctv.add(new int [] {office[r][c], r, c});
			}
		}
        
        //cctv가 한 대도 없을 때
        if(cctv.size() == 0) {
			int tmp = 0;
			for(int r = 0 ; r < N ; r++) {
				for(int c= 0 ; c < M ; c++) {
					if(office[r][c] == 0) tmp++;
				}
			}
			System.out.println(tmp);
			return;
		}

		Collections.sort(cctv, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}			
		});
		
		//5번 cctv는 무조건 바꾸고 시작]
		while(cctv.size() != 0 && cctv.get(0)[0] == 5) {
			for(int dir = 0 ; dir < 4 ; dir++) {
				change(dir, cctv.get(0)[1],cctv.get(0)[2]);
			}
			cctv.remove(0);
		}
		
		answer = Integer.MAX_VALUE;
		
		BackTracking(0);
		System.out.println(answer);
	}

	private static void BackTracking(int depth) {
		if(depth == cctv.size()) {
			//개수 세기
			int tmp = 0;
			for(int r = 0 ; r < N ; r++) {
				for(int c= 0 ; c < M ; c++) {
					if(office[r][c] == 0) tmp++;
				}
			}
			if(answer > tmp) {
				answer = tmp;
			}
			return;
		}
		
		//재귀조건
		for(int i = depth ; i < cctv.size() ; i++) {
			//원상 복구를 위한 배열 만들기
			int[][] restore = new int[N+1][M+1];
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < M ; c++) {
					restore[r][c] = office[r][c];
				}
			}
			
			int[] cInfo = cctv.get(i);
			if(cInfo[0] == 5) continue;
			
			switch(cInfo[0]) {
				case 1 :
					for(int dir = 0 ; dir < 4 ; dir++) {
						change(dir, cInfo[1],cInfo[2]);
						BackTracking(i+1);	
						for(int r = 0 ; r < N ; r++) {
							for(int c = 0 ; c < M ; c++) {
								office[r][c] = restore[r][c];
							}
						}
					}
					break;
					
				case 2 :
					for(int dir = 0 ; dir < 2 ; dir++) {
						change(dir, cInfo[1],cInfo[2]);
						change(dir+2, cInfo[1],cInfo[2]);	
						BackTracking(i+1);	
						for(int r = 0 ; r < N ; r++) {
							for(int c = 0 ; c < M ; c++) {
								office[r][c] = restore[r][c];
							}
						}
					}
					break;
					
				case 3 :
					for(int dir = 0 ; dir < 4 ; dir++) {
						change(dir, cInfo[1],cInfo[2]);
						change((dir+1) % 4, cInfo[1],cInfo[2]);	
						BackTracking(i+1);	
						for(int r = 0 ; r < N ; r++) {
							for(int c = 0 ; c < M ; c++) {
								office[r][c] = restore[r][c];
							}
						}
					}
					break;
					
				case 4 :
					for(int dir = 0 ; dir < 4 ; dir++) {
						change(dir, cInfo[1],cInfo[2]);
						change((dir+1) % 4, cInfo[1],cInfo[2]);	
						change((dir+2) % 4, cInfo[1],cInfo[2]);	
						BackTracking(i+1);	
						for(int r = 0 ; r < N ; r++) {
							for(int c = 0 ; c < M ; c++) {
								office[r][c] = restore[r][c];
							}
						}
					}
					break;
			}
			
			//원상복구하기
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < M ; c++) {
					office[r][c] = restore[r][c];
				}
			}
			
		}		
		
	}

	private static void change(int d, int row, int col) {
		int nr = row;
		int nc = col;
		//종료 조건 : 범위를 벗어났거나 벽을 마주했을 때
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;
			if(office[nr][nc] == 6) break;
			if(office[nr][nc] == 0) {
				office[nr][nc] = -1;
			}
		}
	}
	
}
