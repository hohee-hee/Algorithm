import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //test case
		
		for(int i = 0 ; i < T ; i++) {
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] plane = new int[N+1][N+1]; //비행기 유무 저장
			for(int j = 0 ; j < M ; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				plane[a][b] = 1;
				plane[b][a] = 1;
			}
			
			//BFS
			Queue<Integer> q = new LinkedList<>();
			boolean[] visit = new boolean[N+1]; //국가 방문 여부 확인
			
			q.offer(1);
			visit[1] = true;
			
			
			while(!q.isEmpty()) {
				int front = q.poll();
				for(int j = 2 ; j <= N ; j++) {
					if(plane[front][j] == 1 && !visit[j]) {
						q.offer(j);
						visit[j] = true;
						cnt++;
					}						
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}
