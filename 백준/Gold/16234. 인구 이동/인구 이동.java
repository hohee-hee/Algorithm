import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][N];
        for(int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; c++) {
                land[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        boolean hasMoved;
        int day = 0;
        while(true){
            hasMoved= false;
            int[][] moved = new int[N][N]; // 오늘 체크 했는지
            for(int r = 0 ; r < N ; r++) Arrays.fill(moved[r], -1);

            for(int r = 0 ; r < N ; r++) {
                for(int c = 0 ; c < N ; c++) {
                    if(moved[r][c] != -1) continue;

                    stack.clear();

                    boolean[][] isVisited = new boolean[N][N]; // 이번 bfs에서 체크했는지
                    int population = land[r][c];
                    int unionCnt = 1;
                    q.clear();
                    q.offerLast(new int[]{r, c});
                    isVisited[r][c] = true;
                    stack.offerFirst(new int[]{r,c});
                    while(!q.isEmpty()) {
                        int cr = q.peekFirst()[0];
                        int cc = q.pollFirst()[1];
                        int cp = land[cr][cc];

                        for(int dir = 0 ; dir < 4 ; dir++){
                            int nr = cr + dr[dir];
                            int nc = cc + dc[dir];

                            if(nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc] || moved[nr][nc] != -1) continue;

                            int np = land[nr][nc];
                            if(Math.abs(cp-np) < L || Math.abs(cp-np) > R) continue;

                            q.offerLast(new int[]{nr,nc});
                            stack.offerFirst(new int[]{nr,nc});
                            isVisited[nr][nc] = true;
                            population += np;
                            unionCnt++;
                        }
                    }

                    if(unionCnt != 1) hasMoved = true;
                    int nPop = population / unionCnt;

                    while(!stack.isEmpty()) {
                        int tr = stack.peekFirst()[0];
                        int tc = stack.pollFirst()[1];
                        moved[tr][tc] = nPop;
                    }
                }
            }

            if(!hasMoved) break;

            land = moved;
            day++;
        }

        System.out.println(day);
    }
}