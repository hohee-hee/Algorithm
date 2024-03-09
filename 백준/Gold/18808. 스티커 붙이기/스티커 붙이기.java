import java.io.*;
import java.util.*;

public class Main{
    public static boolean[][] laptop;
    public static int N, M;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<boolean[][]> stickers = new ArrayList<>();
        for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            boolean[][] sticker = new boolean[R][C];

            for(int r = 0 ; r < R ; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < C ; c++) {
                    if(Integer.parseInt(st.nextToken()) == 1) sticker[r][c] = true;
                }
            }

            stickers.add(sticker);
        }

        int answer = 0;
        laptop = new boolean[N][M];

        for(int i = 0 ; i < K ; i++) {
            boolean[][] sticker = stickers.get(i);

            stick: for(int dir = 0 ; dir < 4 ; dir++){
                if(dir != 0) sticker = turn(sticker);
                for(int r = 0 ; r < N - sticker.length + 1  ; r++) {
                    for(int c = 0 ; c < M - sticker[0].length + 1 ; c++) {
                        if(isPos(sticker, r, c)) {
                            for(int r2 = 0 ; r2 < sticker.length ; r2++) {
                                for(int c2 = 0 ; c2 < sticker[0].length ; c2++) {
                                    if(sticker[r2][c2]) {
                                        laptop[r+r2][c+c2] = sticker[r2][c2];
                                        answer++;
                                    }
                                }
                            }
                            break stick;
                        }
                    }
                }
            }

        }

        System.out.println(answer);
    }

    public static boolean[][] turn(boolean[][] sticker){
        // 무조건 시계방향 90도 회전
        boolean[][] newSticker = new boolean[sticker[0].length][sticker.length];
        for(int r = 0 ; r < sticker[0].length ; r++) {
            for(int c = 0 ; c < sticker.length ; c++) {
                newSticker[r][c] = sticker[sticker.length - c - 1][r];
            }
        }
        return newSticker;
    }

    public static boolean isPos(boolean[][] sticker, int sr, int sc){
        boolean[][] laptopCopy = new boolean[N][M];

        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < M ; c++) {
                laptopCopy[r][c] = laptop[r][c];
            }
        }

        for(int r = 0 ; r < sticker.length ; r++) {
            for(int c = 0 ; c < sticker[0].length ; c++) {
                if(laptopCopy[sr+r][sc+c] && sticker[r][c]) return false;
                laptopCopy[sr+r][sc+c] = sticker[r][c];
            }
        }

        return true;
    }
}