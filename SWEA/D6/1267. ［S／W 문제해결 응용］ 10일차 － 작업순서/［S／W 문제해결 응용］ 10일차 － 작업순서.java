import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc <= 10 ; tc++) {
			//0. 변수 선언
			sb.append("#" + tc); //출력 저장
			int V = sc.nextInt(); //노드 개수
			int E = sc.nextInt(); //간선 개수
			ArrayList<Integer>[] G = new ArrayList[V+1]; //인접 리스트				
			int[] indegree = new int[V+1]; //진입 차수 저장
			
			//G 초기화
			for(int i = 0 ; i < V+1 ; i++) G[i] = new ArrayList<Integer>();
			
			//1. 간선 정보 입력 받기
			for(int i = 0 ; i < E ; i++) {
				int st = sc.nextInt();
				int en = sc.nextInt();
				G[st].add(en);
				indegree[en]++;
			}
			
			//2. 위상정렬
			//큐
			ArrayDeque<Integer> q = new ArrayDeque<>();
			//차수가 0인 노드 enqueue
			for(int i = 1 ; i < V ; i++) {
				if(indegree[i] == 0) q.offerLast(i);
			}
			
			//위상정렬 돌기
			while(!q.isEmpty()) {
				int node = q.pollFirst();
				for(int i = 0 ; i < G[node].size() ; i++) {
					int next = G[node].get(i);
					indegree[next]--;
					if(indegree[next] == 0) q.offerLast(next);
				}
				//출력을 위한 저장
				sb.append(" " + node);
			} 	
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
