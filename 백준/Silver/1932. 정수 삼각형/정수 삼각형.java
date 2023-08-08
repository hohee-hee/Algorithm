import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 입력 받기 
		int N = Integer.parseInt(br.readLine());

		int[][] tri = new int[N+1][N+1]; // 삼각형 정보 저장
		int[][] DP = new int[N+1][N+1]; // DP 배열
		
		for(int r = 1 ; r <= N ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 1 ; c <= r ; c++) {
				tri[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2. DP		
		for(int r = 1 ; r <= N ; r++) {
			for(int c = 1 ; c <= r ; c++) {
				DP[r][c] = Math.max(DP[r-1][c-1] + tri[r][c], DP[r-1][c] + tri[r][c]);
			}
		}
		
		
		// 3. 최댓값 찾기
		int answer = 0;
		for(int c = 1 ; c <= N ; c++) {
			answer = Math.max(answer, DP[N][c]);
		}
		
		// 4. 출력
		System.out.println(answer);
	}
		
}
