import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테케 개수 입력받기
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			//가로, 세로, 배추 위치 개수 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			//배추밭 배열 - 0으로 초기화
			int[][] baechoo = new int[M][N];
			
			//배추 위치 입력 받아서 배추밭 배열의 해당 값을 1로 바꾸기
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				
				baechoo[m][n] = 1;
			}
			
			//BFS
			int worm = 0; //배추흰지렁이 수
			//델타배열
			int[] dx = { -1, 0, 1, 0 };
			int[] dy = { 0, -1, 0, 1 };
			//순회
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					//만약 배추가 안심어져 있거나 이미 방문한 노드면 다음 시작점으로 넘어가기
					if(baechoo[j][i] != 1) { continue; }
					worm++; //흰지렁이 수 추가
					//시작점을 큐에 넣기
					Queue<Point> bfs = new LinkedList<>();
					Point p = new Point(j, i);
					bfs.offer(p);
					
					while(!bfs.isEmpty()) {
						p = bfs.poll();
						int cx = p.x;
						int cy = p.y;
						
						for(int k = 0 ; k < 4 ; k ++) {
							int nx = cx+dx[k];
							int ny = cy+dy[k];
							
							//범위를 넘어가면 다음으로 넘어가기
							if(nx < 0 || ny < 0 || nx >= M || ny >= N) { continue; }
							//만약 배추가 안심어져 있거나 이미 방문한 노드면 다음 시작점으로 넘어가기
							if(baechoo[nx][ny] != 1) { continue; }
							
							p = new Point(nx, ny);
							bfs.offer(p);
							baechoo[nx][ny] = 0;
						}
					}
					
				}
			}
			System.out.println(worm);
		}
	}
}
