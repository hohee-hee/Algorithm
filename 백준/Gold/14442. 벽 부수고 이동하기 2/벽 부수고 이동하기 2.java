import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];

        for(int r = 1 ; r <= N ; r++) {
            String str = br.readLine();
            for(int c = 1 ; c <= M ; c++) {
                map[r][c] = str.charAt(c-1) - '0';
            }
        }

        if(N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        int answer = -1;
        boolean isPos = false;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][][] isVisited = new boolean[K+1][N+1][M+1];
        q.offerLast(new int[]{1,1,1,0}); // {r,c,dist,부순 벽의 수}
        isVisited[0][1][1] = true;
        bfs: while(!q.isEmpty()) {
            int cr = q.peekFirst()[0];
            int cc = q.peekFirst()[1];
            int cd = q.peekFirst()[2];
            int cbw = q.pollFirst()[3];

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                int nd = cd + 1;

                if(nr < 1 || nc < 1 || nr > N || nc > M) continue;
                if(map[nr][nc] == 1) { // 벽일 때
                    if(cbw == K) continue;
                    if(isVisited[cbw+1][nr][nc]) continue;

                    isVisited[cbw+1][nr][nc] = true;
                    q.offerLast(new int[]{nr,nc,nd,cbw+1});
                } else { // 길일 때
                    if(nr == N && nc == M) {
                        answer = cd+1;
                        break bfs;
                    }
                    if(isVisited[cbw][nr][nc]) continue;

                    isVisited[cbw][nr][nc] = true;
                    q.offerLast(new int[]{nr,nc,nd,cbw});
                }

            }
        }

        System.out.println(answer);
    }
}

