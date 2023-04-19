import java.util.*;
import java.io.*;


public class Main {
	
	static int[] indegree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//1. 입력 받기
		int N = Integer.parseInt(st.nextToken()); //가수 = 정점 개수
		int M = Integer.parseInt(st.nextToken()); //보조PD
	
		indegree = new int[N+1]; //진입 차수
		ArrayList<Integer>[] adj = new ArrayList[N+1]; //인접리스트
		//인접 리스트 초기화
		for(int i = 0 ; i < N+1 ; i++) adj[i] = new ArrayList<Integer>();
		
		//입력 받기
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int E = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());			
			for(int j = 1 ; j < E ; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				indegree[to]++;
				from = to;
			}
		}
		
		//위상정렬
		topologist_sort(adj);
			
		for(int inde : indegree) {
			if(inde != 0) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(sb);
	}

	private static void topologist_sort(ArrayList<Integer>[] adj) {
		//큐 만들기
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		
		//차수가 0인 노드 enque
		for(int i = 1 ; i < indegree.length ; i++) {
			if(indegree[i] == 0) q.offerLast(i);
		}
		
		//위상정렬
		while(!q.isEmpty()) {
			int node = q.pollFirst();
			for(int i = 0 ; i < adj[node].size() ; i++) {
				int next = adj[node].get(i);
				indegree[next]--;
				
				if(indegree[next] == 0) q.offerLast(next);
			}
			
			sb.append(node + "\n");
		}
	}
	
	
}
