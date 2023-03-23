import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		//입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //테케 개수만큼 반복
        for(int tc = 0 ; tc < T ; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	char[][] building = new char[M][N];
        	int[][] time = new int[M][N];
        	
        	//큐 만들기
        	Deque<int[]> q_loc = new ArrayDeque<>(); //상근이 이동
        	Deque<int[]> q_fire = new ArrayDeque<>(); //불의 이동
        	
        	//빌딩 정보를 입력 받으면서 각 큐에  위치정보 enqueue
        	for(int i = 0 ; i < M ; i++) {
        		String str = br.readLine();
        		for(int j = 0 ; j < N ; j++) {
        			building[i][j] = str.charAt(j);
        			if(building[i][j] == '*') {
        				int[] pt = {i, j, 1};
        				q_fire.offerLast(pt);
        			}
        			else if (building[i][j] == '@') {
        				int[] pt = {i,j};
        				q_loc.offerLast(pt);
        				time[i][j] = 1;
        			}
        		}
        	}
        	
        	//델타배열
        	int[] dr = {0,-1,0,1};
        	int[] dc = {-1,0,1,0};        	
        	
        	//BFS : 상근이 이동시키기 
        	while(!q_loc.isEmpty()) {
        		int cr = q_loc.peekFirst()[0];
        		int cc = q_loc.pollFirst()[1];
        		for(int dir = 0 ; dir < 4 ; dir++) {
        			int nr = cr + dr[dir];
        			int nc = cc + dc[dir];
        			
        			//바운드 처리
        			if(nr < 0 || nc < 0 || nr >= M || nc >= N) {
        				continue;
        			}
        			
        			//불이거나 벽일때
        			if(building[nr][nc] == '*' || building[nr][nc] == '#' ) continue;
        			
        			//방문한 적이 있을 때
        			if(time[nr][nc] != 0) continue;
        				
        			//시간 계산
        			time[nr][nc] = time[cr][cc] + 1;
        			
        			//enqueue
        			int[] pt = {nr, nc};
        			q_loc.offerLast(pt);
        		}
        		
        	}
        	
        	//BFS : 불 이동시키기
        	while(!q_fire.isEmpty()) {
        		int cr = q_fire.peekFirst()[0];
        		int cc = q_fire.peekFirst()[1];
        		int curTime = q_fire.pollFirst()[2];
        		for(int dir = 0 ; dir < 4 ; dir++) {
        			int nr = cr + dr[dir];
        			int nc = cc + dc[dir];
        			
        			//바운드 처리
        			if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
        			
        			//불이거나 벽일때
        			if(building[nr][nc] == '*' || building[nr][nc] == '#' ) continue;
        				
        			//시간 계산
        			if(time[nr][nc] > curTime) time[nr][nc] = 0;
        			
        			//불로 바꾸기
        			building[nr][nc] = '*';
        			//enqueue
        			int[] pt = {nr, nc, curTime+1};
        			q_fire.offerLast(pt);
        		}
        	}
        	
        	//확인하기
        	int min = Integer.MAX_VALUE;
        	for(int i = 0 ; i < N ; i++) {
        		if(time[0][i] > 0) {
        			min = Math.min(time[0][i], min);
        		}
        		if(time[M-1][i] > 0) {
        			min = Math.min(time[M-1][i], min);
        		}
        	}
        	for(int i = 0 ; i < M ; i++) {
        		if(time[i][0] > 0) {
        			min = Math.min(time[i][0], min);
        		}
        		if(time[i][N-1] > 0) {
        			min = Math.min(time[i][N-1], min);
        		}
        	}
        	
        	if(min == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        	else System.out.println(min);
        		
        	
        }        	
	}
}
