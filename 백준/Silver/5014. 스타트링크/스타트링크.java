import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int[] dir = new int[2];
		dir[0] = Integer.parseInt(st.nextToken());
		dir[1] = Integer.parseInt(st.nextToken()) * (-1);
		
		// 2. 찾기
		
		boolean[] isVisited = new boolean[F+1];
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offerLast(new int[] {S,0});
		isVisited[S] = true;
		int answer = -1;
		outer : while(!queue.isEmpty()) {
			int floor = queue.peekFirst()[0];
			int cnt = queue.pollFirst()[1];
			
			
			if(floor == G) {
				answer = cnt;
				break outer;
			}
			
			for(int d = 0 ; d < 2 ; d++) {
				int nfloor = floor + dir[d];
				
				if(nfloor > F || nfloor < 1) continue;			
				if(isVisited[nfloor]) continue;			
				isVisited[nfloor] = true;
				queue.offerLast(new int[] {nfloor, cnt+1});
			}
		}
		
		if(answer == -1) System.out.println("use the stairs");
		else System.out.println(answer);
		
	}
}
