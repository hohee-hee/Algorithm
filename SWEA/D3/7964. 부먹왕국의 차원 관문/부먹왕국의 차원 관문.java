import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테케 수
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <=T ; tc++) {
			int N = sc.nextInt(); //부먹왕국의 도시 수
			int D = sc.nextInt(); //제한 거리
			boolean[] map = new boolean[N+1];
			
			//지도 만들기
			for(int i = 1 ; i <= N ; i++) {
				int door = sc.nextInt();
				if(door == 1) map[i] = true;
			}
			
			int cnt = 0; //건설 해야하는 관문의 수
			
			//관문 개수 파악 후 설치하기
			for(int i = 1 ; i <= N-D ; i++) {
				boolean isDoor = false; //관문의 유무 확인
				if(map[i]) {
					for(int j = 1 ; j <= D ; j++) {
						if(map[i+j]) {
							isDoor = true;
							break;
						}
					}
					if(isDoor == false) {
						map[i+D] = true;
						cnt++;
					}
				}
				
				else {
					for(int j = 1 ; j < D ; j++) {
						if(map[i+j]) {
							isDoor = true;
							break;
						}
					}
					if(!isDoor) {
						map[i] = true;
						cnt++;
						if(!map[i+D]) {
							map[i+D] = true;
							cnt++;
						}
					}
				}
			}
			sb.append("#" + tc + " " + cnt+"\n");
		}
		
		System.out.println(sb);
	}	
}
