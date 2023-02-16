import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt(); // field 넓이
			int M = sc.nextInt(); // 파리채 크기
			int[][] field = new int[N][N]; // field 2차원 배열
			// field 입력 받기
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					field[i][j] = sc.nextInt();
				}
			}
			
			// 순회하면서 max 찾기
			int max = 0; // 최댓값 초기화
			
			// 1. start point 찾기 (2중 for)
			for(int i = 0 ; i < N - M + 1 ; i++) {
				for(int j = 0 ; j < N - M + 1 ; j++) {					
					// 2. 파리채 영역에 맞게 더하기
					int sum = 0; // 더할 변수 초기화
					for(int k = 0 ; k < M ; k++) {
						for(int l = 0 ; l < M ; l++) {
							int nr = i + k; // 더해줄 row 좌표
							int nc = j + l; // 더해줄 col 좌표
							sum += field[nr][nc];
						}
					}
					
					// 3. 최댓값 찾기
					if(max < sum) { max = sum; }					
				}
			}
			
			System.out.printf("#%d %d\n", test_case, max);
			

		}
	}
}