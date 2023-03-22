import java.util.Scanner;

public class Solution {
	
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			int T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt(); 
			
			System.out.printf("#%d %d\n",tc, recursive(N, M));
			
		}
	}

	private static int recursive(int n, int m) {
		//기저 조건
		if(m == 1) 	return n;
		
		//재귀 조건
		int y = recursive(n,m/2);
		if(m % 2 == 0) return y*y;
		else return y*y*n;
	}
}
