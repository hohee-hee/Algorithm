import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//모눈종이 만들기
		boolean[][] field = new boolean[M][N];
		
		//직사각형 표시하기
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for(int r = x1 ; r < x2 ; r++) {
				for(int c = y1 ; c < y2 ; c++) {
					field[r][c] = true;
				}
			}
		}
		
		int section = 0; //영역의 개수
		int size = 0; //영역의 넓이
		List<Integer> list = new ArrayList<>(); //영역의 넓이를 저장할 배열

		//델타배열
		int[] dr = {0, -1, 0, 1};
		int[] dc = {-1, 0, 1, 0};
		
		//BFS
		for(int r = 0 ; r < M ; r++) {
			for(int c = 0 ; c < N ; c++) {
				//시작점 찾기
				size = 0;
				//방문한 적이 있거나 직사각형 영역에 있으면 넘어가기
				if(field[r][c]) {
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
					field[cr][cc] = true;
					for(int i = 0 ; i < 4 ; i++) {
						int nr = cr + dr[i];
						int nc = cc + dc[i];
						if(nr < 0 || nc < 0 || nr >= M || nc >= N || field[nr][nc]) continue;
						pt = new int[] {nr,nc};
						q.offerLast(pt);
						size++;
						field[nr][nc] = true;
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
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb);
		
	}
}
