import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        // `1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] boxes = new int[H][N][M];
        ArrayDeque<int[]> tomatoes = new ArrayDeque<>();
        for(int h = 0 ; h < H ; h++) {
            for(int r = 0 ; r < N ; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < M ; c++) {
                    boxes[h][r][c] = Integer.parseInt(st.nextToken());

                    if(boxes[h][r][c] == 1) tomatoes.offerLast(new int[]{h,r,c});
                }
            }
        }

        // 2. bfs
        int[] dh = {0,0,0,0,-1,1};
        int[] dr = {-1,0,1,0,0,0};
        int[] dc = {0,1,0,-1,0,0};
        int[][][] dist = new int[H][N][M];
        while(!tomatoes.isEmpty()) {
            int ch = tomatoes.peekFirst()[0];
            int cr = tomatoes.peekFirst()[1];
            int cc = tomatoes.pollFirst()[2];
            int cd = dist[ch][cr][cc];

            for(int dir = 0 ; dir < 6 ; dir++) {
                int nh = ch + dh[dir];
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                int nd = cd + 1;

                if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(boxes[nh][nr][nc] != 0) continue;
                if(dist[nh][nr][nc] != 0 && dist[nh][nr][nc] < nd) continue;

                dist[nh][nr][nc] = nd;
                boxes[nh][nr][nc] = 1;
                tomatoes.offerLast(new int[]{nh,nr,nc});
            }
        }

        // 3. 답 찾기
        int answer = 0;
        outer: for(int h = 0 ; h < H ; h++) {
            for(int r = 0 ; r < N ; r++) {
                for(int c = 0 ; c < M ; c++) {
                    if(boxes[h][r][c] == -1) continue;

                    if(boxes[h][r][c] == 0) {
                        answer = -1;
                        break outer;
                    }

                    if(answer < dist[h][r][c]) answer = dist[h][r][c];
                }
            }
        }

        System.out.println(answer);
    }
}