import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main{		
	public static void main(String args[]) throws Exception	{
		/* 1. 입력 받기  */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //세로
		int M = Integer.parseInt(st.nextToken()); //가로
		int[][] maze = new int[N][M]; //전체 미로 지도
		int[][] dist = new int[N][M]; //출발 지점부터의 거리를 저장할 배열
		//입력받기
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				maze[i][j] = str.charAt(j) - 48;
			}
		}
		
		/* 2. BFS */
		//델타배열
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		
		Queue<Point> q = new LinkedList<>(); //방문한 노드를 기록할 q
		//초기값 저장
		Point p = new Point(0,0);
		q.offer(p);
		dist[0][0] = 1;
				
		while(!q.isEmpty()) {
			Point cur = q.poll();			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) { continue; }
				if(maze[nx][ny] == 0 || dist[nx][ny] != 0) { continue; }
				dist[nx][ny] = dist[cur.x][cur.y] +1;
				q.offer(new Point(nx,ny));
			}
		}
		
		System.out.println(dist[N-1][M-1]);
	}
}