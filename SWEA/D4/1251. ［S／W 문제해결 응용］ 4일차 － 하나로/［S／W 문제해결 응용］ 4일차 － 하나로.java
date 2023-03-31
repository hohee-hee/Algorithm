import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge implements Comparable<Edge>{
		
		int st, ed;
		long w;				

		public Edge(int st, int ed, long w) {
			super();
			this.st = st;
			this.ed = ed;
			this.w = w;
		}


		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			
			//1. 입력 받기
			int N = sc.nextInt();
			int[][] loc = new int[N][2];
			for(int i = 0 ; i < N ; i++) {
				loc[i][0] = sc.nextInt();				
			}
			for(int i = 0 ; i < N ; i++) {
				loc[i][1] = sc.nextInt();
			}
			double E = sc.nextDouble();
			
			//2. 인접리스트 만들기
			List<Edge>[] adjList = new ArrayList[N];
			
			for(int i = 0 ; i < N ; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i = 0 ; i < N-1 ; i++) {
				for (int j = i+1 ; j < N ; j++) {
					long x = loc[i][0] - loc[j][0];
					long y = loc[i][1] - loc[j][1];
					long W = x * x + y * y;
					
					adjList[i].add(new Edge(i,j,W));
					adjList[j].add(new Edge(j,i,W));
				}
			}
			
			//방문처리
			boolean[] visited = new boolean[N];
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			visited[0] = true;
			
			pq.addAll(adjList[0]);
			
			int pick = 1;
			long ans = 0;
			while(pick != N) {
				Edge e = pq.poll();
				if(visited[e.ed]) continue;
				
				ans += e.w;
				pq.addAll(adjList[e.ed]);
				visited[e.ed] = true;
				pick++;
			}
			
			
			System.out.println("#" + tc + " " + Math.round(ans * E));
		}
	}
}
