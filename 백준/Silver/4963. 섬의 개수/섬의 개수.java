// 0:55 -

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(W == 0 && H == 0) break;

            // 입력
            boolean[][] map = new boolean[H][W];
            for(int r = 0 ; r < H ; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < W ; c++) {
                    if(Integer.parseInt(st.nextToken()) == 1) map[r][c] = true;
                }
            }

            // BFS
            int[] dr = {-1,0,1,0,-1,1,1,-1};
            int[] dc = {0,1,0,-1,1,1,-1,-1};
            boolean[][] isVisited = new boolean[H][W];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            int island = 0;

            for(int r = 0 ; r < H ; r++) {
                for(int c = 0 ; c < W ; c++) {
                    // 바다거나 이미 방문했으면 pass
                    if(isVisited[r][c] || !map[r][c]) continue;

                    isVisited[r][c] = true;
                    q.offerLast(new int[]{r,c});
                    while(!q.isEmpty()) {
                        int cr = q.peekFirst()[0];
                        int cc = q.pollFirst()[1];

                        for(int dir = 0 ; dir < 8 ; dir++) {
                            int nr = cr + dr[dir];
                            int nc = cc + dc[dir];

                            if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                            if(isVisited[nr][nc] || !map[nr][nc]) continue;

                            isVisited[nr][nc] = true;
                            q.offerLast(new int[]{nr,nc});
                        }
                    }
                    island++;
                }
            }

            sb.append(island).append("\n");

        }

        System.out.println(sb);
    }
}
