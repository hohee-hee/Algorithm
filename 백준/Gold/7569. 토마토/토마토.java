import java.io.*;
import java.util.*;

public class Main{
		
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] tomato = new int[H][R][C];
		int[][][] dist = new int[H][R][C];
		Deque<int[]> q = new ArrayDeque<>();
		boolean isRipen = true;
		//입력 받기
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < R ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < C ; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][k] == 1) {
						int[] ripe = {i, j, k};
						q.offerLast(ripe);
					}
					else if(tomato[i][j][k] == 0) {
						dist[i][j][k] = -1;
						isRipen = false;
					}
				}
			}
		}
		
		//만약 이미 모두 익어있다면 0 출력
		if(isRipen) {
			System.out.println(0);
			return;
		}
		
		//델타배열 선언
		int[][] delta = {{1, 0, 0}, {-1, 0, 0}, {0, 0, -1}, {0, 0, 1}, {0, -1, 0}, {0, 1, 0}};
		
		//BFS
		
		while(!q.isEmpty()) {
			int[] pt = q.pollFirst();
			int ch = pt[0];
			int cr = pt[1];
			int cc = pt[2];
			for(int i = 0 ; i < 6 ; i++) {
				int nh = ch + delta[i][0];
				int nr = cr + delta[i][1];
				int nc = cc + delta[i][2];

				if(nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= R || nc >= C || dist[nh][nr][nc] >= 0)
					continue;
				dist[nh][nr][nc] = dist[ch][cr][cc] + 1;
				tomato[nh][nr][nc] = 1;
				int[] ripe = {nh, nr, nc};
				q.offerLast(ripe);
			}
		}		
		
		
		//출력
		int max = -1;
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < R ; j++) {
				for(int k = 0 ; k < C ; k++) {
					if(dist[i][j][k] == 0) continue;
					if(dist[i][j][k] == -1) {
						System.out.println(-1);
						return;
					}
					if(dist[i][j][k] > max) {
						max = dist[i][j][k];
					}
				}
			}
		}
		System.out.println(max);
	}	
}
