import java.util.*;
import java.io.*;


public class Main {
	
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//1. 입력 받기
		int V = Integer.parseInt(st.nextToken()); //정점 개수
		int E = Integer.parseInt(st.nextToken()); //간선 개수
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int[][] edges = new int[E][3];
		
		for(int i = 0 ; i <  E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			pq.offer(new int[] {A,B,W});
		}
		
		//2. makeset
		p = new int[V+1];
		for(int i = 1 ; i <= V ; i++) p[i] = i;
        
		//3. 순회
		int answer = 0;
		int pick = 0;
		for(int i = 0 ; i < E ; i++) {
			int x = pq.peek()[0];
			int y = pq.peek()[1];
			int w = pq.poll()[2];
			
			if(findset(x) != findset(y)) {
				union(x,y);
				answer += w;
				pick++;				
			}
		}
		
		System.out.println(answer);
	}

	private static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

	private static int findset(int x) {
		if(x == p[x]) return x;
		return findset(p[x]);
	}
	
	
}
