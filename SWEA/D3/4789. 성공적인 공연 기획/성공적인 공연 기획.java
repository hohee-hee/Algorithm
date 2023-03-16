import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			String str = sc.next();
			int up = 0;
			int need = 0;
			for(int i = 0 ; i < str.length(); i++) {
				int N = str.charAt(i) - '0';
				if(up < i) {
					need += i-up;
					up += i-up;
				}
				up += N;
			}
			System.out.printf("#%d %d\n", tc, need);
		}
	}
}
