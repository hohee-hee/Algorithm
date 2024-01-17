import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map;
    public static int[] dice;
    public static int N,M,x,y;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[]{0,0,0,0,0,0}; // 현재 기준 상단, 북, 동, 서, 남, 바닥
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++) {
            int command = Integer.parseInt(st.nextToken());

            diceRolling(command);
        }
        System.out.println(sb);
    }

    public static void diceRolling(int command) {
        // 순서
        // 1. 위치 이동
        // 2. 주사위 굴리기
        // 3. 바닥면 또는 지도 바꾸기
        if(command == 1) { // 동
            int ny = y + 1;
            if(ny < 0 || ny >= M) return;
            y = ny;
            relocatoin(dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]);
        } else if(command == 2) { // 서
            int ny = y - 1;
            if(ny < 0 || ny >= M) return;
            y = ny;
            relocatoin(dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]);
        } else if(command == 3) { // 북
            int nx = x - 1;
            if(nx < 0 || nx >= N) return;
            x = nx;
            relocatoin(dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]);
        } else { // 남
            int nx = x + 1;
            if(nx < 0 || nx >= N) return;
            x = nx;
            relocatoin(dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]);
        }

        if(map[x][y] == 0) {
            map[x][y] = dice[5];
        } else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        sb.append(dice[0]).append("\n");
    }

    public static void relocatoin(int up, int north, int east, int west, int south, int bottom){
        // 현재 기준 상단, 북, 동, 서, 남, 바닥
        dice[0] = up;
        dice[1] = north;
        dice[2] = east;
        dice[3] = west;
        dice[4] = south;
        dice[5] = bottom;
    }
}