import java.io.*;
import java.util.*;

public class Main {
    public static char[][] puyo;
    public static boolean[][] isBoomed;
    public static void main(String[] args) throws IOException{
        int answer = 0;

        puyo = new char[12][6];
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int r = 0 ; r < 12 ; r++) {
            String row = br.readLine();
            for(int c = 0 ; c < 6 ; c++) puyo[r][c] = row.charAt(c);
        }


        while(true) {
            // 1. 시작점 찾고 bfs 돌리기
            boolean[][] isChecked = new boolean[12][6];
            boolean isPos = false;
            isBoomed = new boolean[12][6];
            for(int r = 0 ; r < 12 ; r++) {
                for(int c = 0 ; c < 6 ; c++) {
                    if(isChecked[r][c]) continue;
                    if(puyo[r][c] == '.') continue;

                    char color = puyo[r][c];
                    ArrayDeque<int[]> boom = new ArrayDeque<>();
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    boolean[][] isVisited = new boolean[12][6];
                    q.offerLast(new int[]{r, c});
                    isVisited[r][c] = true;
                    isChecked[r][c] = true;
                    int cnt = 1;
                    while(!q.isEmpty()) {
                        int cr = q.peekFirst()[0];
                        int cc = q.pollFirst()[1];

                        for(int dir = 0 ; dir < 4 ; dir++) {
                            int nr = cr + dr[dir];
                            int nc = cc + dc[dir];

                            if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
                            if(isVisited[nr][nc]) continue;
                            if(puyo[nr][nc] != color) continue;
                            if(puyo[nr][nc] == '.') continue;

                            isVisited[nr][nc] = true;
                            isChecked[nr][nc] = true;
                            q.offerLast(new int[]{nr, nc});
                            cnt++;
                        }
                    }

                    if(cnt < 4) continue;

                    isPos = true;

                    for(int i = 0 ; i < 12 ; i++) {
                        for(int j = 0 ; j < 6 ; j++) {
                            if(isVisited[i][j]) isBoomed[i][j] = true;
                        }
                    }

                }
            }

            if(!isPos) break;

            answer++;
            brokenPuyos();
        }


        System.out.println(answer);
    }

    public static void brokenPuyos() {
        // . 으로 바꾸기
        for(int r = 0 ; r < 12 ; r++) {
            for(int c = 0 ; c < 6 ; c++) {
                if(isBoomed[r][c]) puyo[r][c] = '.';
            }
        }

        // puyo 내리기
        for(int c = 0 ; c < 6 ; c++) {
            for(int r = 11 ; r >= 0 ; r--) {
                if(puyo[r][c] == '.') {
                    for(int h = r - 1; h >= 0 ; h--) {
                        if(puyo[h][c] != '.') {
                            puyo[r][c] = puyo[h][c];
                            puyo[h][c] = '.';

                            break;
                        }
                    }
                }
            }
        }
    }
}