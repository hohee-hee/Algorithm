import java.util.Scanner;

public class Solution {

	static int N, L;
	static int[][] ingre;
	static int[][] burger;
	static int max;
	static int len;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 입력 받기
			max = 0;
			N = sc.nextInt();            
			L = sc.nextInt();
			ingre = new int[N][2];
			for(int i = 0 ; i < N ; i++) {
				ingre[i][0] = sc.nextInt();
				ingre[i][1] = sc.nextInt();
			}
			
			
			for(int i = 1 ; i <= N ; i++) {
				len = i;
				burger = new int[i][2];
				maker(0, 0);
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}

	private static void maker(int idx, int bdx) {

		//base
		if(bdx == len) {
			int k_sum = 0; //칼로리 합
			int s_sum = 0; //점수 합
			for(int i = 0 ; i < len ; i++) {
				s_sum += burger[i][0];
				k_sum += burger[i][1];
				if(k_sum > L) return;
			}

			max = Math.max(max, s_sum);
			return;
		}
		
		//recursive
		for(int i = idx ; i < N ; i++) { 
			burger[bdx] = ingre[i];
			maker(i+1, bdx+1);							 
		}
			
	}	
}