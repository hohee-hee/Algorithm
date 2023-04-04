import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	//벽돌 관련 정보
	static int N, W, H;
	static int[][] bricks, clone;
	
	//조합 관련 정보
	static int[][] combi; //모든 조합 저장
	static int[] C; //현재 조합 정보
	static int cidx; // combi idx
	
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 입력 받기
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			//- 벽돌 정보 저장
			bricks = new int[H][W];
			//- 구슬을 칠 때 사용할 복사 배열
			clone = new int[H][W];
			//총 벽돌 개수
			int total = 0;
			for(int r = 0 ; r < H ; r++) {
				for(int c = 0 ; c < W ; c++) {
					bricks[r][c] = sc.nextInt();
					clone[r][c] = bricks[r][c];
					if(bricks[r][c] != 0) total++;
				}
			}
			
			//2. 가능한 모든 조합 구하기			
			int cnt = (int) Math.pow(W, N); //가능한 모든 조합의 수
			combi = new int[cnt][N]; //모든 조합을 저장할 배열
			cidx = 0; //combi idx
			C = new int[N]; //현재 조합을 저장할 배열
			
			//조합 찾기 - 재귀
			combi(0);
			
			//3. 구슬 던지기
			int maxScore = Integer.MIN_VALUE;
			for(int i = 0 ; i < cnt ; i++) {
				boolean check = true; //검사를 완료 했는지 확인할 flag
				int score = 0;
				for(int j = 0 ; j < N ; j++) {
					int col = combi[i][j]; //구슬로 칠 열의 번호
					
					//만약 해당 열에 벽돌이 없으면 현재 조합은 더 이상 검사하지 않는다.
					if(clone[H-1][col] == 0) {
						check = false;
						break;
					}
					
					//1. 가장 상단의 벽돌 찾기
					int range = 0; //해당 벽돌이 제거할 수 있는 범위
					int hidx = 0; //높이 정보 저장
					while(range == 0) range = clone[hidx++][col];
					
					//2. 벽돌깨기
					score += BFS(range-1, hidx-1, col); //깬 벽돌 수 받아오기
					
					//3. 재정렬
					move();
				}				
				
				if(check) {
				}
				//최댓값 갱신
				if(check && score > maxScore) maxScore = score;
				
				//배열 원상복구
				for(int r = 0 ; r < H ; r++) {
					for(int c = 0 ; c < W ; c++) {
						clone[r][c] = bricks[r][c];
					}
				}
			}
			if(maxScore == Integer.MIN_VALUE) System.out.println("#" + tc + " " + 0);
			else System.out.println("#" + tc + " " + (total - maxScore));
		}
	}


	private static void move() {
		
		ArrayDeque<Integer> s = new ArrayDeque<>();
		
		for(int c = 0 ; c < W ; c++) {
			//각 row를 방문하면서 0이 아닌 수 모두 스택에 푸시
			for(int r = 0 ; r < H ; r++) {
				if(clone[r][c] != 0) {
					s.offerFirst(clone[r][c]);
					clone[r][c] = 0;
				}
			}			
			
			int ridx = H-1; //row index
			while(!s.isEmpty()) clone[ridx--][c] = s.pollFirst(); //스택에서 하나씩 빼면서 다시 넣기
		}
		
		
	}


	private static int BFS(int range, int row, int col) {
		//깬 벽돌 수 저장
		int score = 0;
		
		//만약 제거 범위가 0이라면 해당 벽돌만 깨고 score = 1로 반환
		if(range == 0) {
			clone[row][col] = 0;
			return 1;
		}
		
		//델타 배열
		int[] dr = {0,-1,0,1};
		int[] dc = {-1,0,1,0};
		
		//큐
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offerLast(new int[] {range, row, col});
		
		//BFS
		while(!q.isEmpty()) {
			int ra = q.peekFirst()[0];
			int cr = q.peekFirst()[1];
			int cc = q.pollFirst()[2];
			if(clone[cr][cc] != 0) {
				clone[cr][cc] = 0;
				score++;
			}
			for(int r = 1 ; r <= ra ; r++) { //range만큼 4방 탐색
				for(int dir = 0 ; dir < 4 ; dir++) {
					int nr = cr + dr[dir] * r;
					int nc = cc + dc[dir] * r;
					
					//Bounds check
					if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
					
					//벽돌 유무 체크
					if(clone[nr][nc] == 0) continue;
					
					//큐에 넣기
					if(clone[nr][nc] > 1) q.offerLast(new int[] {clone[nr][nc]-1,nr,nc});
					
					//벽돌 깨기
					clone[nr][nc] = 0;
					score++;
				}
			}			
		}
		
		return score;
	}


	private static void combi(int depth) {
		//기저 조건
		if(depth == N) {
			//배열 복사
			for(int i = 0 ; i < N ; i++) combi[cidx][i] = C[i];
			
			//인덱스 갱신
			cidx++;
			
			//종료
			return;
		}
		
		//재귀 조건
		//증복이 가능하므로 visited 혹은 인덱스 조정은 하지 않는다.
		for(int i = 0 ; i < W ; i++) {
			C[depth] = i; 
			
			//재귀
			combi(depth+1);
		}
	}
}
