import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] maze = new boolean[N+1][M+1];
        for(int r = 1 ; r <= N ; r++) {
            String str = br.readLine();
            for(int c = 1 ; c <= M ; c++) {
                if(str.charAt(c-1) == '0') maze[r][c] = true;
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        boolean[][] isVisited = new boolean[N+1][M+1];

        int[][] brokenWall = new int[N+1][M+1];
        for(int r = 1 ; r <= N ; r++) Arrays.fill(brokenWall[r], N*M);
        brokenWall[1][1] = 0;
        isVisited[1][1] = true;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{1, 1, 0});

        bfs: while(!dq.isEmpty()) {
            int cr = dq.peekFirst()[0];
            int cc = dq.peekFirst()[1];
            int cw = dq.pollFirst()[2];

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr == N && nc == M) {
                    System.out.println(cw);
                    return;
                }

                if(nr < 1 || nc < 1 || nr > N || nc > M) continue;
                if(isVisited[nr][nc]) continue;

                isVisited[nr][nc] = true;
                if(maze[nr][nc]) {
                    brokenWall[nr][nc] = cw;
                    dq.offerFirst(new int[]{nr, nc, cw});
                } else {
                    brokenWall[nr][nc] = cw+1;
                    dq.offerLast(new int[]{nr, nc, cw+1});
                }
            }
        }

        System.out.println(brokenWall[N][M]);
    }
}

