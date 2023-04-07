import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] paper;
	
	static int[] cnt;
	
	public static void main(String[] args)  throws IOException {
		StringBuilder sb = new StringBuilder();
		
		//1. 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//종이
		paper = new int[N][N];
		for(int r = 0 ; r < N ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		//종이 개수 세는 배열
		cnt = new int[3];
		
		//2. 재귀
		recur(N,0,0);
		
		//3. 출력
		sb.append(cnt[2]+"\n");
		sb.append(cnt[0]+"\n");
		sb.append(cnt[1]+"\n");
		System.out.println(sb);
	}

	private static void recur(int depth, int row, int col) {
		
		//전체 탐색
		boolean isPaper = true;
		chk : for(int i = row ; i < row + depth ; i++) {
			for(int j = col ; j < col + depth ; j++) {
				if(paper[row][col] != paper[i][j]) {
					isPaper = false;
					break chk;
				}
			}
		}
		
		//같은 숫자로 이루어져 있으면 개수세기
		if(isPaper) {
			if(paper[row][col] == -1) cnt[2]++;
			else cnt[paper[row][col]]++;
			
			return;
		}
		
		//재귀조건
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				int r = row + depth/3*i;
				int c = col + depth/3*j;
				recur(depth/3, r, c);				
			}
		}
	}
}
