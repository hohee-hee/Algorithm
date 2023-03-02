import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//주사위 정보 넣기
		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 6 ; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max_sum = 0;
		//주사위 쌓기
		for(int i = 0 ; i < 6 ; i++) {
			//위로 올라갈 1번 주사위의 눈 정하기
			int up = dice[0][i];
			int down = dice[0][pair(i)];
			//최댓값 찾기
			int i_sum = findMax(up, down);
			
			//1번 주사위의 눈에 따라 위 주사위 올리기
			for(int j = 1; j < N ; j++) {
				//아래 주사위의 윗쪽 눈에 맞추어 주사위 올리기
				for(int k = 0 ; k < 6 ; k++) {
					if(dice[j][k] == up) {
						down = dice[j][k];
						up = dice[j][pair(k)];
                        break;
					}
				}
				//옆면 중 최댓값 찾기				
				i_sum += findMax(up, down);
			}
			
			if(max_sum < i_sum) { max_sum = i_sum; }
		}
		
		System.out.println(max_sum);
	}
	
	private static int pair(int n) {
		switch(n) {
		case 0:
			return 5;
		case 1:
			return 3;
		case 2:
			return 4;
		case 3:
			return 1;
		case 4:
			return 2;
		case 5:
			return 0;
		}
		
		return -1;
	}

	//옆면 중 최댓값 찾기
	private static int findMax(int u, int d) {
		if((u == 6 && d == 5) || (u ==5 && d == 6))
			return 4;
		if(u == 6 || d == 6)
			return 5;
		return 6;
	}
}
