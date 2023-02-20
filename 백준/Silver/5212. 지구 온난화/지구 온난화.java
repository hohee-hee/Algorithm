import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
				
		char[][] map = new char[R][C];
		char[][] future = new char[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = tmp.charAt(j);
				future[i][j] = tmp.charAt(j);
			}
		}
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				int cr = i;
				int cc = j;

				if(map[cr][cc] == '.') { continue; }

				int cnt = 0;
				for(int k = 0 ; k < 4 ; k++) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) { cnt++; continue;}
					
					if(map[nr][nc] == '.') { cnt++; }
				}
				
				if(cnt >= 3) { future[cr][cc] = '.'; }
				
			}
		}
		
		int minR = R;
		int minC = C;
		int maxR = 0;
		int maxC = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(future[i][j] == 'X') {
					if(minR > i) minR = i;
					if(minC > j) minC = j;
					if(maxR < i) maxR = i;
					if(maxC < j) maxC = j;
				}
			}
		}
		
		for(int i = minR ; i <= maxR ; i++) {
			for(int j = minC ; j <= maxC ; j++) {
				sb.append(future[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
