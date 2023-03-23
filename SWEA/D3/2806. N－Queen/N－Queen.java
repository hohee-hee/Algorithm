
import java.util.Scanner;

public class Solution {
	
	static int N; //크기
	static int[] queen; //실제 퀸이 놓이는 위치 : row -> index col -> value
	static int cnt; //가능한 경우의 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//입력 및 초기화
			N = sc.nextInt();
			queen = new int[N];
			cnt = 0;
			//백트래킹
			BackTracking(0);
			
			//출력
			System.out.println("#" + tc + " " + cnt);
		}
		
	}

	private static void BackTracking(int row) {
		//기저조건 : 마지막 줄까지 줄마다 퀸을 하나씩 놓았을 떼
		if(row == N) {
			cnt++; //경우의 수를 더해주기
			return;
		}
		
		//재귀조건
		for(int col = 0 ; col < N ; col++) {				
			//윗 row와 같은 col에 놓일 때와 대각선에 있을 때 제외
			boolean attack = false; //공격 범위 안에 있는지 확인할 변수
			for(int i = 0 ; i < row ; i++) {
				int stone = queen[i]; //이미 놓여있는 퀸의 col위치
				//돌과 같은 col에 있을 때 || 돌의 좌하향 대각선에 있을 때 || 돌의 우하향 대각선에 있을때
				if(stone == col || stone + (row-i) == col || stone - (row-i) == col) {
					attack = true;
					break;
				}
			}
			if(attack) continue;
			
			//재귀 돌리기
			queen[row] = col;
			BackTracking(row+1);
		}
	}
}
