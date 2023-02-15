import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{           
			int T = sc.nextInt(); //테스트 케이스
            int sum_x = 0; //가로합
            int sum_y =0; //세로합
            int max = 0; // 최댓값
            int[][] arr = new int[100][100]; //입력 배열


            //입력받기
            for(int i = 0 ; i < 100 ; i++) {
                for(int j = 0 ; j < 100 ; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            //가로세로 합 및 최댓값 구하기
            for(int i = 0 ; i < 100 ; i++) {
                sum_x = 0; //합계 값 초기화
                sum_y = 0; //합계 값 초기화
                for(int j = 0 ; j < 100 ; j++) {
                    sum_x += arr[i][j]; //가로합
                    sum_y += arr[j][i]; //세로합
                }
                //최댓값 구하기
                if(max < sum_x) { max = sum_x; }
                if(max < sum_y) { max = sum_y; }
            }

            //대각선 합 및 최댓값 구하기
            sum_x = 0; //합계 값 초기화
            sum_y = 0; //합계 값 초기화
            for(int i = 0 ; i < 100 ; i++) {
                sum_x += arr[i][i]; //우하향 대각선 합
                sum_y += arr[i][99-i]; //좌하향 대각선 합
                //최댓값 구하기
                if(max < sum_x) { max = sum_x; }
                if(max < sum_y) { max = sum_y; }
            }

            System.out.printf("#%d %d\n", T, max);
		}
	}
}