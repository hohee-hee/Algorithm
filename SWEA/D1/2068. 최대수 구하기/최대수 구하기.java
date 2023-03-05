import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int max = -1;
			
			for(int i = 0; i < 10 ; i++) {
				int n = sc.nextInt();
				if(max < n) max = n;
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
