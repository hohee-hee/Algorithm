import java.io.*;
import java.util.*;


public class Main {
	static int max, num;
	static ArrayList<int[]>[] tree;
	
	public static void main(String[] args) throws IOException {
		
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		max=num=0;
		tree = new ArrayList[N+1]; // 인접노드를 저장할 리스트
		
		for (int i = 0; i <= N; i++) {
		    tree[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < N-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 부모 노드 번호
			int c = Integer.parseInt(st.nextToken()); // 자식 노드 번호
			int w = Integer.parseInt(st.nextToken()); // 가중치 (자식 노드에 저장)
			tree[p].add(new int[] {c,w});
			tree[c].add(new int[] {p,w});
		}	
		
		// 2. 루트노드에서 가장 멀리있는 노드 찾기
		boolean[] isVisited = new boolean[N+1];
		isVisited[1] = true;
		DFS(1, isVisited, 0);
		
		max = 0;
		// 3. 2의 노드에서 가장 멀리있는 노드 찾기
		isVisited = new boolean[N+1];
		isVisited[num] = true;
		
		DFS(num, isVisited, max);
		
		System.out.println(max);
	}
	
	static void DFS(int node, boolean[] isVisited, int dist) {		
		
		// 스택에 인접노드 쌓기
		for(int i = 0 ; i < tree[node].size() ; i++) {
			int adj_node = tree[node].get(i)[0];
			int adj_weight = tree[node].get(i)[1];
			
			if(isVisited[adj_node]) continue;
			isVisited[adj_node] = true;
			DFS(adj_node, isVisited, dist+adj_weight);
		}
		
		if(dist > max) {
			max = dist;
			num = node;
		}
		return;
	}
	
}
