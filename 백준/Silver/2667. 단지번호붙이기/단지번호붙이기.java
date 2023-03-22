import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int section = 0; //단지의 개수
		int size = 0; //단지의 넓이
		List<Integer> list = new ArrayList<>(); //영역의 넓이를 저장할 배열

		//델타배열
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		
		//BFS
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				//시작점 찾기
				size = 0;
				//방문한 적이 있거나 직사각형 영역에 있으면 넘어가기
				if(map[r][c] != 1) {
					continue;
				}
				
				//BFS 돌리기
				section++;
				int[] pt = {r,c};
				ArrayDeque<int[]> q = new ArrayDeque<>();
				q.offerLast(pt);				
				while(!q.isEmpty()) {					
					int cr = q.peekFirst()[0];
					int cc = q.pollFirst()[1];
					map[cr][cc]++;
					for(int i = 0 ; i < 4 ; i++) {
						int nr = cr + dr[i];
						int nc = cc + dc[i];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != 1) continue;
						pt = new int[] {nr,nc};
						q.offerLast(pt);
						size++;
						map[nr][nc]++;
					}
				}
				list.add(size+1);
			}
		}
		
		//정렬
		Collections.sort(list);
		//출력하기
		StringBuilder sb = new StringBuilder();
		sb.append(section + "\n");
		for(int i = 0 ; i < list.size() ; i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb);
		
	}
}
