import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 입력 받기
			int N = sc.nextInt(); //크기
			int[][] map = new int[N][N]; //맵 만들기
			int[][] holes = new int[10][2]; //웜홀의 정보를 저장할 배열
			for(int i = 0 ; i < 10 ; i++) Arrays.fill(holes[i], -1);
			
			//맵 정보 입력 받기
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					map[r][c] = sc.nextInt();
					if(map[r][c] >= 6) {
						if(holes[map[r][c] - 6][0] == -1) holes[map[r][c] - 6] = new int[]{r,c};
						else holes[map[r][c] - 1] = new int[]{r,c};
					}
				}
			}
			
//			for(int i = 0 ; i < 10 ; i++) System.out.println(Arrays.toString(holes[i]));
			//2. 돌면서 체크
			//최댓값을 저장할 변수
			int maxScore = Integer.MIN_VALUE;
			
			//-1. 시작점 찾기
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					// 시작할 수 없는 칸이면 다음 시작 지점 찾기
					if(map[r][c] != 0) continue;
					//4방향으로 진행시키기 : 좌 0 상 1 우 2 하 3
					for(int d = 0 ; d < 4 ; d++) {
						int score = 0; //점수 초기화
						int dir = d;
						boolean flag = false;
						
						//현재 위치 저장
						int cr = r;
						int cc = c;
						
						
//						int nr = cr;
//						int nc = cc;
//						System.out.println();
//						System.out.println(r + " " + c + " " + d);
						
						//해당 방향으로 진행시키기
						while(true) {
							
							int nr = cr;
							int nc = cc;
							
							
							if(!flag) {								
								//방향 맞춰서 진행
								switch(dir) {
								case 0: 
									nc--;
									break;
								case 1:
									nr--;
									break;
								case 2: 
									nc++;
									break;
								case 3: 
									nr++;
									break;
								}
							}
							
							flag = false;
//							System.out.println(nr + " " + nc + " " + dir + " " + score );
							
							//1. 벽인지 확인(index 체크이므로 먼저 하기)
							if(nc < 0 || nr < 0 || nr >= N || nc >= N) {
//								System.out.println(1);
								flag = true;
								
								//점수 올리기
								score++;
								
								//방향 반전 시키기
								dir = (dir+2) % 4;
								
								
								//출발점인지 체크 -> 출발점이면 종료
								if(cr == r && cc == c) break;
								
								
								continue;
							}
							
							//2. 웜홀인지 확인
							if(map[nr][nc] >= 6) {
//								System.out.println(2);
								if(nr == holes[map[nr][nc] - 6][0] && nc == holes[map[nr][nc] - 6][1]) {
//									System.out.println(r + " " + c + " " + d + "hole");
									cr = holes[map[nr][nc] - 1][0];
									cc = holes[map[nr][nc] - 1][1];
									continue;
								}
								else {
									cr = holes[map[nr][nc] - 6][0];
									cc = holes[map[nr][nc] - 6][1];
									continue;
								}
							}
							
							//3. 블록인지 확인
							if(map[nr][nc] >=1) {
//								System.out.println(3);
								//점수 처리
								score++;
								//방향 얻기
								dir = block(map[nr][nc]-1, dir);
								 
								//새 위치 지정
								cr = nr;
								cc = nc;
								
								continue;
							}
							
							//4. 블랙홀인지 확인
							if(map[nr][nc] == -1) {
//								System.out.println(4);
								break;
							}
							
							//5. 시작점인지 확인
							if(nr == r && nc == c) {
								break;
							}
							
							cc = nc;
							cr = nr;
						} 
//						while(!(nr == r && nc == c));
						
				
						//점수 계산
						if(maxScore < score) maxScore = score;
						
					}
				}
			}
			
			//출력하기
			sb.append("#" + tc + " " + maxScore + "\n");
		}
		
		System.out.println(sb);
	}

	private static int block(int bnum, int dir) {		
		
		//5번 블록일 때
		if(bnum == 4) return (dir + 2) % 4;
		
		//90도 일 때
		if(dir == bnum) return (dir + 1) % 4;
		if(dir == ((bnum+3)%4)) return (dir + 3) % 4;
		
		//나머지는 반전
		return (dir + 2) % 4;
	}
}
