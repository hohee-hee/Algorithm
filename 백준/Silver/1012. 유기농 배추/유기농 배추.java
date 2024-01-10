import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] bat = new boolean[N][M];
            ArrayDeque<int[]> baechoo = new ArrayDeque<>();
            for(int i = 0 ; i < K ; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                baechoo.offerFirst(new int[]{Y,X});
                bat[Y][X] = true;
            }

            // bfs
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};
            boolean[][] isVisited = new boolean[N][M];
            int answer = 0;
            while(!baechoo.isEmpty()) {
                int pr = baechoo.peekFirst()[0];
                int pc = baechoo.pollFirst()[1];

                if(isVisited[pr][pc]) continue;

                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offerLast(new int[]{pr, pc});
                isVisited[pr][pc] = true;
                while(!q.isEmpty()) {
                    int cr = q.peekFirst()[0];
                    int cc = q.pollFirst()[1];

                    for(int dir = 0 ; dir < 4 ; dir++) {
                      int nr = cr + dr[dir];
                      int nc = cc + dc[dir];

                      if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                      if(isVisited[nr][nc]) continue;
                      if(!bat[nr][nc]) continue;

                      q.offerLast(new int[]{nr, nc});
                      isVisited[nr][nc] = true;

                    }
                }

                answer++;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}