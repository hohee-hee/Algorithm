import java.util.Scanner;

public class Solution {
	
	//입력 값 저장
	static int N;
	static int K;
	static int[] arr;

	static int[] pset;
	static int cnt;	
	static int len;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			cnt = 0;
			//1. 입력 받기
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for(int i = 0 ; i < N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			//2. 길이 별 부분수열 구하기			
			for(int i = 1 ; i <= N ; i++) {
				len = i;
				pset = new int[i];
				powerset(0, 0);
			}
			
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

	private static void powerset(int idx, int adx) {
		//base condition
		if(idx == len) {
			int sum = 0;
			for(int i = 0 ; i < len ; i++) {
				sum += pset[i];
			}
			if(sum == K) cnt++;
			return;
		}
		
		for(int i = adx ; i < N ; i++) {
				pset[idx] = arr[i];
				powerset(idx+1, i+1);
//			}
		}
	}

}
