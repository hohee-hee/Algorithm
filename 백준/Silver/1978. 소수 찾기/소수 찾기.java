import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i = 0 ; i < N ; i++) {
			nums[i] = sc.nextInt();			
		}
		
		for(int i = 0 ; i < N ; i++) {
			int cnt = 0;
			if(nums[i] == 1) continue;
			for(int j = 2 ; j <= nums[i]; j++) {
				if(nums[i] % j == 0) {
					cnt++;
				}
			}
			if(cnt == 1) answer++;
		}
		
		System.out.println(answer);

	}

}
