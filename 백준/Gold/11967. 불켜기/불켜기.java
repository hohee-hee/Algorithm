import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N+1][M+1];
        map[1][1] = true;
        ArrayList<int[]>[][] switches = new ArrayList[N+1][M+1];
        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1 ; c <= M ; c++) {
                switches[r][c] = new ArrayList<>();
            }
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switches[x][y].add(new int[]{a, b});
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        int answer = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N+1][M+1];
        boolean[][] posVisited = new boolean[N+1][M+1];
        q.offerLast(new int[]{1,1});
        isVisited[1][1] = true;

        while(!q.isEmpty()) {
            int cr = q.peekFirst()[0];
            int cc = q.pollFirst()[1];
            // 불켜기
            for(int i = 0 ; i < switches[cr][cc].size() ; i++) {
                int tr = switches[cr][cc].get(i)[0];
                int tc = switches[cr][cc].get(i)[1];

                if(map[tr][tc]) continue;

                map[tr][tc] = true;
                answer++;

                if(posVisited[tr][tc]) {
                    isVisited[tr][tc] = true;
                    q.offerLast(new int[]{tr, tc});
                }
            }

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr < 1 || nc < 1 || nr > N || nc > M) continue;
                if(isVisited[nr][nc]) continue;
                if(map[nr][nc]) {
                    isVisited[nr][nc] = true;
                    q.offerLast(new int[]{nr, nc});
                } else {
                    posVisited[nr][nc] = true;
                }
            }
        }


        System.out.println(answer);
    }
}