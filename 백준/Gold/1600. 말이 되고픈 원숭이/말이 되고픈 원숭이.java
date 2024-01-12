import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] world = new int[H][W];
        for(int r = 0 ; r < H ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < W ; c++) {
                world[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1,0,1,0,-1,-2,-2,-1,1,2,2,1};
        int[] dc = {0,1,0,-1,-2,-1,1,2,2,1,-1,-2};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][][] dist = new int[K+1][H][W];
        q.offerLast(new int[]{0,0,0});
        dist[0][0][0] = 1;

        bfs: while(!q.isEmpty()) {
            int cr = q.peekFirst()[0];
            int cc = q.peekFirst()[1];
            int ck = q.pollFirst()[2];
            int cd = dist[ck][cr][cc];
            delta: for(int dir = 0 ; dir < 12 ; dir++) {
                if(dir > 3 && ck == K) break delta;

                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                int nk = dir > 3 ? ck + 1 : ck;
                int nd = cd + 1;

                if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if(world[nr][nc] == 1) continue;
                if(dist[nk][nr][nc] != 0 && dist[nk][nr][nc] <= nd) continue;

                q.offerLast(new int[]{nr, nc, nk});
                dist[nk][nr][nc] = nd;
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i <= K ; i++) {
            if(dist[i][H-1][W-1] != 0 && answer > dist[i][H-1][W-1]) answer = dist[i][H-1][W-1];
        }

        if(answer == Integer.MAX_VALUE) answer = -1;
        else answer--;
        System.out.println(answer);
    }
}