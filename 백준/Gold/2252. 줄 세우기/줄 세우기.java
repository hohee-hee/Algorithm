import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//1. 입력 및 초기화
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점 개수
		int M = Integer.parseInt(st.nextToken()); //간선 개수
		
		//인접 리스트 저장 배열
		ArrayList<Integer>[] G = new ArrayList[N+1];
		//초기화
		for(int i = 0 ; i < N+1 ; i++) G[i] = new ArrayList<>();
		
		//차수 저장
		int[] inde = new int[N+1];
		
		//간선 정보 입력받기
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			G[front].add(back);
			inde[back]++;
		}
		
		//2. 위상정렬
		//큐 선언
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		//진입차수가 0인 노드 큐에 넣기
		for(int i = 1 ; i <= N ; i++) {
			if(inde[i] == 0) q.offerLast(i);
		}
		
		//위상정렬
		while(!q.isEmpty()) {
			int node = q.pollFirst();
			for(int i = 0 ; i < G[node].size(); i++) {
				int next = G[node].get(i);
				inde[next]--;
				if(inde[next] == 0) q.offerLast(next);
			}
			sb.append(node + " ");
		}
		
		//3. 출력
		System.out.println(sb);
	}
}
