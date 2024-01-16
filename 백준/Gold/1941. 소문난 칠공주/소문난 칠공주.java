import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb;
    public static char[][] girls = new char[5][5];
    public static boolean[][] isChosen = new boolean[5][5];
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};
    public static int[] per;
    public static int answer = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int r = 0 ; r < 5 ; r++) {
           String row = br.readLine();
            for(int c = 0 ; c < 5 ; c++) {
                girls[r][c] = row.charAt(c);
            }
        }

        per = new int[7];
        bt(0, 0);

        System.out.println(answer);
    }

    public static void bt(int pt, int pidx) {
        if(pidx == 7) {
            // SY 체크
            int dasom = 0;
            int doyeon = 0;
            for(int p = 0 ; p < 7 ; p++) {
                int cr = per[p] / 5;
                int cc = per[p] % 5;

                if(girls[cr][cc] == 'S') {
                    dasom++;
                } else {
                    doyeon++;
                }

                if(dasom > 3) break;
                if(doyeon > 3) return;
            }

            // 인접 체크 - bfs
            if(!bfs()) return;
            answer++;
            return;
        }

        for(int i = pt ; i < 25 ; i++) {
            per[pidx] = i;
            bt(i+1, pidx+1);
        }
    }

    public static boolean bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[5][5];
        int str = per[0] / 5;
        int stc = per[0] % 5;
        q.offerLast(new int[]{str, stc});
        isVisited[str][stc] = true;

        while(!q.isEmpty()) {
            int cr = q.peekFirst()[0];
            int cc = q.pollFirst()[1];

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
                if(isVisited[nr][nc]) continue;
                if(!isContain(nr, nc)) continue;

                isVisited[nr][nc] = true;
                q.offerLast(new int[]{nr, nc});
            }
        }

        for(int p = 0 ; p < 7 ; p++) {
            int tr = per[p] / 5;
            int tc = per[p] % 5;

            if(!isVisited[tr][tc]) return false;
        }

        return true;
    }

    public static boolean isContain(int r, int c){
        int num = r * 5 + c;

        for(int p = 0 ; p < 7 ; p++) {
            if(per[p] == num) return true;
        }

        return false;
    }

}