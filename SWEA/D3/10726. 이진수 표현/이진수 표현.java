import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String answer = "ON";
			for(int i = 0 ; i < N ; i++) {
				if(M % 2 == 0) {
					answer = "OFF";
					break;
				}
				M /= 2;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
