import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		//블록에 길 정보 넣기
		int[][] block = new int[R+1][C+1];
		for(int i = 0 ; i <= R ; i++) {
			if(i == 0 || i == R) {
				for(int j = 0 ; j <= C ; j++) {
					block[i][j] = -1;
				}
			}
			else {
				block[i][0] = -1;
				block[i][C] = -1;
			}
		}
		
		//상점 정보와 동근이 정보 넣기
		int side = -1; //방향
		int loc = -1; //위치
		int dr = -1; //동근이의 현재 위치
		int dc = -1; //동근이의 현재 위치
		
		//상점 정보
		int N = Integer.parseInt(br.readLine()); //상점 개수
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			side = Integer.parseInt(st.nextToken());
			loc = Integer.parseInt(st.nextToken());	
			
			if(side == 1) block[0][loc] = i+1;
			else if(side == 2) block[R][loc] = i+1;
			else if(side == 3) block[loc][0] = i+1;
			else if(side == 4) block[loc][C] = i+1;
		}
		
		//동근이 정보
		st = new StringTokenizer(br.readLine());
		side = Integer.parseInt(st.nextToken());
		loc = Integer.parseInt(st.nextToken());	
		if(side == 1) {
			dr = 0;
			dc = loc;
		}
		else if(side == 2) {
			dr = R;
			dc = loc;
		}
		else if(side == 3) {
			dr = loc;
			dc = 0;
		}
		else if(side == 4) {
			dr = loc;
			dc = C;
		}
		
		//거리 계산
		int[] dist = new int[N];
		int tmp = 0;
		//델타 배열 선언
		int[][] delta = {{-1, 0, 1, 0}, {0, -1, 0, 1}};
		for(int i = 0 ; i < 4 ; i++) {
			tmp = 0;
			//1. 방향찾기
			int cr = dr + delta[1][i];
			int cc = dc + delta[0][i];
			if(cr >= 0 && cr <= R && cc >= 0 && cc <= C && block[cr][cc] != 0) {
				side = i;
				
				//한바퀴 돌기
				while(cr != dr || cc != dc) {		
					//거리 더하기
					tmp++;
					
					//상점을 만나면 최단거리를 배열에 저장해두기
					if(block[cr][cc] > 0) {
						int ddx = block[cr][cc] - 1;
						if(dist[ddx] == 0 || dist[ddx] > tmp)
							dist[ddx] = tmp;						
					}
					
					//위치 바꾸기
					int nc = cc + delta[0][side];
					int nr = cr + delta[1][side];
					//범위를 벗어났을 때는 돌리기
					if(nr < 0 || nr > R || nc < 0 || nc > C) {				
						for(int j = 0 ; j < 4 ; j++) {
							if(j != side &&  j != (side+2) % 4) {
								int tc = cc + delta[0][j];
								int tr = cr + delta[1][j];
								if(tr >= 0 && tr <= R && tc >= 0 && tc <= C) {
									cr = tr;
									cc = tc;
									side = j;
									break;
								}
							}
						}
					}
					//아니라면 이동
					else {
						cc = nc;
						cr = nr;
					}
				}
			}
		}	

		//최단거리 합치기
		int minDist = 0;
		for(int i = 0 ; i < N ; i++) {
			minDist += dist[i];
		}
		System.out.println(minDist);
	}
}
