import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cur = Integer.parseInt(st.nextToken());
		int tar = Integer.parseInt(st.nextToken());
		
		int MAX = 100001;
		
		int sec = 0;
		if(cur==tar) sec = 0; //수빈이와 동생의 위치가 일치하면 움직일 필요가 없다
		else if(cur > tar) sec = cur - tar; //동생이 수빈이보다 좌표상 앞에 있으면 한칸씩 돌아가는 것보다 최적의 해는 없다
		else { // BFS 돌리기
			
			boolean[] visit = new boolean[MAX];
			Deque<int[]> q = new ArrayDeque<>();
			int[] start = {cur, 0};
			q.offerLast(start);
			
			outer : while(!q.isEmpty()) {
				int[] loc = q.pollFirst();
				for(int i = 0 ; i < 3 ; i++) {
					int nloc = move(i,loc[0]);
					if(nloc == tar) {
						sec = loc[1] + 1;
						break outer;
					}
					if(nloc >= 0 && nloc < MAX && !visit[nloc]) {
						int[] pt = {nloc, loc[1]+1};
						q.offerLast(pt);						
						visit[nloc] = true;
					}
				}
			}
		}		
		
		System.out.println(sec);
	}

	private static int move(int i, int loc) {
		switch(i) {
			case 0 :
				return loc+1;
			case 1 :
				return loc-1;
			case 2 :
				return loc*2;
		}
		return -1;
	}
}
