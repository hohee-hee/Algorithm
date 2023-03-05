import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1 ; tc <= 10 ; tc++) {
			
			int N = sc.nextInt();
			
			int cr = 0; //현위치
			int cc = 0; //현위치
			
			int[][] ladder = new int[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				for(int j = 0 ; j < 100 ; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j] == 2) {
						cr = i;
						cc = j;
					}
				}
			}
			
			//한칸 위로 올라가기
			cr--;
			
			while(cr != 0) {
				ladder[cr][cc] = 2; //방문한 곳은 2로 바꾸기
				
				//좌우 확인
				if(cc > 0 && ladder[cr][cc - 1] == 1) { cc--; }
				else if(cc < 99 && ladder[cr][cc + 1] == 1) { cc++; }
				//좌우 길이 없으면 위로
				else { cr--; }											
			}
			
			
			System.out.printf("#%d %d\n", tc, cc);
		}
	}
}
