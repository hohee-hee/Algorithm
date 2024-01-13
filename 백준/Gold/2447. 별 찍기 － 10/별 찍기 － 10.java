import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String[][] stars;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stars = new String[N][N];
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ; c++) {
                stars[r][c] = " ";
            }
        }

        star(0, 0, N);


        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ; c++) {
                sb.append(stars[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void star(int sr, int sc, int N){
        if(N == 3) {
            for(int r = 0 ; r < 3 ; r++) {
                for(int c = 0 ; c < 3 ; c++) {
                    if(r == 1 && c == 1) continue;
                    else stars[sr+r][sc+c] = "*";
                }
            }

            return;
        }

        int nlen = N/3;
        for(int r = 0 ; r < 3 ; r++) {
            for(int c = 0 ; c < 3 ; c++) {
                if(r == 1 && c == 1) continue;
                else star(sr+r*nlen, sc+c*nlen, nlen);
            }
        }


    }
}