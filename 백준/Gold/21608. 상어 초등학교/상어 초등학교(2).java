import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] classroom = new int[N+1][N+1]; // 교실 배치
        int[] stuList = new int[N*N]; // 학생 순서
        HashSet<Integer>[] stuLike = new HashSet[(N*N) + 1]; // 좋아하는 학생 정보 저장
        
        for(int i = 0 ; i < N*N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stuList[i] = Integer.parseInt(st.nextToken());
            stuLike[stuList[i]] = new HashSet<Integer>();
            for(int j = 0 ; j < 4 ; j++) {
            	stuLike[stuList[i]].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 2. 자리 배치하기
		// 1) 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
		// 2) 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
		// 3) 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        int[] dr = {0,-1,0,1};
        int[] dc = {-1,0,1,0};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[0] == o2[0]) {
        			if(o1[1] == o2[1]) {
        				if(o1[2] == o2[2]) return o1[3] - o2[3];
        				return o1[2] - o2[2];
        			}
        			return o2[1] - o1[1];
        		}
        		return o2[0] - o1[0];
        	}
		});
        
        for(int i = 0 ; i < N * N ; i++) {
        	pq.clear();
        	
        	int stuNum = stuList[i];
        	
        	 for(int cr = 1 ; cr <= N ; cr++){
               for(int cc = 1 ; cc <= N ; cc++){         
            	   if(classroom[cr][cc] != 0) continue; // 빈칸 아님
            	   
            	   int like = 0;
            	   int empty = 0;
            	   
            	   for(int d = 0 ; d < 4 ; d++) {
               		int nr = dr[d] + cr;
               		int nc = dc[d] + cc;
               		
               		// out of idx
               		if(nr < 1 || nc < 1 || nr > N || nc > N) continue;
               		
               		// 빈칸일때
            		if(classroom[nr][nc] == 0) empty++;
            		
            		// 좋아하는 학생 일때
            		if(stuLike[stuNum].contains(classroom[nr][nc])) like++;        	
               		
            	   }               	
            	   pq.add(new int[] {like, empty, cr, cc});
               }
        	 }
        	 classroom[pq.peek()[2]][pq.peek()[3]] = stuNum;
        }
        
        // 만족도 조사
        int answer = 0;
        for(int cr = 1 ; cr <= N ; cr++){
            for(int cc = 1 ; cc <= N ; cc++){
            	int stuNum = classroom[cr][cc];
            	int likeStu = 0;
            	
            	  for(int d = 0 ; d < 4 ; d++) {
                 		int nr = dr[d] + cr;
                 		int nc = dc[d] + cc;
                 		
                 		// out of idx
                 		if(nr < 1 || nc < 1 || nr > N || nc > N) continue;
                 		
                 		// 좋아하는 학생 일때
                 		if(stuLike[stuNum].contains(classroom[nr][nc])) likeStu++;        	
                 		
              	 }              
            	  
            	if(likeStu == 1) answer += 1;
            	else if(likeStu == 2) answer += 10;
            	else if(likeStu == 3) answer += 100;
            	else if(likeStu == 4) answer += 1000;
            }
        }
        
        System.out.println(answer);
    }
}