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
				
				//1. 현 위치에 관문이 있을 때
				//- i+1 ~ i+D까지의 관문을 모두 살펴본다
				//	- 범위 내에 관문이 없으면 i+D에 관문 설치
				//	- 있으면 다음 pass로 넘어가기
				if(map[i]) {
					//범위 내 관문 유무 확인
					for(int j = 1 ; j <= D ; j++) {
						if(map[i+j]) {
							isDoor = true;
							break;
						}
					}
					//관문이 없다면 i+D에 관문 설치
					if(!isDoor) {
						map[i+D] = true;
						cnt++;
					}
				}
				
				//2. 현 위치에 관문이 없을 때
				//- i+1 ~ i+D-1까지의 관문을 모두 살펴본다
				//	- 범위 내에 관문이 없으면
				//		- i에 관문 설치
				//		- i+D에도 관문에 없으면 i+D에도 관문 설치
				//	- 있으면 다음 pass로 넘어가기
				else {
					//범위 내 관문 유무 확인
					for(int j = 1 ; j < D ; j++) {
						if(map[i+j]) {
							isDoor = true;
							break;
						}
					}
					//관문이 없다면 i에 관문 설치
					if(!isDoor) {
						map[i] = true;
						cnt++;
						//i+D에도 관문에 없으면 i+D에도 관문 설치
						if(!map[i+D]) {
							map[i+D] = true;
							cnt++;
						}
					}
				}
			}
			
			//출력
			sb.append("#" + tc + " " + cnt+"\n");
		}
		
		System.out.println(sb);
	}	
}
