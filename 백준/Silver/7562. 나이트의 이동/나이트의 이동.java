import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase = 0 ; testcase < T ; testcase++) {
			// 변수 입력 받기
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cr = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int tr = Integer.parseInt(st.nextToken());
			int tc = Integer.parseInt(st.nextToken());
			int cnt = 0;
			boolean[][] visit = new boolean[N][N];
			
			if(cr == tr && cc == tc){
				System.out.println(0);
				continue;
			}
			
			Deque<int[]> q = new ArrayDeque<>();
			int[] dr = { -1,-2,-2,-1,1,2,2,1 };
			int[] dc = { -2,-1,1,2,2,1,-1,-2 };
			
			int[] pt = {cr,cc, 0};
			q.offerLast(pt);
			
			outer : while(!q.isEmpty()) {
				pt = q.pollFirst();
				cr = pt[0];
				cc = pt[1];
				cnt = pt[2];
				for(int i = 0 ; i < 8 ; i++) {
					int[] np = {cr+dr[i], cc+dc[i], cnt + 1};
					if(np[0] == tr && np[1] == tc) {
						System.out.println(np[2]);
						break outer;
					}
					if(np[0] < 0 || np[1] < 0 || np[0] >= N || np[1] >= N || visit[np[0]][np[1]]) continue;
					q.offerLast(np);
					visit[np[0]][np[1]] = true;
					
				}
			}
			
		}
	}
}
