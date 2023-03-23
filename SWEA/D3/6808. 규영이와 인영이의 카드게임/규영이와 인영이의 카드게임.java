import java.util.Scanner;

public class Solution {
	
	static int[] k_card, i_card; //규영이와 인영이의 카드리스트
	static int win; // 규영이가 이기는 횟수
	static int win_num = 19 * 9 / 2 + 1; //이기기 위해 필요한 최소 점수 = 19*9 / 2 + 1			
	static boolean[] isUsed; //이미 낸 카드인지 체크
	static int score; //규영이의 점수 계산
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 변수 초기화 및 입력 받기			
			//변수 초기화
			k_card = new int[9];
			i_card = new int[9];
			win = 0;
			isUsed = new boolean[9];
			
			boolean[] isGiven = new boolean[19]; //이미 배부된 카드인지 확인하기 위한 변수	
			int round = 9*8*7*6*5*4*3*2*1; //가능한 경우의 수			
			
			//규영이 카드 입력 받기
			for(int i = 0 ; i < 9 ; i++) {
				k_card[i] = sc.nextInt();
				isGiven[k_card[i]] = true;
			}
			//인영이 카드 정보 입력
			int idx = 0;
			for(int i = 1 ; i < 19 ; i++) {
				if(!isGiven[i]) i_card[idx++] = i;
			}
			
			//2. 백트래킹
			BackTracking(0);
			
			//3. 출력
			System.out.println("#" + tc + " " + win + " " + (round - win));
		}
	}

	private static void BackTracking(int level) {
		//base condition
		if(level == 9) {
			//이길 수 있는 최소점보다 규영이의 점수가 높을때
			if(win_num <= score) {
				win++;
			}
			return;
		}
		
		//recursive condition
		for(int i = 0 ; i < 9 ; i++) {
			//이미 낸 카드일 때
			if(isUsed[i]) continue;
			
			//안 낸 카드일 때
			int restore = score; //점수의 원상복구를 위해 임시로 이전 점수를 저장
			//규영이 카드의 수가 크면 점수 추가
			if(k_card[level] > i_card[i]) {
				score += k_card[level] + i_card[i];
			}
			//사용 체크
			isUsed[i] = true;
			//백트래킹
			BackTracking(level+1);
			//원상복구
			isUsed[i] = false;
			score = restore;
		}
	}
}
