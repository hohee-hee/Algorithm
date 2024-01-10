import java.io.*;
import java.util.*;

public class Main {

    public static char[][] building;
    public static int w,h;
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        test: for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            ArrayDeque<int[]> fire = new ArrayDeque<>();
            building = new char[h][w];
            int sr = 0;
            int sc = 0;

            for(int r = 0 ; r < h ; r++) {
                String row = br.readLine();
                for(int c = 0 ; c < w ; c++) {
                    building[r][c] = row.charAt(c);

                    if(building[r][c] == '@') {
                        sr = r;
                        sc = c;
                        building[r][c] = '.';
                    } else if(building[r][c] == '*') {
                        fire.offerLast(new int[]{r,c,1});
                    }
                }
            }


            int[][] dist = new int[h][w];
            boolean isEscaped = false;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offerLast(new int[]{sr, sc, 1});
            dist[sr][sc] = 1;

            int distchk = 1;

            bfs: while(!q.isEmpty()) {
                int cr = q.peekFirst()[0];
                int cc = q.peekFirst()[1];
                int cd = q.pollFirst()[2];

                if(distchk != cd+1) {
                    while(!fire.isEmpty()) {
                        int fcr = fire.peekFirst()[0];
                        int fcc = fire.peekFirst()[1];
                        int fcd = fire.peekFirst()[2];

                        if(fcd != distchk) break;

                        for(int dir = 0 ; dir < 4 ; dir++) {
                            int fnr = fcr + dr[dir];
                            int fnc = fcc + dc[dir];

//                            if(fnr == cr && fnc == cc) continue bfs;

                            if(fnr < 0 || fnr >= h || fnc < 0 || fnc >= w) continue;
                            if(building[fnr][fnc] != '.') continue;

                            building[fnr][fnc] = '*';
                            fire.offerLast(new int[]{fnr,fnc,fcd+1});
                        }

                        fire.pollFirst();
                    }
                    distchk++;
                }

                for(int dir = 0 ; dir < 4 ; dir++) {
                    int nr = cr + dr[dir];
                    int nc = cc + dc[dir];

                    if(nr < 0 || nr >= h || nc < 0 || nc >= w) {
                        sb.append(dist[cr][cc]).append("\n");
                        isEscaped = true;
                        break bfs;
                    }

                    if(building[nr][nc] != '.') continue;
                    if(dist[nr][nc] > 0) continue;

                    q.offerLast(new int[]{nr, nc, cd+1});
                    dist[nr][nc] = dist[cr][cc] + 1;
                }
            }
            if(!isEscaped) sb.append("IMPOSSIBLE").append("\n");
        }

        System.out.println(sb);
    }
}