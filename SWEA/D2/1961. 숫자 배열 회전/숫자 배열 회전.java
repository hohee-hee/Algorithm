import java.util.Scanner;

public class Solution {
	
	static String[][] print;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt();
			//1. 배열 입력 받기
			char[][] arr = new char[N][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			
			//2. 출력용 배열 
			print = new String[N][3];
			
			//3. 돌리기
			for(int i = 0 ; i < 3 ; i++) {
				arr = rotate(N, arr, i);
			}
			
			//4. 출력
			System.out.printf("#%d\n", tc);
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					System.out.print(print[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	private static char[][] rotate(int N, char[][] arr, int idx) {
		char[][] n_arr = new char[N][N]; //return array
		int rdx = 0, cdx = 0; //row index, col, index
		for(int c = 0 ; c < N ; c++) {
			for(int r = N-1 ; r >=0 ; r--) {
				n_arr[rdx][cdx++] = arr[r][c];
			}
			rdx++;
			cdx = 0;
		}
		
		//출력용 배열에 집어넣기
		for(int i = 0 ; i < N ; i++) {
			String str = "";
			for(int j = 0 ; j < N ; j++) {
				str += n_arr[i][j];
			}
			print[i][idx] = str;
		}
		
		return n_arr;
	}
}
