import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			char[][] arr = new char[5][];
			
			for(int i = 0 ; i < 5 ; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			String ans = "";
			
			for(int i = 0 ; i < 15 ; i++) {
				for(int j = 0 ; j < 5; j++) {
					if(i >= arr[j].length || arr[j][i] == '\u0000') {
						continue;
					}
					ans += arr[j][i];
				}
			}
			
			System.out.printf("#%d %s\n", tc, ans);
		}			
	}
}
