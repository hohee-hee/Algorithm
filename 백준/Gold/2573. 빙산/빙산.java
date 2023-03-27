import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		//1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //- 빙하 정보 입력 받기
        int[][] pole = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		pole[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        //2. 델타 배열
        int[] dr = {0,-1,0,1};
        int[] dc = {-1,0,1,0};
        
        //3. 덩어리가 2개 이상 생길때까지 다음의 과정 반복
        // - 빙하 덩어리 개수 계산
        // - 빙하 녹이기
        int cnt = 0; //덩어리 개수
        int yr = 0; //시간
        int tmp = 0;
        while(cnt < 2) {
        	cnt = 0;
        	yr++;
        	//1. 덩어리 개수 계산
        	// - 현재 상태의 빙하 정보 복사
        	int[][] copy = new int[N][M];
            for(int i = 0 ; i < N ; i++) {
            	for(int j = 0 ; j < M ; j++) {
            		copy[i][j] = pole[i][j];
            	}
            }
            // - BFS
            //큐 선언 및 초기화
            ArrayDeque<int[]> q = new ArrayDeque<>();
            //시작점 찾기
            for(int r = 0 ; r < N ; r++) {
            	for(int c = 0 ; c < M ; c++) {
            		//빙하가 아니면 넘어가기
            		if(copy[r][c] == 0) continue;
            		//덩어리 추가하기
            		cnt++;
            		//시작점 저장하기
            		int[] pt = {r,c};
            		q.offerLast(pt);
            		//BFS
            		while(!q.isEmpty()) {
            			int cr = q.peekFirst()[0];
            			int cc = q.pollFirst()[1];
            			for(int dir = 0 ; dir < 4 ; dir++) {
            				int nr = cr + dr[dir];
            				int nc = cc + dc[dir];
            				
            				//out of index
            				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            				
            				//바다거나 이미 방문했을 때
            				if(copy[nr][nc] == 0) continue;
            				
            				//방문 여부 기록
            				copy[nr][nc] = 0;
            				
            				//큐에 넣기
            				int[] npt = {nr, nc};
            				q.offerLast(npt);    
            			}
            		}            		
            	}
            }
            
            if(cnt > 1) break;
            
            //2. 빙하 녹이기            
            //얼마나 녹을지 저장
            int[][] melt = new int[N][M];
            for(int r = 0 ; r < N ; r++) {
            	for(int c = 0 ; c < M ; c++) {
            		//바다면 pass
            		if(pole[r][c] == 0) continue; 
            		
            		//4방탐색으로 주변 바다 개수 확인하기
        			for(int dir = 0 ; dir < 4 ; dir++) {
        				int nr = r + dr[dir];
        				int nc = c + dc[dir];
        				
        				//out of index
        				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
        				
        				//바다가 아닐 경우
        				if(pole[nr][nc] != 0) continue;
        				
        				//바다면 개수 더하기
        				melt[r][c]++;
        			}
        			
            	}
            }
            //pole 갱신하기 
            for(int r = 0 ; r < N ; r++) {
            	for(int c = 0 ; c < M ; c++) {
            		pole[r][c] -= melt[r][c];
            		if(pole[r][c] < 0) pole[r][c] = 0;
            	}
            }
            
            //3. 만약 빙하가 전부 다 녹았다면 중단
            boolean isMelt = true;
            for(int r = 0 ; r < N ; r++) {
            	for(int c = 0 ; c < M ; c++) {
            		if(pole[r][c] != 0) isMelt = false;
            	}
            }
            if(isMelt) {
            	yr = 1;
            	break;
            }
            
//            System.out.println("year : " + yr);
//            for(int i = 0 ; i < N ; i++) 
//            	System.out.println(Arrays.toString(pole[i]));
//            System.out.println();
        }
        
        System.out.println(yr-1);
	}
}
