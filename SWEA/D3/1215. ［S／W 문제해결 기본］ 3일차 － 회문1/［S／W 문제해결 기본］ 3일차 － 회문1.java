import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			int N = sc.nextInt();
			char[][] word = new char[8][8];
			for(int i = 0 ; i < 8 ; i++) {
				String str = sc.next();
				for(int j = 0 ; j < 8 ; j++) {
					word[i][j] = str.charAt(j);
				}
			}
			
			int answer = 0;
			for(int i = 0 ; i < 8 ; i++) {
				for(int j = 0 ; j <= 8-N ; j++) {
					boolean flag1 = true;
					boolean flag2 = true;

					for(int k = 0 ; k < (N+1)/2 ; k++) {
						if(word[i][j+k] != word[i][j+N-k-1]) {
							flag1 = false;
						}
					}
					
					for(int k = 0 ; k < (N+1)/2 ; k++) {
						if(word[j+k][i] != word[j+N-k-1][i]) {
							flag2 = false;
						}
					}
					
					if(flag1) answer++;
					if(flag2) answer++;
				}
				
			}					
			
			
			System.out.printf("#%d %d\n", tc, answer);
		}
			
	}
}
