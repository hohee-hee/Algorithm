import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int cnt = 0;
			int[] guest = new int[11112];
			int time = 1; //소요시간
			
			//손님 입력 받기
			for(int i = 0 ; i < N ; i++) {
				int n = sc.nextInt();
				guest[n]++;				
			}
			
			//붕어빵 구우면서 손님 맞이하기
			boolean isPos = true; //가능여부를 나타내줄 flag
			int gdx = 0;
			for(int i = 0 ; i <= 11111 ; i++) {
				if(i>0 && i % M == 0) { cnt += K; }
				cnt -= guest[i];
				if(cnt < 0) {
					isPos = false;
					break;
				}
			}

			if(isPos) sb.append("#"+ tc+" Possible\n");
			else sb.append("#"+ tc+" Impossible\n");
			
		}
		System.out.println(sb);
	}
}
