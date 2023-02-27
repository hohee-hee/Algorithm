import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] paper = new boolean[101][101]; //전체 종이 영역
		int colored = 0; //색종이가 붙여진 영역의 개수
		
		//색종이 붙이기
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			//색종이의 각 칸을 순회하며 false라면 (== 아직 색종이가 붙여지지 않았다면) true로 바꾸고 개수 세기
			for(int r = row; r < row+10 ; r++ ) {
				for(int c = col ; c < col+10 ; c++) {
					if(!paper[r][c]) {
						paper[r][c] = true;
						colored++;
					}
				}
			}
		}
		
		System.out.println(colored);
	}
}
