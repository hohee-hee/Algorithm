import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T ; test_case++) {
			int N = sc.nextInt();
			int value = 0;
			
			for(int i = 0 ; i < N ; i++) {
				String farm = sc.next();
				value += farm.charAt(N/2) - '0';
				
				if(i <= N/2) {
					for(int j = 0 ; j < i ; j++) {
						value += farm.charAt(N/2 + (j+1)) - '0';
						value += farm.charAt(N/2 - (j+1)) - '0';
					}
				}
				else {
					for(int j = 1 ; j < N - i % N ; j++) {
						value += farm.charAt(N/2 + j) - '0';
						value += farm.charAt(N/2 - j) - '0';
					}
				}
			}
			
			System.out.printf("#%d %d\n",test_case, value);
			
		}
	}
}
