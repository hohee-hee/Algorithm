import java.io.*;
import java.util.*;

public class Main {
    public static int answer, N, H;
    public static boolean[][] isLadder;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        if(M == 0) {
            System.out.println(0);
            return;
        }

        isLadder = new boolean[H+2][N+1];
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isLadder[a][b] = true;
        }

        // 최초 값 검사
        if(isSuccess()) {
            System.out.println(0);
            return;
        }

        answer = -1;
        bt(0, 1);
        if(answer == -1) bt(0,2);
        if(answer == -1) bt(0,3);

        System.out.println(answer);
    }

    public static void bt(int cnt, int limit) {
        if(cnt != 0) {
            if(isSuccess() && answer == -1) {
                answer = cnt;
                return;
            }

            if(cnt == limit) return;
        }

        for(int r = 1 ; r <= H ; r++) {
            for(int c = 1; c < N ; c++) {
                if(isLadder[r][c]) continue; // 이미 사다리가 있을 때
                if(isLadder[r][c-1] || isLadder[r][c+1]) continue; // 사다리가 연속해서 그어질 때

                isLadder[r][c] = true;
                bt(cnt + 1, limit);
                isLadder[r][c] = false;
            }
        }
    }

    public static boolean isSuccess(){
        for(int i = 1 ; i <= N ; i++) {
            int cr = 0;
            int cc = i;

            while(cr < H+1) {
                int nr = cr + 1;
                int nc = cc;

                if(isLadder[nr][nc-1]) {
                    nc -= 1;
                } else if(isLadder[nr][nc]) {
                    nc += 1;
                }

                cr = nr;
                cc = nc;
            }

            if(cc != i) return false;
        }

       return true;
    }
}