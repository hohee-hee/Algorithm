import java.io.*;
import java.util.*;

public class Main {
    public static int white, blue, N;
    public static int[][] paper;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for(int r = 0 ; r < N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0; blue = 0;
        // 초기 검사
        boolean isSame = true;
        int color = paper[0][0];
        initial: for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ; c++) {
                if(paper[r][c] != color) {
                    isSame = false;
                    break initial;
                }
            }
        }

        if(isSame) {
            if (color == 0) white++;
            else blue++;
        } else {
            white = 0;
            blue = 0;
            recursive(0, 0, N);
        }

        System.out.println(white);
        System.out.println(blue);
    }

    /**
     *
     * @param (현재 시작점의 r 좌표, 시작점의 c 좌표, 한 변의 길이)
     */
    public static void recursive(int r, int c, int len){
        // 1. 각 시작점 찾기 (4개)
        int[] rpt = new int[]{r, r + (len/2), r, r + (len/2)};
        int[] cpt = new int[]{c, c, c + (len/2), c + (len/2)};

        // 2. 사분면 별로 돌면서 분할을 해야하면 재귀 돌리기
        outer: for(int quad = 0 ; quad < 4 ; quad++){
            int cr = rpt[quad];
            int cc = cpt[quad];
            int color = paper[cr][cc];
            boolean isSame = true;

            for(int h = 0 ; h < (len/2) ; h++) {
                int nr = cr + h;
                for(int w = 0 ; w < (len/2) ; w++) {
                    int nc = cc + w;

                    if(paper[nr][nc] != color) {
                        isSame = false;
                        recursive(cr, cc, len/2);
                        continue outer;
                    }

                }
            }

            if(isSame) {
                if(color == 0) white++;
                else blue++;
            }

        }
    }
}