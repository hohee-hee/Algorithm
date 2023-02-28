import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] paper = new boolean[102][102]; //전체 종이 영역 w/ 앞뒤 양옆 패딩
		int cnt = 0; //색종이가 붙여진 영역의 둘레길이
		
		//색종이 붙이기
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			//색종이의 각 칸을 순회하며  true로 바꾸기
			for(int r = row; r < row+10 ; r++ ) {
				for(int c = col ; c < col+10 ; c++) {
					paper[r][c] = true;					
				}
			}
		}
		
		//둘레 계산 하기
		//델타 배열
		int[] dr = { 0, -1, 0, 1};
		int[] dc = { -1, 0, 1, 0};
		for(int r = 1; r < 101 ; r++ ) {
			for(int c = 1 ; c < 101 ; c++) {
					if(paper[r][c]) {
					for(int k = 0 ; k < 4 ; k++) {
						int nr = dr[k] + r;
						int nc = dc[k] + c;
						if(!paper[nr][nc]) cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
