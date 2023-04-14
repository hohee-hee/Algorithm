import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args)  throws IOException {
		
		//1. 입력 받기		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] adj = new boolean[N+1][N+1];
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0 ;  i < M ; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a][b] = true;
			adj[b][a] = true;
			
		}
		
		//2. 1번 컴퓨터부터 방문하면서 찾기.
		//BFS
		boolean[] visited = new boolean[N+1];
		visited[0] = true;
		visited[1] = true;
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.offerLast(1);
		while(!q.isEmpty()) {
			int curr = q.pollFirst();
			for(int i = 1 ; i <= N ; i++) {
				//연결노드가 아니면 pass
				if(!adj[curr][i]) continue;
				
				//방문했으면 pass
				if(visited[i]) continue;
				
				//방문체크
				visited[i] = true;
				
				//간선 제거
				adj[curr][i] = false;
				adj[i][curr] = false;
				
				//enqueue
				q.offerLast(i);
			}
		}

		int answer = 0;
		for(int i = 2 ; i <= N ; i++) {
			if(visited[i]) answer++;
		}
		System.out.println(answer);
		
	}
}
