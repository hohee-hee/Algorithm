import java.util.Scanner;

public class Solution {
	
	static int N, B; //입력값
	static int[] height; //키
	static int min, sum; //탑의 최소 높이와 합계
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			//1. 입력받기
			N = sc.nextInt();
			B = sc.nextInt();
			height = new int[N];
			for(int i = 0 ; i < N ; i++) {
				height[i] = sc.nextInt();
			}
			
			//2. 전역변수 초기화
			min = Integer.MAX_VALUE;
			sum = 0;
			
			//3. 백트래킹
			BackTracking(0);
			
			//4. 출력
			System.out.println("#" + tc + " " + min);
		}
	}


	private static void BackTracking(int pre) {
		//base
		if(sum >= B) {
			min = Math.min(min,  sum - B);
			return;
		}
		
		//recur
		for(int i = pre ; i < N ; i++) {
			sum += height[i];
			BackTracking(i+1);
			sum -= height[i];
			
		}
	}
}
