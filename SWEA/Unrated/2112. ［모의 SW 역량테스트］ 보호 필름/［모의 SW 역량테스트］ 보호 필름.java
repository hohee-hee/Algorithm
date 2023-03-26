
import java.util.Scanner;

public class Solution {
	
	static int D, W, K;
	static boolean[][] film; //필름 정보
	static int min; //최소 횟수
	
	//투약시 사용할 배열
	static boolean[] A, B;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//변수 입력 받기
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			//변수 초기화
			film = new boolean[D][W];		
			min = Integer.MAX_VALUE;
			A = new boolean[W];
			B = new boolean[W];
			for(int i = 0 ; i < W ; i++) {
				A[i] = false;
				B[i] = true;
			}
			
			//입력 받기
			for(int i = 0 ; i < D ; i++) {
				for(int j = 0 ; j < W ; j++) {
					int n = sc.nextInt();
					if(n == 1) film[i][j] = true;
				}
			}
			
			//백트래킹
			BackTracking(0, 0);
			
			//출력
			System.out.println("#" + tc + " " + min);
			
			
		}
	}

	private static void BackTracking(int level, int cnt) {
		
		//base : 
		if(cnt >= min) return;		
		if(level == D) {
			//테스트를 통과했다면 최솟값 갱신
			if(isPromising()) min = cnt;
			return;
		}
		
		//원본 복사
		boolean[] restore = film[level];

		//약물 투여 x
		BackTracking(level+1, cnt);
		
		//A 투약
		potion(false, level);
		BackTracking(level+1, cnt+1);
		
		//B투약
		potion(true, level);
		BackTracking(level+1, cnt+1);

		//원본 복구
		film[level] = restore;
		
	}

	//투약
	private static void potion(boolean type, int level) {
		//A일 때
		if(type) film[level] = A;
		
		//B일 때
		else film[level] = B;
		
	}
	
	//테스트 
	private static boolean isPromising() {		
		
		for(int i = 0 ; i < W ; i++) {
			//현재 줄의 패스 여부를 확인
			boolean pass = false;
			//동일한 특성을 가진 셀의 개수
			int cell = 1;
			//동일한 특성을 가진 셀의 개수 계산
			for(int j = 1 ; j < D ; j++) {
				//만약 앞 row와 특성이 같다면
				//cell의 개수 카운트
				if(film[j][i] == film[j-1][i]) cell++;
				//그렇지 않다면 초기화
				else cell = 1;
				
				//만약 cell의 개수가 K와 같다면 pass
				if(cell == K) {
					pass = true;
					break;
				}
			}
			
			//만약 pass하지 못한 column이 생기면 바로 중단
			if(!pass) {
				return false;
			}
		}
		return true;
		
	}
}
