import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {	
	
	public static void main(String[] args) throws  IOException {

		Queue<Point> q= new LinkedList<>();
		Point p = new Point();
		//입력 받기
		//이 때 안익은 토마토가 들어있는 위치의  거리는 -1
		//익은 토마토가 들어있다면 시작점이므로 q에도 넣어주기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] tomato = new int[M][N]; //창고
		int[][] dist = new int[M][N]; //거리
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				tomato[j][i] = Integer.parseInt(st.nextToken());
				if(tomato[j][i] == 1) {					
					p = new Point(j,i);
					q.offer(p);
				}
				if(tomato[j][i] == 0) {
					dist[j][i] = -1;
				}
			}
		}
		
		//BFS
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		while(!q.isEmpty()) {
			p = q.poll();
			int cx = p.x;
			int cy = p.y;
			for(int k = 0 ; k < 4 ; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) { continue; }
				if(dist[nx][ny] >= 0) { continue; }
				
				dist[nx][ny] = dist[cx][cy] + 1;
				p = new Point (nx,ny);
				q.offer(p);						
			}
		}	
		
		//최대 거리 찾기
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(dist[j][i] == -1) {
					System.out.println(-1);
					return;
				}				
				if(dist[j][i] > max) {
					max = dist[j][i];
				}
			}
		}
		
		System.out.println(max);
	}
}
