import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				for(int j = 0 ; j < 100 ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			int sum_r = 0;
			int sum_c = 0;
			
			for(int i = 0 ; i < 100 ; i++) {
				sum_r = 0;
				sum_c = 0;
				
				for(int j = 0 ; j < 100 ; j++) {
					sum_r += arr[i][j];
					sum_c += arr[j][i];
				}
				
				if(sum_r > max) max = sum_r;
				if(sum_c > max) max = sum_c;
			}
			
			sum_r = 0;
			sum_c = 0;
			//대각선 검사
			for(int i = 0 ; i < 100; i++) {
				sum_r += arr[i][i];
				sum_c += arr[i][99-i];
			}

			if(sum_r > max) max = sum_r;
			if(sum_c > max) max = sum_c;
			
			System.out.printf("#%d %d\n", n, max);
		}
	}
}
