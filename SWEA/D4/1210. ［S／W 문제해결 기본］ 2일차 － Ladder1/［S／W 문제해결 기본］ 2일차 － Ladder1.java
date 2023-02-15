import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{		
			
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T = sc.nextInt();
			int[][] ladder = new int [100][100]; //사다리판
			int c_col = 0; //현재 지점의 col 좌표 : X 지점의 col 인덱스를 할당받을 예정
			int c_row = 99; //현재 지점의 row 좌표 : X 지점의 row 인데스를 할당받을 예정
			
			//입력받기
			for(int i = 0 ; i < 100 ; i++) {
				for(int j = 0 ; j < 100 ; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j] == 2) { c_col = j; } //X 지점 찾기
				}
			}
			
			//사다리 역으로 타기
			while(c_row != 0) {
				if(c_col != 0 && ladder[c_row][c_col - 1] == 1){ 
					ladder[c_row][c_col - 1] = 2;
					c_col--; 
				}
				else if(c_col != 99 && ladder[c_row][c_col + 1] == 1) { 
					ladder[c_row][c_col + 1] = 2;
					c_col++; 
				}				
				else if(ladder[c_row - 1][c_col] == 1) { 
					ladder[c_row - 1][c_col] = 2; 
					c_row--; 
				}	
			}
			
			System.out.printf("#%d %d\n", T, c_col);
		}
	}
}