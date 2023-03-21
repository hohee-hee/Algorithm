import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int N, min;
	static int[][] S;
	static int[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			//입력받기
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			S = new int[N+1][N+1];
			A = new int[N/2];
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					S[i][j] = sc.nextInt();
				}
			}			
			cook(0,1);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	private static void cook(int idx, int num) {
		//base
		if(idx == N/2) {
			int ataste = 0;
			int btaste = 0;
			boolean[] check = new boolean[N+1];
			for(int i = 0 ; i < N/2 ; i++) {
				check[A[i]] = true;
			}
			
			for(int i = 1 ; i < N ; i++) {
				for(int j = i + 1 ; j < N+1 ; j++) {
					if(check[i] && check[j]) {
						ataste += S[i][j];
						ataste += S[j][i];						
					}
					else if(!check[i] && !check[j]) {
						btaste += S[i][j];
						btaste += S[j][i];									
					}
				}
			}
			
			min = Math.min(min, Math.abs(ataste - btaste));
			return;
		}
		
		//recursive
		for(int i = num ; i < N ; i++) {
			A[idx] = i;
			cook(idx+1, i+1);
		}
	}
}
