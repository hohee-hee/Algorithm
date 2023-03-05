import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int[] arr = new int[10];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for(int i = 0 ; i < 10 ; i++) {
				arr[i] = sc.nextInt();
				if(arr[i] < min) min = arr[i];
				if(arr[i] > max) max = arr[i];
			}
			
			float cnt = 0;
			int sum = 0;
			for(int i = 0 ; i < 10 ; i++){
				if(arr[i] != min && arr[i] != max) {
					sum += arr[i];
					cnt++;
				}
			}
			
			int answer = Math.round(sum/cnt);
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
