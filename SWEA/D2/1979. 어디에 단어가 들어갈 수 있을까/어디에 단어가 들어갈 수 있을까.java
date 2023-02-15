import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{		
			//입력 받기
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] board = new int[N][N]; //퍼즐판
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			//연속된 1의 개수 체크하기
			int len_x = 0; //가로 길이 체크
			int len_y = 0; //세로 길이 체크
			int answer = 0; //정답 저장
			
			for(int i = 0 ; i < N ; i++) {
				//초기화
				len_x = 0; 
				len_y = 0;
				for(int j = 0 ; j < N ; j++) {
					//길이 확인
					//만약 현재 위치의 퍼즐판에 0이 있다면 현재 저장된 길이가 K와 같은지 확인 
					// -> 같다면 정답에 1 더하기
					// 그 후에 길이를 0으로 초기화
					//만약 현재 위치의 퍼즐판에 1이 있다면 길이에 1 더해주기	
					

					//가로 길이 확인
					if(board[i][j] == 0) {
						if(len_x == K) { answer++; }
						len_x = 0;
					}
					else { len_x++; }
					
					//세로 길이 확인
					if(board[j][i] == 0) {
						if(len_y == K) { answer++; }
						len_y = 0;
					}
					else { len_y++; }
				}
                
				if(len_x == K) { answer++; }
				if(len_y == K) { answer++; }
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}