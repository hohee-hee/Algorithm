import java.util.Scanner;

public class Solution {
	
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			int dir = 0; //방향을 저장할 변수
			int cr = 0; //현재 row 위치
			int cc = 0; //현재 column 위치
			
			//맵 입력받기
			int H = sc.nextInt(); //맵의 행 개수
			int W = sc.nextInt(); //맵의 열 개수
			map = new char[H+2][W+2]; //상하좌우 패딩을 포함한 map 선언	
			//맵 정보 입력받기
			//입력을 받다가 전차 위치가 나오면 현 위치에 저장 및 방향 저장
			for(int i = 1 ; i <= H ; i++ ) {
				String line = sc.next();
				for(int j = 1 ; j <= W ; j++) {
					map[i][j] = line.charAt(j-1);
					if(map[i][j] == '^' || map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v') {
						dir = getDir(map[i][j]);
						cr = i;
						cc = j;
						map[i][j] = '.'; //평지로 바꾸기
					}
				}
			}
			
			//명령 입력 받기
			int N = sc.nextInt(); //명령 개수
			String command = sc.next(); //전체 명령
			for(int i = 0 ; i < N ; i++) {
				//명령 수행
				char c = command.charAt(i);
				switch(c) {
				//shoot
				case 'S':
					shoot(cr, cc, dir);
					break;
					
				//방향 바꾸고 평지면 이동
				case 'L':
					dir = 1;
					if(map[cr][cc-1] == '.') { cc--; }
					break;
				case 'U':
					dir = 2;
					if(map[cr-1][cc] == '.') { cr--; }
					break;
				case 'R':
					dir = 3;
					if(map[cr][cc+1] == '.') { cc++; }
					break;
				case 'D':
					dir = 4;
					if(map[cr+1][cc] == '.') { cr++; }
					break;
				}
			}
			
			//현재 탱크 위치 표시
			if(dir == 1) {
				map[cr][cc] = '<';
			}
			else if(dir == 2) {
				map[cr][cc] = '^';
			}
			else if(dir == 3) {
				map[cr][cc] = '>';
			}
			else {
				map[cr][cc] = 'v';
			}
			//출력
			System.out.print("#" + tc + " ");
			for(int i = 1 ; i <= H ; i++ ) {				
				for(int j = 1 ; j <= W ; j++) {
					System.out.print(map[i][j]);
					}
				System.out.println();
				}
			}
		}
	

	//S 명령을 입력 받았을 때 맵을 변경해주는 메소드
	private static void shoot(int cr, int cc, int dir) {
		
		//현재 방향으로 한칸씩 이동하면서 현 위치가 평지나 물이라면 포탄을 계속 이동시킨다
		//그 외의 것들을 만나면 중단
		//마지막으로 현재 포탄 위치가 벽돌이라면 해당 위치의 정보를 평지로 바꾸기
		int nr = cr; //포탄의 현재 row 위치
		int nc = cc; //포탄의 현재 col 위치
		switch(dir) {
		//탱크가 왼쪽을 바라보고 있을 때
		case 1:
			nc--;
			while(map[nr][nc] == '.' || map[nr][nc] == '-') { nc--; }
			break;
			
		//탱크가 위를 바라보고 있을 때
		case 2:
			nr--;
			while(map[nr][nc] == '.' || map[nr][nc] == '-') { nr--; }
			break;
			
		//탱크가 오른쪽을 바라보고 있을 때
		case 3:
			nc++;
			while(map[nr][nc] == '.' || map[nr][nc] == '-') { nc++; }
			break;
			
		//탱크가 아래를 바라보고 있을 때
		case 4:
			nr++;
			while(map[nr][nc] == '.' || map[nr][nc] == '-') { nr++; }
			break;
		}
		//만약 while문을 종료한 지점에 벽돌로 만들어진 벽이 있다면
		//평지로 바꿔주기
		if(map[nr][nc] == '*') { map[nr][nc] = '.'; }
		
	}
	
	//방향을 정수로 변형해주는 메소드

	//맵의 방향을 받을 메소드
	private static int getDir(char tank) {
		switch(tank) {
		case '<':
			return 1;
		case '^':
			return 2;
		case '>':
			return 3;
		case 'v':
			return 4;
		}
		return -1;
	}
}
