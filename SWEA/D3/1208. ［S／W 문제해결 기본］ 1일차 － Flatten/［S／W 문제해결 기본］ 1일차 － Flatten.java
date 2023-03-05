import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			for(int i = 0 ; i < 100 ; i++)
				box[i] = sc.nextInt();

			Arrays.sort(box);
			
			for(int i = 0 ; i < dump ; i++) {
				
				if(box[99] - box[0] <= 1) break;
				
				box[99]--;
				box[0]++;
				
				Arrays.sort(box);			
			}
			
			System.out.printf("#%d %d\n", tc, box[99]-box[0]);
		}
	}
}
