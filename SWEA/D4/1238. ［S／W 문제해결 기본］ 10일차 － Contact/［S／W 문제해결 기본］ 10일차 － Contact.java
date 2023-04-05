import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1 ; tc <= 10 ; tc++) {
			//1. 입력 받기
			int L = sc.nextInt(); //입력받을 길이
			int S = sc.nextInt(); //시작점
			//간선 정보 저장하기
			HashSet<Integer>[] edge = new HashSet[101];
			for(int i = 0 ; i < 101 ; i++) edge[i] = new HashSet<Integer>();
			
			for(int i = 0 ; i < L/2 ; i++) {
				int st = sc.nextInt();
				int en = sc.nextInt();
				edge[st].add(en);
			}
			
			//2. 시작점부터 탐색하기
			int[] dist = new int[101]; //거리 정보 저장
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offerLast(S);
			dist[S] = 1;
			
			
			//BFS
			while(!q.isEmpty()) {
				int node = q.pollFirst();
				
				//연결 노드 탐색하기
				//1. HashSet to ArrayList
				ArrayList<Integer> list = new ArrayList<>(edge[node]);
				if(list.size() == 0) continue;
				for(int i = 0 ; i < list.size() ; i++) {
					int next = list.get(i);
					
					//이미 방문한 노드면 넘어가기
					if(dist[next] != 0) continue;
					
					//1. 거리 저장하기
					dist[next] = dist[node] + 1;
					
					//2.enqueue
					q.offerLast(next);
				}
			}
			//3. 가장 멀리 있는 노드 찾기
			int lastman = 1;
			for(int i = 2 ; i < 101 ; i++) {
				if(dist[i] >= dist[lastman]) lastman = i;
			}
			
			//4. 출력
			System.out.println("#" + tc + " " + lastman);
			
		}
	}
}
