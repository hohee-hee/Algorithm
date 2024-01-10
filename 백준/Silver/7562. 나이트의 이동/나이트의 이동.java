import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dr = {-1,-2,-2,-1,1,2,2,1};
        int[] dc = {-2,-1,1,2,2,1,-1,-2};

        for(int tc = 0 ; tc < T ; tc++) {
            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            if(sr == er && sc == ec) {
                sb.append(0).append("\n");
                continue;
            }

            int[][] board = new int[I][I];
            int[][] dist = new int[I][I];

            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offerLast(new int[]{sr, sc});
            dist[sr][sc] = 1;

            bfs: while(!q.isEmpty()) {
                int cr = q.peekFirst()[0];
                int cc = q.pollFirst()[1];

                for(int dir = 0 ; dir < 8 ; dir++) {
                    int nr = cr + dr[dir];
                    int nc = cc + dc[dir];

                    if(nr == er && nc == ec) {
                        sb.append(dist[cr][cc]).append("\n");
                        break bfs;
                    }

                    if(nr < 0 || nr >= I || nc < 0 || nc >= I) continue;
                    if(dist[nr][nc] > 0) continue;

                    q.offerLast(new int[]{nr, nc});
                    dist[nr][nc] = dist[cr][cc] + 1;
                }

            }

        }


        System.out.println(sb);
    }
}