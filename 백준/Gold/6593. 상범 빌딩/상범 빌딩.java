import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 반복문 탈출 조건
            if(L == 0 && R == 0 && C == 0) break;

            char[][][] building = new char[L][R][C];
            int sh = 0; int sr = 0; int sc = 0; // 시작점
            int eh = 0; int er = 0; int ec = 0; // 탈출점

            for(int h = 0 ; h < L ; h++) {
                for(int r = 0 ; r < R ; r++) {
                    String row = br.readLine();
                    for(int c = 0 ; c < C ; c++) {
                        building[h][r][c] = row.charAt(c);
                        if(building[h][r][c] == 'S') {
                            sh = h; sr = r; sc = c;
                            building[h][r][c] = '.';
                        } else if(building[h][r][c] == 'E') {
                            eh = h; er = r; ec = c;
                            building[h][r][c] = '.';
                        }
                    }
                }
                br.readLine(); // 공백 제거
            }

            // bfs
            int[] dh = {0,0,0,0,1,-1};
            int[] dr = {-1,0,1,0,0,0};
            int[] dc = {0,1,0,-1,0,0};

            ArrayDeque<int[]> q = new ArrayDeque<>();
            int[][][] dist = new int[L][R][C];
            q.offerLast(new int[]{sh, sr, sc, 1});
            dist[sh][sr][sc] = 1;
            boolean success = false;

            bfs: while(!q.isEmpty()) {
                int ch = q.peekFirst()[0];
                int cr = q.peekFirst()[1];
                int cc = q.peekFirst()[2];
                int cd = q.pollFirst()[3];


                for(int dir = 0 ; dir < 6 ; dir++) {
                    int nh = ch + dh[dir];
                    int nr = cr + dr[dir];
                    int nc = cc + dc[dir];
                    int nd = cd + 1;

                    if(nh < 0 || nr < 0 || nc < 0 || nh >= L || nr >= R || nc >= C) continue;

                    if(building[nh][nr][nc] == '#') continue;

                    if(dist[nh][nr][nc] != 0) continue;

                    q.offerLast(new int[]{nh, nr, nc, nd});
                    dist[nh][nr][nc] = nd;

                    if(nh == eh && nr == er && nc == ec) break bfs;
                }
            }

            if(dist[eh][er][ec] == 0) sb.append("Trapped!").append("\n");
            else sb.append("Escaped in ").append(dist[eh][er][ec] - 1).append(" minute(s).").append("\n");

        }


        System.out.println(sb);
    }
}