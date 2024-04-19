import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int max = -1;
        int min = 257;
        int[][] ground = new int[N][M];
        for(int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; c++) {
                ground[r][c] = Integer.parseInt(st.nextToken());
                if(max < ground[r][c]) max = ground[r][c];
                if(min > ground[r][c]) min = ground[r][c];
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        int cb = B;
        int ct;
        for(int ch = min ; ch <= max ; ch++) {
            ct = 0;
            cb = B;
            chk : for(int r = 0 ; r < N ; r++) {
                for(int c = 0 ; c < M ; c++) {
                    if(ground[r][c] == ch) continue;

                    if(ground[r][c] < ch) {
                        cb -= ch - ground[r][c];
                        ct += ch - ground[r][c];
                    } else {
                        cb += ground[r][c] - ch;
                        ct += 2 * (ground[r][c] - ch);
                    }
                }
            }

            if(cb < 0) break;
            if(ct <= time) {
                time = ct;
                height = ch;
            }
        }

        System.out.println(time + " " + height);
    }
}