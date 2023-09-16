import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int tr = -1;
        int tc = -1;

        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];
        for(int i = 0 ; i < n ; i++) Arrays.fill(answer[i], -1);

        for(int r = 0 ; r < n ; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < m ; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 0) {
                  answer[r][c] = 0;
                } else if(map[r][c] == 2) {
                    tr = r;
                    tc = c;
                }
            }
        }

        // 2. BFS
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        boolean[][] isVisited = new boolean[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{tr,tc});
        answer[tr][tc] = 0;
        isVisited[tr][tc] = true;
        while(!queue.isEmpty()){
            int cr = queue.peekFirst()[0];
            int cc = queue.pollFirst()[1];

            for(int d = 0 ; d < 4 ; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                // out of idx
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                // 갈 수 없는 곳
                if(map[nr][nc] == 0) continue;

                // 이미 방문한 곳
                if(isVisited[nr][nc]) continue;

                answer[nr][nc] = answer[cr][cc] + 1;
                isVisited[nr][nc] = true;
                queue.offerLast(new int[]{nr,nc});
            }

        }

        for(int r = 0 ; r < n ; r++) {
            for(int c = 0 ; c < m ; c++) {
                sb.append(answer[r][c] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
