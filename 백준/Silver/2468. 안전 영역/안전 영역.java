import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        
        //위치정보 입력 받기
        HashSet<Integer> hs = new HashSet<>(); //높이를 저장할 해시셋
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                hs.add(map[i][j]); //높이 정보 넣기
            }
        }
        hs.add(0); //아무것도 잠기지 않을때
        
        //정렬
        List<Integer> height = new LinkedList<>(hs);
        Collections.sort(height);
        
        //delta
        int[] dr = {0,-1,0,1};
        int[] dc = {-1,0,1,0};
        
        int max = 0; //안전영역의 최대 개수
        
        //BFS
        boolean[][] visit; //방문 여부 체크
        for(int i = 0 ; i < height.size() ; i++){
            int rain = height.get(i); //현재 강수량
            int safe = 0; //안전영역의 수
            visit = new boolean[N][N]; //초기화
            //시작점 찾기
            for(int r = 0 ; r < N ; r++){
                for(int c = 0 ; c < N ; c++){
                    //물에 잠겼거나 방문했을 때
                    if(map[r][c] <= rain || visit[r][c]) continue;
                    
                    Deque<int[]> q = new ArrayDeque<>();
                    int[] pt = {r, c};
                    q.offerLast(pt);
                    //안전영역 +1
                    safe++;
                    //BFS 돌리기
                    while(!q.isEmpty()){
                        int cr = q.peekFirst()[0];
                        int cc = q.pollFirst()[1];
                        //델타탐색
                        for(int j = 0 ; j < 4 ; j++){
                            int nr = cr + dr[j];
                            int nc = cc + dc[j];
                            // out of idx
                            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                            //물에 잠겼거나 방문했을 때
                            if(map[nr][nc] <= rain || visit[nr][nc]) continue;
                            //방문처리
                            visit[nr][nc] = true;
                            //큐에 넣기
                            pt = new int[]{nr, nc};
                            q.offerLast(pt);
                        }
                    }
                    //안전영역 최댓값 저장
                    max = Math.max(max, safe);
                }
            }
        }
        System.out.println(max);
    }
}
