import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int dist = 0;
			int speed = 0;
			int N = sc.nextInt();
			for(int i = 0 ; i < N ; i++) {
				int c = sc.nextInt();
				if(c == 1) {
					int change = sc.nextInt();
					speed += change;
				}
				else if(c == 2) {
					int change = sc.nextInt();
					speed -= change;
					if(speed < 0) speed = 0;
				}
				dist += speed;
			}
			System.out.printf("#%d %d\n", tc, dist);
		}
	}
}
