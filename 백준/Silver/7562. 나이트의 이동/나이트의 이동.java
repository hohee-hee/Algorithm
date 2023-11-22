// 05:10

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        int[] dr = {-1,-2,-2,-1,1,2,2,1};
        int[] dc = {-2,-1,1,2,2,1,-1,-2};

        for(int t = 0 ; t < test ; t++) {
            int answer = 0;

            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tr = Integer.parseInt(st.nextToken());
            int tc = Integer.parseInt(st.nextToken());

            int[][] chess = new int[I][I];
            boolean[][] isVisited = new boolean[I][I];

            // BFS
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offerLast(new int[]{sr,sc,0});
            isVisited[sr][sc] = true;
            outer: while(!q.isEmpty()) {
                int cr = q.peekFirst()[0];
                int cc = q.peekFirst()[1];
                int cn = q.pollFirst()[2];

                for(int dir = 0 ; dir < 8 ; dir++) {
                    int nr = cr + dr[dir];
                    int nc = cc + dc[dir];

                    // idx chk
                    if(nr < 0 || nc < 0 || nr >= I || nc >= I) continue;

                    // visited
                    if(isVisited[nr][nc]) continue;

                    if(nr == tr && nc == tc){
                        answer = cn + 1;
                        break outer;
                    }

                    isVisited[nr][nc] = true;
                    q.offerLast(new int[]{nr,nc,cn+1});
                }

            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }
}
