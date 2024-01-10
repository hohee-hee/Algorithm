import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] area = new int[N][M];
        ArrayDeque<int[]> iceberg = new ArrayDeque<>();
        for(int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; c++) {
                area[r][c] = Integer.parseInt(st.nextToken());
                if(area[r][c] != 0) iceberg.offerLast(new int[]{r,c,0});
            }
        }

        if(iceberg.size() == 0) {
            System.out.println(0);
            return;
        }

        // 2. 시뮬레이션
        int month = 0;
        boolean isSep = false;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(true) {
            // -1. 바다 개수 계산
            int[][] sea = new int[N][M];
            int icebergCnt = iceberg.size();
            for(int i = 0 ; i < icebergCnt ; i++) {
                int ir = iceberg.peekFirst()[0];
                int ic = iceberg.peekFirst()[1];
                int im = iceberg.pollFirst()[2];

                for(int dir = 0 ; dir < 4; dir++) {
                    int nr = ir + dr[dir];
                    int nc = ic + dc[dir];

                    if(area[nr][nc] == 0) sea[ir][ic]++;
                }

                iceberg.offerLast(new int[]{ir,ic,im});
            }

            // -2. 빙산 녹이기
            for(int i = 0 ; i < icebergCnt ; i++) {
                int ir = iceberg.peekFirst()[0];
                int ic = iceberg.peekFirst()[1];
                int im = iceberg.pollFirst()[2];

                if(month != im) break;

                area[ir][ic] -= sea[ir][ic];

                if(area[ir][ic] < 0) area[ir][ic] =0;
                if(area[ir][ic] != 0) iceberg.offerLast(new int[]{ir, ic, im+1});
            }

            // -3. 덩어리 개수 세기
            int group = 0;
            boolean[][] isVisited = new boolean[N][M];

            for(int r = 0 ; r < N ; r++) {
                for(int c = 0 ; c < M ; c++) {
                    if(area[r][c] == 0) continue;
                    if(isVisited[r][c]) continue;

                    ArrayDeque<int[]> q = new ArrayDeque<>();

                    q.offerLast(new int[]{r, c});
                    isVisited[r][c] = true;
                    while(!q.isEmpty()){
                        int cr = q.peekFirst()[0];
                        int cc = q.pollFirst()[1];

                        for(int dir = 0 ; dir < 4; dir++) {
                            int nr = cr + dr[dir];
                            int nc = cc + dc[dir];

                            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                            if(area[nr][nc] == 0) continue;
                            if(isVisited[nr][nc]) continue;

                            isVisited[nr][nc] = true;
                            q.offerLast(new int[]{nr,nc});
                        }
                    }
                    group++;
                }
            }

            if(group > 1) {
                isSep = true;
                break;
            } else if (group == 0) {
                isSep = false;
                break;
            }
            month++;
        }
        if(isSep) System.out.println(month+1);
        else System.out.println(0);
    }
}