import java.io.*;
import java.util.*;

public class Main {
	static int N, r, c, answer;
	static int[] deep;
	
	
	public static void main(String[] args) throws IOException {
		//1. 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		deep = new int[N+1];
		
		//2. 재귀호출
		answer = 0;
		recur(N, r, c);
        
		for(int i = N ; i > 1 ; i--) {
			int part = deep[i];
			switch(part){
				case 0:
					answer += 0;
					break;
				case 1:
					answer += (int)Math.pow(2, (i-1) *2);
					break;
				case 2:
					answer += ((int)Math.pow(2, (i-1) * 2)*2);
					break;
				case 3:
					answer += ((int)Math.pow(2, (i-1) * 2)*3);
					break;
			}
		}
		
		System.out.println(answer);
	}

	private static void recur(int depth, int row, int col) {
		//기저 조건 
		if(depth == 1) {
			if(row == 0 && col == 1) answer += 1;
			if(row == 1 && col == 0) answer += 2;
			if(row == 1 && col == 1) answer += 3;
			return;
		}
		
		//좌상
		if(row < (int)Math.pow(2, depth-1) && col < (int)Math.pow(2, depth-1) ) {
			deep[depth] = 0;
			recur(depth-1, row, col);
		}
		
		//우상
		else if(row < (int)Math.pow(2, depth-1) && col < (int)Math.pow(2, depth) ) {
			deep[depth] = 1;
			recur(depth-1, row, col - (int)Math.pow(2, depth-1));
		}
		
		//좌하
		else if(row < (int)Math.pow(2, depth) && col < (int)Math.pow(2, depth-1) ) {
			deep[depth] = 2;
			recur(depth-1, row - (int)Math.pow(2, depth-1), col);
		}
		
		//우하
		else if(row < (int)Math.pow(2, depth) && col < (int)Math.pow(2, depth) ) {
			deep[depth] = 3;
			recur(depth-1, row - (int)Math.pow(2, depth-1), col - (int)Math.pow(2, depth-1));
		}
		
		return;
		
	}
}
