import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());  
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	//입력값 넣어주기
    	int[][] pic = new int[N][M];    	
    	for(int i = 0 ; i < N ; i++) {
    		StringTokenizer board = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j < M ; j++) {
    			pic[i][j] = Integer.parseInt(board.nextToken());
    		}
    	}
    	
    	//방문 여부를 확인할 변수
    	boolean[][] visit = new boolean[N][M];
    	int max = 0; //가장 넓은 그림의 넓이를 저장할 변수
   
    	

    	int[] dx = { 0 , 0, -1, 1};
    	int[] dy = { -1, 1, 0, 0 };

    	int cnt = 0; //그림의 개수
    	for(int i = 0 ; i < N ; i++) {
    		for(int j = 0 ; j < M ; j++) {
    			if(visit[i][j] == true || pic[i][j] == 0) { ;continue; }
    			int tmp = 0;
    			cnt++;
    	        Queue<Integer> q_n = new LinkedList<>();
    	        Queue<Integer> q_m = new LinkedList<>();
    			q_n.offer(i);
    			q_m.offer(j);                
    			visit[i][j] = true;
    			while(!(q_m.isEmpty())) {
    	    		tmp++;
    	    		int cx = q_n.poll();
    	    		int cy = q_m.poll();
    	    		for(int k = 0 ; k < 4 ; k++) {    	    			
    	    			int nx = cx + dx[k];
    	    			int ny = cy + dy[k];
    	    			if(nx < 0 || ny < 0 || nx >= N || ny >= M) { continue; } //범위 벗어나면 pass
    	    			if(visit[nx][ny] || pic[nx][ny] == 0) { continue; } //방문했거나 0이면
    	    			q_n.offer(nx);
    	    			q_m.offer(ny);    			
    	    			visit[nx][ny] = true;
    	    		}
    	    	}    			
    			if(max<tmp)
    				max = tmp;    			
    		}
    	}
    	
    	System.out.println(cnt);
    	System.out.println(max);    	
    }   
}
