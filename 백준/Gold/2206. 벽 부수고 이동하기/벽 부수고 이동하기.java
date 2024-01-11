import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 1.  입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int r = 0 ; r < N ; r++) {
            String str = br.readLine();
            for(int c = 0 ; c < M ; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        // 2. BFS
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        boolean[][] broken = new boolean[N][M];
        int answer = -1;

        q.offerLast(new int[]{0, 0, 1, 0});
        isVisited[0][0] = true;


        bfs: while(!q.isEmpty()) {
            int cr = q.peekFirst()[0];
            int cc = q.peekFirst()[1];
            int cd = q.peekFirst()[2];
            int cb = q.pollFirst()[3];

            if(cr == N-1 && cc == M-1) {
                answer = cd;
                break bfs;
            }

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                int nd = cd + 1;
                int nb = cb;

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(nb == 0 && isVisited[nr][nc]) continue;
                if(nb == 1 && broken[nr][nc]) continue;
                if(map[nr][nc] == 1) {
                    if(nb == 1) continue;
                    nb = 1;
                }

                q.offerLast(new int[]{nr,nc,nd,nb});
                if(nb == 0) isVisited[nr][nc] = true;
                else broken[nr][nc] = true;
            }
        }

        System.out.println(answer);
    }
}