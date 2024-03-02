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

        int[][] brokenWall = new int[N+1][M+1];
        for(int r = 1 ; r <= N ; r++) Arrays.fill(brokenWall[r], N*M);
        brokenWall[1][1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        pq.offer(new int[]{1, 1, 0});

        while(!pq.isEmpty()) {
            int cr = pq.peek()[0];
            int cc = pq.peek()[1];
            int cw = pq.poll()[2];
            if(cw >= brokenWall[N][M]) break;
            for(int dir = 0 ; dir < 4 ; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr < 1 || nc < 1 || nr > N || nc > M) continue;

                int nw = maze[nr][nc] ? cw : cw + 1;
                if(brokenWall[nr][nc] > nw) {
                    brokenWall[nr][nc] = nw;
                    pq.offer(new int[]{nr, nc, nw});
                }
            }
        }

        System.out.println(brokenWall[N][M]);
    }
}

