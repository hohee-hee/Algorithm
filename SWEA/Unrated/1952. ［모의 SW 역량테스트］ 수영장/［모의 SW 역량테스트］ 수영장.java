import java.util.Scanner;

public class Solution {
	
	static int day, month, quater, year;
	static int[] cost1, cost3;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//1. 입력 받기
			day = sc.nextInt();
			month = sc.nextInt();
			quater = sc.nextInt();
			year = sc.nextInt();
			int[] plan = new int[13];
			cost1 = new int[13];	
			int costsum = 0; //1일권 혹은 1달권의 총 합을 저장할 변수
			for(int i = 1 ; i <= 12 ; i++) {
				plan[i] = sc.nextInt();
				cost1[i] = Math.min(day*plan[i], month);
				costsum += cost1[i];				
			} 
			
			//2. 백트래킹			
			min = Integer.MAX_VALUE;
			BackTracking(1, 0, costsum);
			
			min = Math.min(min, year);
			
			System.out.println("#" + tc + " " + min);
		}
	}


	private static void BackTracking(int m, int sum, int costsum) {
		//이미 최솟값을 넘어서 볼 필요도 없는 경우
		if(sum > year || sum > costsum) return;
		//최솟값을 안 넘었을 때 기저조건
		if(m >= 13) { 
			min = Math.min(min, sum);
			return;
		}
		
		//재귀
		//1. 1일 or 1개월권
		BackTracking(m+1,sum+cost1[m],costsum);
		//2. 3개월권
		BackTracking(m+3,sum+quater,costsum);
	}
}