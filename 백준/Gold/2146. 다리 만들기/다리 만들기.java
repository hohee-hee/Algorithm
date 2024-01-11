import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int r = 0 ; r < N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 섬 넘버링 하면서 가장자리 큐에 넣기
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int iNum = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayDeque<int[]> edge = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][N];
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ; c++) {
                if(map[r][c] == 0) continue;
                if(isVisited[r][c]) continue;

                boolean isEdge = false;
                q.offerLast(new int[]{r,c});
                isVisited[r][c] = true;
                map[r][c] = iNum;
                while(!q.isEmpty()) {
                    int cr = q.peekFirst()[0];
                    int cc = q.pollFirst()[1];

                    for(int dir = 0 ; dir < 4 ; dir++) {
                        int nr = cr + dr[dir];
                        int nc = cc + dc[dir];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if(isVisited[nr][nc]) continue;
                        if(map[nr][nc] == 0) {
                            isEdge = true;
                            continue;
                        }

                        q.offerLast(new int[]{nr, nc});
                        isVisited[nr][nc] = true;
                        map[nr][nc] = iNum;
                    }

                    if(isEdge) edge.offerLast(new int[]{cr,cc});
                    isEdge = false;
                }
                iNum++;
            }
        }

        // 3. 다리 잇기
        int answer = Integer.MAX_VALUE;
        while(!edge.isEmpty()) {
            int r = edge.peekFirst()[0];
            int c = edge.pollFirst()[1];

            isVisited = new boolean[N][N];
            q = new ArrayDeque<>();
            q.offerLast(new int[]{r,c,0});
            isVisited[r][c] = true;

            bfs: while(!q.isEmpty()) {
                int cr = q.peekFirst()[0];
                int cc = q.peekFirst()[1];
                int cd = q.pollFirst()[2];

                for(int dir = 0 ; dir < 4 ; dir++) {
                    int nr = cr + dr[dir];
                    int nc = cc + dc[dir];
                    int nd = cd + 1;

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(map[nr][nc] == map[r][c]) continue;
                    if(isVisited[nr][nc]) continue;

                    if(map[nr][nc] > 0 && map[nr][nc] != map[r][c]) {
                        if(answer > cd) answer = cd;
                        break bfs;
                    }

                    q.offerLast(new int[]{nr, nc, nd});
                    isVisited[nr][nc] = true;
                }
            }
        }


        // 3. 최단거리 구하기
        System.out.println(answer);
    }
}